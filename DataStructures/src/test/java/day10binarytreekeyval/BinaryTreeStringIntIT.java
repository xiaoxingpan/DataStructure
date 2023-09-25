package day10binarytreekeyval;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeStringIntIT {

    BinaryTreeStringInt instance;
    private ByteArrayOutputStream outputStream;

    private Person jerry;
    private Person terry;
    private Person larry;
    private Person barry;
    private Person maria;
    private Person martha;

    class Person {

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

        @Override
        public String toString() {
            return name + "^" + age;
        }

        @Override
        public boolean equals(Object obj) {
            Person other = (Person) obj;
            return name.equals(other.name) && (age == other.age);
        }

    }

    @BeforeEach
    public void setUp() {
        instance = new BinaryTreeStringInt();
        jerry = new Person("Jerry", 23);
        terry = new Person("Terry", 34);
        larry = new Person("Larry", 29);
        barry = new Person("Barry", 40);
        maria = new Person("Maria", 27);
        martha = new Person("Martha", 31);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Test of put method, of class BinaryTreeStringInt.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        instance.put(jerry.name, jerry.age);
        assertThrows(RuntimeException.class, () -> instance.getValByKey(larry.name), "Expected an RuntimeException");
        instance.put(terry.name, terry.age);
        instance.put(maria.name, maria.age);
        assertEquals(34, instance.getValByKey(terry.name), "Test failed");

    }

    /**
     * Test of getValByKey method, of class BinaryTreeStringInt.
     */
    @Test
    public void testGetValByKey() {
        System.out.println("getValByKey");
        instance.put(jerry.name, jerry.age);
        instance.put(terry.name, terry.age);
        instance.put(maria.name, maria.age);
        instance.put(larry.name, larry.age);
        instance.put(barry.name, barry.age);
        instance.put(martha.name, martha.age);
        assertThrows(RuntimeException.class, () -> instance.getValByKey("Tom"), "Expected an RuntimeException");
        assertEquals(27, instance.getValByKey(maria.name), "Test failed");
        assertEquals(23, instance.getValByKey(jerry.name), "Test failed");
    }

    /**
     * Test of printAllKeyValPairs method, of class BinaryTreeStringInt.
     */
    @Test
    public void testPrintAllKeyValPairs() {
        System.out.println("printAllKeyValPairs");
        instance.put(jerry.name, jerry.age);
        instance.put(terry.name, terry.age);
        instance.put(maria.name, maria.age);

        instance.printAllKeyValPairs();
        String printedOutput = outputStream.toString().trim(); 
        String expectedOutput = "printAllKeyValPairs\nJerry:23\nMaria:27\nTerry:34";
        assertEquals(expectedOutput, printedOutput);
    }

}
