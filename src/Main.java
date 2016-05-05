import junit.framework.TestCase;

import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Created by david on 4/19/16.
 */
public class Main extends TestCase {

    public static void main(String[] args) {
        Watch myWatch = new Watch("Blank");
        testHashMap();
        testPrimeNumberGenerator();
        testCustomEnumerator();
        myWatch.printResults();
    }

    private static void testHashMap() {
        Watch myWatch = new Watch("testHashMap");
        myWatch.start();
        testHashAddItems();
        testHashClear();
        testHashRemove();
        testHashManipulate();
        testHashOverflow();
        testHashOverwrite();
        testHashKeys();
        testHashElements();
        myWatch.stop();
    }

    private static void testHashAddItems() {
        HashMap myMap = new HashMap();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        assertEquals(4, myMap.size());
        assertEquals((Integer) 1, myMap.get("one"));
        assertEquals((Integer) 2, myMap.get("two"));
        assertEquals((Integer) 3, myMap.get("three"));
        assertEquals((Integer) 4, myMap.get("four"));
    }

    private static void testHashKeys() {
        HashMap myMap = new HashMap();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        enumerator myEnum = myMap.keys();
        assertEquals("four", myEnum.nextElement());
        assertEquals("three", myEnum.nextElement());
        assertEquals("one", myEnum.nextElement());
        assertEquals("two", myEnum.nextElement());
    }

    private static void testHashElements() {
        HashMap myMap = new HashMap();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        enumerator myEnum = myMap.elements();
        assertEquals(4, myEnum.nextElement());
        assertEquals(3, myEnum.nextElement());
        assertEquals(1, myEnum.nextElement());
        assertEquals(2, myEnum.nextElement());
    }

    private static void testHashClear() {
        HashMap myMap = new HashMap();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        myMap.clear();
        assertEquals(0, myMap.size());
    }

    private static void testHashRemove() {
        HashMap myMap = new HashMap();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        myMap.remove("three");
        assertNull(myMap.get("three"));
        myMap.clear();
    }

    private static void testHashManipulate() {
        HashMap myMap = new HashMap();
        assertEquals(0, myMap.size());
        assertNull(myMap.get(null));
        assertNull(myMap.get("one"));
        assertFalse(myMap.contains("one"));
        myMap.remove(null);
        myMap.remove("one");
        myMap.put(null, -1);
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        assertNull(myMap.get(null));
        assertEquals((Integer) 1, myMap.get("one"));
        assertEquals((Integer) 2, myMap.get("two"));
        assertEquals((Integer) 3, myMap.get("three"));
        assertFalse(myMap.contains(null));
        assertTrue(myMap.contains("one"));
        assertTrue(myMap.contains("two"));
        assertTrue(myMap.contains("three"));
        myMap.remove(null);
        myMap.remove("one");
        myMap.remove("two");
        myMap.remove("three");
        assertFalse(myMap.contains(null));
        assertFalse(myMap.contains("one"));
        assertFalse(myMap.contains("two"));
        assertFalse(myMap.contains("three"));
        assertEquals(0, myMap.size());
    }

    private static void testHashOverflow() {
        HashMap myMap = new HashMap();
        myMap.put("cat", 12);
        assertTrue(myMap.contains("cat"));
        myMap.put("tac", 123);
        assertTrue(myMap.contains("tac"));
        assertTrue(myMap.contains("cat"));
        myMap.remove("tac");
        assertFalse(myMap.contains("tac"));
        int numberOfItems = 100000;
        String[] myStrings = new String[numberOfItems];
        String starter = "E";
        for (int i=0; i < numberOfItems; i++) {
            myStrings[i] = starter + i;
        }
        for (int i=0; i < myStrings.length; i++) {
            myMap.put(myStrings[i], i);
        }
    }

    private static void testHashOverwrite() {
        HashMap myMap = new HashMap();
        myMap.put("cat", 12);
        assertEquals((Integer) 12, myMap.get("cat"));
        myMap.put("cat", 18);
        assertEquals((Integer) 18, myMap.get("cat"));
    }

    private static void testPrimeNumberGenerator() {
        Watch myWatch = new Watch("testPrimeNumberGenerator");
        myWatch.start();
        Prime myPrime = new Prime(11);
        int i = 0;
        while (i < 1001) {
            myPrime.nextPrime();
            i++;
        }
        myWatch.stop();
    }

    private static void testCustomEnumerator() {
        Watch myWatch = new Watch("testCustomEnumerator");
        myWatch.start();
        int size = 10;
        String[] myKeys = new String[size];
        int[] myValues = new int[size];
        String[] randomCharacters = new String[size];

        randomCharacters[0] = "a";
        randomCharacters[1] = "b";
        randomCharacters[2] = "c";
        randomCharacters[3] = "d";
        randomCharacters[4] = "e";
        randomCharacters[5] = "f";
        randomCharacters[6] = "g";
        randomCharacters[7] = "h";
        randomCharacters[8] = "i";
        randomCharacters[9] = "j";
        int i = 0;

        while (i < size) {
            myKeys[i] = randomCharacters[i];
            myValues[i] = i;
            i++;
        }

        CustomEnumerator enumerator = new CustomEnumerator(size, myKeys, myValues, true);
        i = 0;
        while (i < 10) {
            enumerator.nextElement();
            i++;
        }
        myWatch.stop();
    }

}
