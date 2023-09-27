package FinalRoundQueue;

import java.util.Iterator;

public class RoundFIFOQueue<T extends Comparable> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
                private Node current = dequeue;

                @Override
                public boolean hasNext() {
                    return current != enqueue.next;
                }

                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new RuntimeException("No next element");
                    }
                    T value = current.value;
                    current = current.next;
                    return value;
                }
            };
    }

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

    // start with enqueue data
    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        Node currentNode = enqueue;
        int i = 0;
        do {
            System.out.printf("Node debugId#%s: %s\n", currentNode.debugId, currentNode.value);
            currentNode = currentNode.next;
            i++;
        } while (i < size);

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
                size++;
            }
        } else {
            size++;
            enqueue.value = value;
            dequeue = enqueue;
            if (size != maxSize) {
                enqueue = enqueue.next;
            }
        }

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

    // start with dequeue data
    public T[] toArray(T[] template) {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);
        Node currentNode = dequeue;

        int i = 0;
        do {
            result[i] = currentNode.value;
            currentNode = currentNode.next;
            i++;
        } while (i < size);

        return result;
    }

// checks if value is present in Queue and returns the number of occurrences of that value (0 if not found)
// must use n.compareTo(v) == 0, not equals()
    public int countValues(T value) {
        int count = 0;
        Node currentNode = enqueue;

        for (int i = 0; i < size; i++) {
            if (currentNode.value != null && currentNode.value.compareTo(value) == 0) {
                count++;
            }
            currentNode = currentNode.next;
        }

        return count;

    }

}
