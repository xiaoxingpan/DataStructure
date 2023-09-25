package day05linkedlistarray;

public class LinkedListArray<T> {

    private class Container {

        Container next;
        T value;
    }

    private Container start, end;
    private int size;

    public void add(T value) {
        Container newCont = new Container();
        newCont.value = value;
        if (size == 0) {
            start = end = newCont;
        } else {
            end.next = newCont; // Update the next reference of the previous end container
            end = newCont; // Update the end reference to the new container
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertValueAtIndex(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == 0 || index == size) {
            add(value);
            return;
        }
        Container insert = new Container();
        insert.value = (T) value;
        if (index == 0) { // insert at the start of a non-empty list
            insert.next = start;
            start = insert;
            size++;
            return;
        }
        Container before = start;
        for (int i = 0; i < index - 1; i++) {
            before = before.next;
        }
        insert.next = before.next;
        before.next = insert;
        size++;
    }

    public void replaceValueAtIndex(T value, int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public void deleteByIndex(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            start = start.next;
            size--;
            // If size is now 0, also nullify 'end' for garbage collection
            if (size == 0) {
                end = null;
            }
            return;
        }
        Container before = start;
        for (int i = 0; i < index - 1; i++) {
            before = before.next;
        }
        if (index == size - 1) {
            end = before;
            before.next = null;
        } else {
            before.next = before.next.next;
        }
        size--;
    }

    // delete first value found
    public boolean deleteByValue(T value) {
        int count = 0;
        Container current = start;
        while (current != null) {
            if (current.value.equals(value)) {
                deleteByIndex(count);
                return true;
            }
            current = current.next;
            count++;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    // comma-separated values list similar to: [5,8,11]
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        Container current = start;
        for (int i = 0; i < size; i++) {
            res.append(current.value);
            current = current.next;
            res.append(i == size - 1 ? "" : ",");
        }
        res.append("]");
        return res.toString();
    }

    // could be used for Unit testing
    public T[] toArray(T[] template) {
        // T[] result = new T[size]; // this won't compile
//        T[] result = (T[]) new Object[size]; // will compiler but then crash at runtime
        // T[] result = (T[]) Array.newInstance(template.getClass(), size); // fails on storing value into the array
        T[] result = (T[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), size);
//        T[] result = (T[]) new Object[size];
        Container current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
}
