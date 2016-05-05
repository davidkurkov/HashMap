import java.util.ArrayList;

/**
 * Created by david on 5/4/16.
 */
public class CustomEnumerator implements enumerator {

    String[] myKeys;
    int[] myValues;
    int size;
    int current = 0;
    boolean returnKeys;

    CustomEnumerator(int size, String[] keys, int[] values, boolean isString) {
        if (isString) {
            myKeys = new String[size];
            loadKeys(keys);
        }
        else {
            myValues = new int[size];
            loadValues(values, size);
        }
        this.size = size;
        this.returnKeys = isString;
    }

    @Override
    public boolean hasMoreElements() {
        return this.current <= size;
    }

    @Override
    public Object nextElement() throws IndexOutOfBoundsException {
        if (this.current == size) {
            return null;
        }
        Object key = null;
        if (this.returnKeys) {
            key = myKeys[this.current];
        }
        else {
            key = myValues[this.current];
        }
        this.current++;
        return key;
    }

    private void loadKeys(String[] keys) {
        int i = 0;
        for (String key: keys) {
            this.myKeys[i] = key;
            i++;
        }
    }

    private void loadValues(int[] values, int size) {
        int i = 0;
        for (int value: values) {
            this.myValues[i] = value;
            i++;
        }
    }
}
