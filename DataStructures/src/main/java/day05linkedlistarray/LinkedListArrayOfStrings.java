package day05linkedlistarray;

public class LinkedListArrayOfStrings {

    private class Container {

        Container next;
        String value;
    }

    private Container start, end;
    private int size;

    public void add(String value) {
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

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertValueAtIndex(String value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == 0 || index == size) {
            add(value);
            return;
        }
        Container insert = new Container();
        insert.value = value;
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

    public void replaceValueAtIndex(String value, int index) {
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
    public boolean deleteByValue(String value) {
//        Container current = start;
//        int index = -1; // Initialize index to -1 (not found)
//
//        for (int i = 0; i < size; i++) {
//            current = current.next;
//            if (current.value.equals(value)) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            deleteByIndex(index);
//            return true;
//        }
//        return false;

        // doesn't rely on indices and works well for lists of any size
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
    public String[] toArray() {
        String[] result = new String[size];
        Container current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
}
