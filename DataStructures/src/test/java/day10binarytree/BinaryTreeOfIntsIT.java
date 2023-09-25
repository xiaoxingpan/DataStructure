package day10binarytree;

import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeOfIntsIT {

    BinaryTreeOfInts instance;

    @BeforeEach
    public void setUp() {
        instance = new BinaryTreeOfInts();
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of put/getValuesInOrder/getSize/hasValue method, of class
     * BinaryTreeOfInts.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        instance.put(5);
        assertArrayEquals(new int[]{5}, instance.getValuesInOrder(), "Test Failed");
        assertEquals(1, instance.getSize(), "Failed to get size");
        assertThrows(IllegalArgumentException.class, () -> instance.put(5), "Expected an IllegalArgumentException");
        instance.put(3);
        instance.put(7);
        instance.put(2);
        assertEquals(4, instance.getSize(), "Failed to get size");
        assertEquals(true, instance.hasValue(3), "hasValue method failed");
        assertEquals(false, instance.hasValue(9), "hasValue method failed");
        assertArrayEquals(new int[]{7, 5, 3, 2}, instance.getValuesInOrder(), "Test Failed");
        assertEquals(17, instance.getSumOfAllValues(), "Failed to get sum");

    }

    /**
     * Test of getSize method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        assertEquals(0, instance.getSize());
        instance.put(5);
        assertEquals(1, instance.getSize(), "Failed to get size");
        instance.put(3);
        instance.put(7);
        assertEquals(3, instance.getSize(), "Failed to get size");
        assertThrows(IllegalArgumentException.class, () -> instance.put(3), "Expected an IllegalArgumentException");
        assertEquals(3, instance.getSize(), "Failed to get size");
        assertEquals(15, instance.getSumOfAllValues(), "Failed to get sum");

    }

    /**
     * Test of hasValue method, of class BinaryTreeOfInts.
     */
    @Test
    public void testHasValue() {
        System.out.println("hasValue");
        instance.put(5);
        instance.put(3);
        instance.put(7);
        instance.put(2);
        instance.put(9);
        assertEquals(false, instance.hasValue(10));
        assertEquals(true, instance.hasValue(2));
        assertEquals(26, instance.getSumOfAllValues(), "Failed to get sum");
        assertArrayEquals(new int[]{9, 7, 5, 3, 2}, instance.getValuesInOrder(), "Test Failed");

    }

    /**
     * Test of getSumOfAllValues method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetSumOfAllValues() {
        System.out.println("getSumOfAllValues");
        instance.put(5);
        instance.put(3);
        instance.put(7);
        instance.put(2);
        instance.put(9);
        instance.put(13);
        instance.put(1);
        instance.put(0);
        instance.put(11);
        instance.put(20);
        assertEquals(71, instance.getSumOfAllValues(), "Failed to get sum");
        assertArrayEquals(new int[]{20, 13, 11, 9, 7, 5, 3, 2, 1, 0}, instance.getValuesInOrder(), "Test Failed");

    }

    /**
     * Test of getValuesInOrder method, of class BinaryTreeOfInts.
     */
    @Test
    public void testGetValuesInOrder() {
        System.out.println("getValuesInOrder");
        instance.put(45);
        instance.put(88);
        instance.put(79);
        instance.put(26);
        instance.put(50);
        instance.put(35);
        instance.put(23);
        instance.put(21);
        instance.put(60);
        instance.put(71);
        assertEquals(498, instance.getSumOfAllValues(), "Failed to get sum");
        assertArrayEquals(new int[]{88, 79, 71, 60, 50, 45, 35, 26, 23, 21}, instance.getValuesInOrder(), "Test Failed");
        assertEquals(false, instance.hasValue(48));
        assertEquals(true, instance.hasValue(26));
        assertEquals(10, instance.getSize(), "Failed to get size");
    }

    /**
     * Test of iterator
     */
    @Test
    public void testIterator() {
        System.out.println("testIterator");
        int[] data = {25, 30, 13, 23, 45, 63, 43, 42};
        for (int i : data) {
            instance.put(i);
        }
        int[] resultArray = instance.getValuesInOrder();

        for (int i : instance) {
            for (int n = 0; n < resultArray.length; n++) {
                resultArray[n] = i;
            }
        }
//            Iterator<Integer> iterator = instance.iterator();
//            for (int n = 0; n < resultArray.length; n++) {
//                assertEquals(resultArray[n], iterator.next(), "Failed to get size");
//
//            }
    }

}
