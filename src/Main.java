import junit.framework.TestCase;

/**
 * Created by david on 4/19/16.
 */
public class Main extends TestCase {

    public static void main(String[] args) {
        Watch myWatch = new Watch("Blank");
        testHashMap();
//        testPrimeNumberGenerator();
        myWatch.printResults();
    }

    private static void testHashMap() {
        Watch myWatch = new Watch("HashMap");
        myWatch.start();
        testHashAddItems();
        testHashClear();
        testHashRemove();
        testHashManipulate();
        testHashOverflow();
        testHashOverwrite();
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
        myMap.delete("three");
        assertNull(myMap.get("three"));
        myMap.clear();
    }

    private static void testHashManipulate() {
        HashMap myMap = new HashMap();
        assertEquals(0, myMap.size());
        assertNull(myMap.get(null));
        assertNull(myMap.get("one"));
        assertFalse(myMap.contains("one"));
        myMap.delete(null);
        myMap.delete("one");
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
        myMap.delete(null);
        myMap.delete("one");
        myMap.delete("two");
        myMap.delete("three");
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
        myMap.delete("tac");
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
        Watch myWatch = new Watch("PrimeNumbers");
        myWatch.start();
        Prime myPrime = new Prime(11);
        int i = 0;
        while (i < 1001) {
            System.out.print(myPrime.nextPrime());
            System.out.println("\n");
            i++;
        }
        myWatch.stop();
    }
}
