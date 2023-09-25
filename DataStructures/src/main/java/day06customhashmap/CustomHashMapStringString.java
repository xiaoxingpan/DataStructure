package day06customhashmap;

public class CustomHashMapStringString {
    private class Container {
		Container next;
		String key;
		String value;
	}

	// size must be a prime number always
	private Container [] hashTable = new Container[5];
		
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
	
	void putValue(String key, String value) { }
	// LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length
	
	boolean hasKey(String key) { throw new RuntimeException("Not implemented yet");}

	// throw custom unchecked KeyNotFoundException
	String getValue(String key) { throw new RuntimeException("Not implemented yet"); }

	// throw custom unchecked KeyNotFoundException
    void deleteByKey(String key) { throw new RuntimeException("Not implemented yet");}

	public String[] getAllKeys() { throw new RuntimeException("Not implemented yet"); }
	// Generic version: public K[] getAllKeys(K[] template) { ... }
    
//	public Pair<String,String>[] getAllKeyValPairs() {
//		Pair<String,String> [] result = new Pair[totalItems];
//                return result;
//		throw new RuntimeException("Not implemented yet");
//	}
	

    int getSize() { return totalItems; }

	public void printDebug() { throw new RuntimeException("Not implemented yet"); } // print hashTable content, see example below

	@Override
	public String toString() { throw new RuntimeException("Not implemented yet"); } // comma-separated key->value pair list
	// to be able to use this as validation in Unit tests keys must be sorted
	// e.g. [ Key1 => Val1, Key2 => Val2, ... ]
}
    

