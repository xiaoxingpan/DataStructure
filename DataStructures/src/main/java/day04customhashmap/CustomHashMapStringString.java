package day04customhashmap;

public class CustomHashMapStringString {

    private class Container {

        Container next;
        String key;
        String value;
    }

    // size must be a prime number always
    private Container[] hashTable = new Container[5];

    private int totalItems;

    private int computeHashValue(String key) { // hashing function
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            // hash *= 3;
            hash <<= 1;  // same as: hash *= ...
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }

    void putValue(String key, String value) {
        int hash = computeHashValue(key);
        int index = hash % hashTable.length;

        Container newCont = new Container();
        newCont.key = key;
        newCont.value = value;
        // no data in index
        if (hashTable[index] == null) {
            hashTable[index] = newCont;
        } else {
            // check if the key exist
            Container currCont = hashTable[index];
            while (currCont != null) {
                if (currCont.key.equals(key)) {
                    currCont.value = value; // update existing entry
                    return;
                }
                currCont = currCont.next;
            }
//            for (Container currCont = hashTable[index]; currCont != null; currCont = currCont.next) {
//                if (currCont.key.equals(key)) { // found the same key, replace value
//                    currCont.value = value; // update existing entry
//                    return;
//                }
//            }
            newCont.next = hashTable[index];
            hashTable[index] = newCont;
        }
        totalItems++;
    }
    // LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length

    boolean hasKey(String key) {
        int hash = computeHashValue(key);
        int index = hash % hashTable.length;
        Container currCont = hashTable[index];
        while (currCont != null) {
            if (currCont.key.equals(key)) {
                return true;
            }
            currCont = currCont.next;
        }
        return false;
    }

    // throw custom unchecked KeyNotFoundException
    String getValue(String key) {
        throw new RuntimeException();
    }

    // throw custom unchecked KeyNotFoundException
    void deleteByKey(String key) {
        throw new RuntimeException();
    }

    public String[] getAllKeys() {

        throw new RuntimeException();
    }
    // Generic version: public K[] getAllKeys(K[] template) { ... }

    public Pair<String, String>[] getAllKeyValPairs() {
        Pair<String, String>[] result = new Pair[totalItems];
        throw new RuntimeException();

    }

    int getSize() {
        return totalItems;
    }

    public void printDebug() {
        throw new RuntimeException();
    } // print hashTable content, see example below

    @Override
    public String toString() {
        throw new RuntimeException();
    } // comma-separated key->value pair list
    // to be able to use this as validation in Unit tests keys must be sorted
    // e.g. [ Key1 => Val1, Key2 => Val2, ... ]

    public class Pair<K, V> {

        K key;
        V val;
    }
}
