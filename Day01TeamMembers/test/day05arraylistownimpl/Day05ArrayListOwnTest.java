
package day05arraylistownimpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author xiaoxingpan
 */
public class Day05ArrayListOwnTest {
    
    public Day05ArrayListOwnTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
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
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Day05ArrayListOwn.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Day05ArrayListOwn.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int value = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class Day05ArrayListOwn.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        int[] expResult = null;
        int[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Day05ArrayListOwn.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        int expResult = 0;
        int result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByIndex method, of class Day05ArrayListOwn.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        instance.deleteByIndex(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByValue method, of class Day05ArrayListOwn.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        int value = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        boolean expResult = false;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertValueAtIndex method, of class Day05ArrayListOwn.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        int value = 0;
        int index = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        instance.insertValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Day05ArrayListOwn.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSlice method, of class Day05ArrayListOwn.
     */
    @Test
    public void testGetSlice() {
        System.out.println("getSlice");
        int startIdx = 0;
        int length = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        int[] expResult = null;
        int[] result = instance.getSlice(startIdx, length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Day05ArrayListOwn.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newMethod method, of class Day05ArrayListOwn.
     */
    @Test
    public void testNewMethod() {
        System.out.println("newMethod");
        int value = 0;
        Day05ArrayListOwn instance = new Day05ArrayListOwn();
        instance.newMethod(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
