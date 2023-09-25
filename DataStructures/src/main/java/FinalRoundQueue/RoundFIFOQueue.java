package FinalRoundQueue;

public class RoundFIFOQueue<T extends Comparable> {

    private class Node {

        T value;
        Node next;
        int debugId; // optional, for debugging only
    }

    private Node enqueue, dequeue;
    // enquene points to the node where new values can be added
    // dequeue points to the node that was just added
    private int size;
    private int maxSize; // maxSize is assigned in the constructor

    public RoundFIFOQueue(int maxSize) {
        this.maxSize = maxSize;
        Node cont1 = new Node();
        enqueue = dequeue = cont1;
        cont1.debugId = 0;

        Node currentNode = cont1;
        for (int i = 1; i < maxSize; i++) {
            Node newCont = new Node();
            newCont.debugId = i;
            currentNode.next = newCont;
            newCont.next = cont1;
            currentNode = newCont;
        }
    }

    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        Node currentNode = enqueue;
        do {
            System.out.printf("Node debugId#%s: %s\n", currentNode.debugId, currentNode.value);
            currentNode = currentNode.next;
        } while (currentNode != enqueue);

        // Check if you have returned to enqueue
        if (currentNode != enqueue) {
            throw new RuntimeException("Internal error: queue may not be circular");
        }
    }

    // puts value into the queue
    // throws RuntimeException("No space in the queue") if queue is full
    // unless "grow" is set to true, in which case you can create a new Node so you can insert more than current maxSize
    // if you do - you need to update maxSize as well.
    public void enque(T value, boolean grow) {
        if (maxSize == size) {
            if (!grow) {
                throw new RuntimeException("No space in the queue");
            } else {
                Node newCont = new Node();
                newCont.value = value;
                newCont.debugId = maxSize;

                // find the node before dequeue
                Node beforeDequeue = enqueue;
                while (beforeDequeue.next != dequeue) {
                    beforeDequeue = beforeDequeue.next;
                }

                //insert the value
                newCont.next = beforeDequeue.next;
                beforeDequeue.next = newCont;
                enqueue = dequeue = newCont;
                maxSize++;
            }
        } else {
            enqueue.value = value;
            dequeue = enqueue;
            enqueue = enqueue.next;
        }
        size++;

    }

    // removes and returns value from the queue (in FIFO order)
    // throws RuntimeException("Queue is empty") if queue is empty
    // sets value reference to null of the Node whose value will be returned
    public T deque() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        T valueToReturn = dequeue.value;
        dequeue.value = null;

        // find the node before dequeue
        Node beforeDequeue = enqueue;
        while (beforeDequeue.next != dequeue) {
            beforeDequeue = beforeDequeue.next;
        }

        enqueue = dequeue;
        dequeue = beforeDequeue;
        size--;
        return valueToReturn;
    }

    public int size() {
        return size;
    }

    // returns array of "size" number of elements with most recently enqueued elements first (following "next" references)
    public T[] toArray(T[] template) {

        throw new RuntimeException("Not Implemented!");

    }

    // checks if value is present in Queue and returns the number of occurrences of that value (0 if not found)
    // must use n.compareTo(v) == 0, not equals()
    public int countValues(T value) {
        throw new RuntimeException("Not Implemented!");

    }

    // also implement methods required by Iterable interface (and test it in Unit tests)
}
