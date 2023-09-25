package day10binarytreekeyval;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeIT {

    BinaryTree<String, String> instance;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        instance = new BinaryTree<>(new String[0]);
        instance.put("Jerry", "Teacher");
        instance.put("Terry", "Farmer");
        instance.put("Lerry", "Cook");
        instance.put("Nancy", "Officer");
        instance.put("Maria", "Engineer");
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Test of put method, of class BinaryTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        assertEquals("Teacher", instance.getValByKey("Jerry"));
        assertThrows(RuntimeException.class, () -> instance.getValByKey("Luca"), "Expected an RuntimeException");

    }

    /**
     * Test of getValByKey method, of class BinaryTree.
     */
    @Test
    public void testGetValByKey() {
        System.out.println("getValByKey");
        assertEquals("Engineer", instance.getValByKey("Maria"));
        assertThrows(RuntimeException.class, () -> instance.getValByKey("Sum"), "Expected an RuntimeException");
        assertEquals("Officer", instance.getValByKey("Nancy"));

    }

    /**
     * Test of printAllKeyValPairs method, of class BinaryTree.
     */
    @Test
    public void testPrintAllKeyValPairs() {
        System.out.println("printAllKeyValPairs");
        instance.printAllKeyValPairs();
        String printedOutput = outputStream.toString().trim();
        String expectedOutput = "printAllKeyValPairs\nJerry:Teacher\nLerry:Cook\nMaria:Engineer\nNancy:Officer\nTerry:Farmer";
        assertEquals(expectedOutput, printedOutput);
    }

    /**
     * Test of getKeysInOrder method, of class BinaryTree.
     */
    @Test
    public void testGetKeysInOrder() {
        assertArrayEquals(new String[]{"Jerry", "Lerry", "Maria", "Nancy", "Terry"}, instance.getKeysInOrder(new String[0]));

    }

    /**
     * Test of getPairsInOrder method, of class BinaryTree.
     */
    @Test
    public void testGetPairsInOrder() {
        Pair<String, String>[] pairArray = new Pair[5]; // Creating an array of 5 pairs
        pairArray[0] = new Pair<>("Jerry", "Teacher");
        pairArray[1] = new Pair<>("Lerry", "Cook");
        pairArray[2] = new Pair<>("Maria", "Engineer");
        pairArray[3] = new Pair<>("Nancy", "Officer");
        pairArray[4] = new Pair<>("Terry", "Farmer");

        assertArrayEquals(pairArray, instance.getPairsInOrder());

    }

    /**
     * Test of iterator, of class BinaryTree.
     */
    @Test
    public void testIterator() {

        for (Pair<String, String> pair : instance.getPairsInOrder()) {
            System.out.printf("%s:%s\n", pair.key, pair.value);
        }
        String printedOutput = outputStream.toString().trim();
        String expectedOutput = "Jerry:Teacher\nLerry:Cook\nMaria:Engineer\nNancy:Officer\nTerry:Farmer";
        assertEquals(expectedOutput, printedOutput);
    }

}
