
/**
 * Created by david on 4/19/16.
 */
public class HashMap implements hash {
    int tableSize;
    String[] keyTable;
    int[] valueTable;
    int size;
    float loadFactor = 0.70f;
    Prime primeNumberGenerator;

    HashMap() {
        clear();
    }

    @Override
    public void put(String key, int value) {
        if (key == null) {
            return;
        }
        checkOverflow();
        key = key.toLowerCase();
        int index = hash(key, this.tableSize);
        index = checkIndex(key, index, this.keyTable, this.tableSize);
        if (keyTable[index] != null) {
            if (keyTable[index].compareTo(key) == 0) {
                size -= 1;
            }
        }
        keyTable[index] = key;
        valueTable[index] = value;
        size += 1;
    }

    @Override
    public Integer get(String key) {
        if (key == null) {
            return null;
        }
        key = key.toLowerCase();
        int index = hash(key, this.tableSize);
        index = checkIndex(key, index, this.keyTable, this.tableSize);
        if (keyTable[index] == null) {
            return null;
        }
        return valueTable[index];
    }

    @Override
    public void delete(String key) {
        if (key == null) {
            return;
        }
        key = key.toLowerCase();
        int index = hash(key, this.tableSize);
        index = checkIndex(key, index, this.keyTable, this.tableSize);
        if (keyTable[index] != null) {
            keyTable[index] = null;
            valueTable[index] = 0;
            size -= 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            return false;
        }
        key = key.toLowerCase();
        int index = hash(key, this.tableSize);
        index = checkIndex(key, index, this.keyTable, this.tableSize);
        if (keyTable[index] == null) {
            return false;
        }
        return true;
    }

    public void clear() {
        primeNumberGenerator = new Prime(7);
        tableSize = primeNumberGenerator.nextPrime();
        keyTable = new String[tableSize];
        valueTable = new int[tableSize];
        size = 0;
    }

    public String[] keys() {
        // TODO: added this for Watch support, need to return enumerator instead
        String[] keys = new String[size];
        int unUsedIndex = 0;

        for (String key: this.keyTable) {
            if (key != null) {
                keys[unUsedIndex] = key;
            }
        }
        return keys;
    }

    private int hash(String key, int tableSize) {
        int sum = 0;

        for (int i=0; i < key.length(); i++) {
            sum += (int) key.charAt(i) * (i + 1);
        }
        return sum % tableSize;
    }

    private boolean indexTaken(String key, int index, String[] keyTable) {
        if (keyTable[index] == null) {
            return false;
        }
        else if (keyTable[index].compareTo(key) == 0) {
            return false;
        }
        return true;
    }

    private int checkIndex(String key, int index, String[] keyTable, int tableSize) {
        if (indexTaken(key, index, keyTable)) {
            index = rehash(index, tableSize);
            checkIndex(key, index, keyTable, tableSize);
        }
        return index;
    }

    private int rehash(int index, int tableSize) {
        if (index >= tableSize) {
            index = 0;
        }
        return (index + 3) % tableSize;
    }

    private void checkOverflow() {
        if ((float) size / (float) tableSize > loadFactor) {
            int newTableSize = primeNumberGenerator.nextPrime();
            String[] newKeyTable = new String[newTableSize];
            int[] newValueTable = new int[newTableSize];

            for (String key: this.keyTable) {
                if (key != null) {
                    int value = get(key);

                    int index = hash(key, newTableSize);
                    index = checkIndex(key, index, newKeyTable, newTableSize);
                    newKeyTable[index] = key;
                    newValueTable[index] = value;
                }
            }
            this.keyTable = newKeyTable;
            this.valueTable = newValueTable;
            this.tableSize = newTableSize;
        }
    }
}
