package day05arraylistownimpl;

public class Day05ArrayListOwn {

    private int[] data = new int[2]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    public int size() {
        return size;
    }

    public int length() {
        return data.length;
    }

    private void checkIfHasMoreSpace() {
        if (data.length == size) {
            // array is full -grow it
            int[] newArray = new int[data.length * 2];
            // copy the element
            for (int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }

    public void add(int value) {
        checkIfHasMoreSpace();
        data[size++] = value;
    }

    // shows items that we really have, ensure no reference leak
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        } else {
            return data[index];
        }

    }

    public void deleteByIndex(int index) {
        if (index >= size || index < 0) {
            System.out.println("Invalid index");
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        } else {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
    }

    // delete first value matching, true if value found, false otherwise
    public boolean deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    public void insertValueAtIndex(int value, int index) {
        checkIfHasMoreSpace();
        // if index = size, add to the end
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == size + 1) {
            add(index);
        } else {
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = value;
            size++;
        }

    }

    public void clear() {
        size = 0;
    }

    public int[] getSlice(int startIdx, int length) {
        if (startIdx < 0 || startIdx >= size || (startIdx + length) > size || length < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + startIdx);
        }
        int[] slice = new int[length];
        System.out.print("Slice: [");
        for (int i = 0; i < slice.length; i++) {
            slice[i] = data[startIdx++];
            System.out.print(slice[i]);
            if (i < slice.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        return slice;
    }

// returns String similar to: [3, 5, 6, -23]
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(String.format("%d%s", data[i], (i == size - 1 ? "" : ", ")));
        }
        res.append("]");
        return res.toString();
    }

    public void newMethod(int value) {
        throw new RuntimeException("Not implemented yet");
    }
}
