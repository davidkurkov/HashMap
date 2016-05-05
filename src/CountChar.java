
/**
 * Created by david on 5/5/16.
 */
public class CountChar {
    hash myHashMap;

    public char count(String data) throws Exception, IllegalArgumentException {
        if (data == null || data.compareTo("") == 0) {
            throw new IllegalArgumentException("Inputted data was either null or an empty string");
        }
        myHashMap = new HashMap();
        char[] myCharArray;
        myCharArray = splitData(data.toLowerCase());
        countChars(myCharArray);
        Object mostFrequentChar = findFrequentlyOccuringChar();
        return mostFrequentChar.toString().charAt(0);
    }

    private char[] splitData(String rawData) {
        char[] tempCharArray = new char[rawData.length()];
        int i = 0;
        while (i < rawData.length()) {
            tempCharArray[i] = rawData.charAt(i);
            i++;
        }
        return tempCharArray;
    }
    
    private void countChars(char[] myCharArray) {
        for (char c: myCharArray) {
            Integer value = this.myHashMap.get(String.valueOf(c));
            if (value == null) {
                value = 0;
            }
            value++;
            this.myHashMap.put(String.valueOf(c), value);
        }
    }

    private Object findFrequentlyOccuringChar() throws Exception {
        enumerator myEnum = myHashMap.keys();
        Object key = myEnum.nextElement();
        Object character = null;
        int largest = 0;
        int value;
        boolean hasIdentical = false;

        while (key != null) {
            value = myHashMap.get(String.valueOf(key));
            if (value == largest) {
                hasIdentical = true;
            }
            if (value > largest) {
                hasIdentical = false;
                largest = value;
                character = key;
            }
            key = myEnum.nextElement();
        }

        if (hasIdentical) {
            throw new Exception("More than one char is frequently occuring");
        }
        return character;
    }

}
