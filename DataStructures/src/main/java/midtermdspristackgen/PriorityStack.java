package midtermdspristackgen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PriorityStack<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Container current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No");
                }
                T value = current.value;
                current = current.nextBelow;
                return value;
            }
        };
    }

    private class Container {

        T value;
        boolean hasPriority;
        Container nextBelow;
    }

    private Container top;

    private int size;

    public void push(T value) {
        push(value, false);
    }

    public void push(T value, boolean hasPriority) {
        Container newCont = new Container();
        newCont.value = value;
        newCont.hasPriority = hasPriority;

        // add at index 0
        newCont.nextBelow = top;
        top = newCont;
        size++;
    }

    // remove and return the top item
    // if no item found (size == 0) then throw NoSuchElementException
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("The size is 0");
        }
        Container deleteCont = top;
        top = top.nextBelow;
        size--;
        return deleteCont.value;
    }

    // find an item with priority starting from the top, remove it and return it
    // if no priority item found then remove and return the top item
    // if stack is empty then throw NoSuchElementException
    public T popPriority() {
        if (size == 0) {
            throw new NoSuchElementException("The size is 0");
        }
        Container current = top;
        // if the first one
        if (current.hasPriority) {
            return pop();
        }
        while (current.nextBelow != null) {
            Container next = current.nextBelow;
            if (next.hasPriority) {
                current.nextBelow = next.nextBelow;
                size--;
                return next.value;
            }
            current = next;
        }
        return pop();
    }

    public int hasValue(T value) {
        if (size == 0) {
            return -1;
        }
        int count = 0;
        Container current = top;
        while (current != null) {
            if (current.value.equals(value)) {
                return count;
            }
            current = current.nextBelow;
            count++;
        }
        return -1;
    }

    // removes the first item from top containing the value and returns the value
    // if item with value is not found throw NoSuchElementException
    public T removeValue(T value) {
        Container current = top;
        // if it's the first value
        if (current.value.equals(value)) {
            return pop();
        }
        while (current.nextBelow != null) {
            Container next = current.nextBelow;
            if (next.value.equals(value)) {
                current.nextBelow = next.nextBelow;
                size--;
                return next.value;
            }
            current = next;
        }
        // no value founded
        throw new NoSuchElementException("No such value");
    }

    public int getSize() {
        return size;
    }

    // reorder items (re-create a new stack, if you like)
    // where all priority items are on top and non-priority items are below them
    // Note: order within the priority items group and non-priority items group must remain the same
    public void reorderByPriority() {
        PriorityStack<T> reorderedStack = new PriorityStack<>();
        PriorityStack<T> tempStack = new PriorityStack<>();

        // Push priority items to the reorderedStack
        Container pointer = top;
        while (size != 0) {
            if (pointer.hasPriority) {
                tempStack.push(pointer.value, true);
            }
            if (pointer.nextBelow != null) {
                pointer = pointer.nextBelow;
            } else {
                break;
            }
        }
        pointer = top;
        while (size != 0) {
            if (!pointer.hasPriority) {
                tempStack.push(pointer.value);
            }
            if (pointer.nextBelow != null) {
                pointer = pointer.nextBelow;
            } else {
                break;
            }
        }

        while (tempStack.size != 0) {
            if (tempStack.top.hasPriority) {
                reorderedStack.push(tempStack.pop(), true);
            } else {
                reorderedStack.push(tempStack.pop());
            }
        }
        // Update the current stack to be the reordered stack
        this.top = reorderedStack.top;
        this.size = reorderedStack.size;
    }
   
    // Format exactly like this (assuming T is a String to keep it simple):
    // "[Jerry:N,Terry:N,Martha:P,Tom:P,Jimmy:N]"       
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        Container current = top;
        for (int i = 0; i < size; i++) {
            res.append(current.value.toString());
            res.append(":");
            res.append(current.hasPriority ? "P" : "N");
            current = current.nextBelow;
            res.append(i == size - 1 ? "" : ",");
        }
        res.append("]");
        return res.toString();
    }

    // you may need these fields to implement toArrayReversed
    private T[] reversed;
    private int reversedCount;

    public T[] toArrayReversed(/* may need a parameter - template type */) {
        throw new RuntimeException("Not implemented yet");
// Note: this is "the twist"
        // return array with items on the stack
        // WARNING: element 0 of the array must be the BOTTOM of the stack
        // NOTE: To obtain full marks for this method you must use recursion.
        // Collect items on your way back, just before returning from each method call.
        // This case is similar to when constructors of parent classes are called (Programming II course).
    }

// NOTE: *ONLY* implement this method if you can't implement toArrayReversed.
// Make sure to add a unit test for it later.
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        Container current = top;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.nextBelow;
        }
        return result;
    }

}
