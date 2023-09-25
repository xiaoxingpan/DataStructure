package day05arraylistownimpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Day05ArrayListOwnTest {

    Day05ArrayListOwn instance;

    @BeforeAll
    public static void setUpClass() {
        // link to database
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Day05ArrayListOwn();
//        int [] instanceData = { 3, 5, 7, 9};
//        instance = new Day05ArrayListOwn();
//        for (int i = 0; i < instanceData.length; i++) {
//            instance.add(instanceData[i]);
//        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of size method, of class Day05ArrayListOwn.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        instance.clear();
        assertEquals(0, instance.size(), "Test Failed");
    }

    /**
     * Test of length method, of class Day05ArrayListOwn.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        assertEquals(2, instance.length(), "Test Failed");
    }

    /**
     * Test of add method/size/length, of class Day05ArrayListOwn. When the
     * array has more space
     */
    @Test
    public void testAddHasMoreSpace() {
        System.out.println("add");
        instance.add(3);
        assertEquals(1, instance.size(), "Test size Failed");
        assertEquals(2, instance.length(), "Test length Failed");
    }

    /**
     * Test of add method/size/length/toArray, of class Day05ArrayListOwn. when
     * size = length
     */
    @Test
    public void testAddNoMoreSpace() {
        System.out.println("add");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        assertEquals(3, instance.size(), "Test size Failed");
        assertEquals(4, instance.length(), "Test length Failed");
        int[] expectedArray = {3, 5, 7};
        assertArrayEquals(expectedArray, instance.toArray(), "Test toarray Failed");
        assertEquals("[3, 5, 7]", instance.toString(), "Test tostring Failed");
    }

    /**
     * Test of get method, of class Day05ArrayListOwn.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        instance.add(3);
        instance.add(5);
        instance.add(7);

        assertEquals(3, instance.get(0), "failed to get the first element");
        assertEquals(7, instance.get(2), "failed to get the last element");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.get(3), "Expected an ArrayIndexOutOfBoundsException");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.get(-1), "Expected an ArrayIndexOutOfBoundsException");

    }

    /**
     * Test of deleteByIndex method, of class Day05ArrayListOwn.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        instance.add(2);
        instance.add(4);

        assertEquals(5, instance.size(), "Test size Failed");
        assertEquals(8, instance.length(), "Test length Failed");

        assertArrayEquals(new int[]{3, 5, 7, 2, 4}, instance.toArray(), "Test toarray Failed");
        assertEquals("[3, 5, 7, 2, 4]", instance.toString(), "Test tostring Failed");

        instance.deleteByIndex(0);
        assertEquals("[5, 7, 2, 4]", instance.toString(), "Failed to delete the first element");
        assertEquals(7, instance.get(1), "failed to get element");

        instance.deleteByIndex(3);
        assertEquals("[5, 7, 2]", instance.toString(), "failed to delete the last element");

        instance.deleteByIndex(1);
        assertEquals("[5, 2]", instance.toString(), "failed to delete the last element");
    }

    /**
     * Test of deleteByValue method, of class Day05ArrayListOwn.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        instance.add(2);
        instance.add(4);

        assertEquals(false, instance.deleteByValue(9), "delete value that doesn't exist failed");
        assertEquals(true, instance.deleteByValue(7), "delete value that doesn't exist failed");
    }

    /**
     * Test of insertValueAtIndex method, of class Day05ArrayListOwn.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        instance.add(2);
        instance.add(4);

        instance.insertValueAtIndex(9, 0);
        instance.insertValueAtIndex(8, 5);
        instance.insertValueAtIndex(7, 1);
        assertArrayEquals(new int[]{9, 7, 3, 5, 7, 2, 8, 4}, instance.toArray(), "Failed to insert value at index");

        assertEquals(2, instance.get(5), "Fail to get element");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.insertValueAtIndex(9, 9), "Expected an ArrayIndexOutOfBoundsException");
    }

    /**
     * Test of clear method, of class Day05ArrayListOwn.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        instance.add(2);
        instance.add(4);
        instance.clear();
        assertEquals(0, instance.size(), "failed to clear the size");
        assertEquals("[]", instance.toString(), "tostring failed when size is 0");
    }

    /**
     * Test of getSlice method, of class Day05ArrayListOwn.
     */
    @Test
    public void testGetSlice() {
        System.out.println("getSlice");
        instance.add(3);
        instance.add(5);
        instance.add(7);
        instance.add(2);
        instance.add(4);
        instance.add(8);
        instance.add(9);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.getSlice(-1, 3
        ), "Expected an ArrayIndexOutOfBoundsException");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.getSlice(7, 3
        ), "Expected an ArrayIndexOutOfBoundsException");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> instance.getSlice(3, -1
        ), "Expected an ArrayIndexOutOfBoundsException");

        assertArrayEquals(new int[]{2, 4, 8, 9}, instance.getSlice(3, 4), "Failed to get slice");
    }
}
