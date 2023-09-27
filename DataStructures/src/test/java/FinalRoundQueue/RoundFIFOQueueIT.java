package FinalRoundQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoundFIFOQueueIT {

    RoundFIFOQueue<Integer> instance;

    @BeforeEach
    public void setUp() {
        instance = new RoundFIFOQueue<>(5);
    }

    /**
     * Test of enque method, of class RoundFIFOQueue.
     */
    @Test
    public void testEnque() {
        System.out.println("enque");
        instance.enque(1, false);
        assertEquals(1, instance.size());
        instance.enque(2, false);
        instance.enque(3, false);
        instance.enque(4, false);
        instance.enque(5, false);
        assertThrows(RuntimeException.class, () -> instance.enque(6, false), "Expected RuntimeException when enqueuing to a full queue without grow");
        assertArrayEquals(new Integer[]{5, 1, 2, 3, 4}, instance.toArray(new Integer[0]));
//        // deque the last insert
//        assertEquals(6, instance.deque());
        assertEquals(5, instance.deque());

    }

    /**
     * Test of deque method, of class RoundFIFOQueue.
     */

    @Test
    public void testDeque() {
        System.out.println("deque");
        instance.enque(1, false);

        instance.enque(2, false);
        instance.enque(3, false);
        instance.enque(4, false);
        instance.enque(5, false);

        assertEquals(5, instance.deque());

    }

    /**
     * Test of size method, of class RoundFIFOQueue.
     */

    @Test
    public void testSize() {
        System.out.println("size");
        instance.enque(1, false);
        instance.enque(2, false);
        instance.enque(3, false);
        instance.enque(4, false);
        instance.enque(5, false);
        assertEquals(5, instance.size());

    }
//
//    /**
//     * Test of toArray method, of class RoundFIFOQueue.
//     */

    @Test
    public void testToArray() {
        System.out.println("toArray");

        instance.enque(1, false);
        instance.enque(2, false);
        instance.enque(3, false);
        instance.enque(4, false);
        instance.enque(5, false);

        assertArrayEquals(new Integer[]{5, 1, 2, 3, 4}, instance.toArray(new Integer[0]));
    }
//
//    /**
//     * Test of countValues method, of class RoundFIFOQueue.
//     */

    @Test
    public void testCountValues() {
        System.out.println("countValues");
        instance.enque(1, false);
        instance.enque(2, false);
        instance.enque(3, false);
        instance.enque(4, false);
        instance.enque(5, false);
        instance.enque(5, true);

        int result = instance.countValues(5);
        assertEquals(2, result);

    }

}
