package day10binarytreekeyval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<K extends Comparable, V> implements Iterable<Pair<K, V>> {

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<Pair<K, V>>() {
            
            Pair<K,V> [] data = getPairsInOrder();
            int nextIndex;
            
            @Override
            public boolean hasNext() {
                return nextIndex < data.length;
            }

            @Override
            public Pair<K, V> next() {
                return data[nextIndex++];
            }
        };
    }

    private class Node {

        K key;
        V value;
        Node left, right;
    }

    private Node root;
    private int nodesCount;

    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    public void put(K key, V value) {
        // if tree is empty
        if (root == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            root = newNode;
            nodesCount++;
            return;
        }

        //iterate each data
        Node currentNode = root;
        while (true) {
            int res = key.compareTo(currentNode.key);
            // if key is duplicated
            if (res == 0) {
                currentNode.value = value;
                return;
            } else if (res < 0) { // go left side
                if (currentNode.left == null) {
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.key = key;
                    currentNode.left = newNode;
                    nodesCount++;
                    return;
                }
                currentNode = currentNode.left;
            } else { // go right side
                if (currentNode.right == null) {
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.key = key;
                    currentNode.right = newNode;
                    nodesCount++;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    // throws exception if key is not found, otherwise returns the value
    public V getValByKey(K key) throws RuntimeException {
        Node currentNode = root;
        while (currentNode != null) {
            int res = key.compareTo(currentNode.key);
            // check the root key
            if (res == 0) {
                return currentNode.value;
            } else if (res > 0) { // go right side
                currentNode = currentNode.right;
            } else { // go left side
                currentNode = currentNode.left;
            }
        }

        // key not founded
        throw new RuntimeException();

    }

    // print out all key-value pairs (one per line) from the smallest key to the largest
    public void printAllKeyValPairs() {
        traversalKeyValPairsInOrder(root);
    }

    private void traversalKeyValPairsInOrder(Node node) {
        if (node == null) {
            return;
        }
        traversalKeyValPairsInOrder(node.left);
        System.out.println(node.key.toString() + ":" + node.value.toString());
//        System.out.printf("%s => %s\n", node.key.toString(), node.value.toString());
        traversalKeyValPairsInOrder(node.right);
    }

    
    // return all keys from smallest to largest (alphabetically)
    K[] getKeysInOrder(K[] template) {
        resultArray = (K[]) java.lang.reflect.Array.newInstance(template.getClass().getComponentType(), nodesCount);
        resultIndex = 0;
        traversalKeyInOrder(root);
        return resultArray;
    }
    
    // private helper recursive method to implement the above method
    private void traversalKeyInOrder(Node node) {
        if (node == null) {
            return;
        }
        traversalKeyInOrder(node.left);
        resultArray[resultIndex++] = node.key;
        traversalKeyInOrder(node.right);
    }
    private K[] resultArray;
    private int resultIndex;
    private K[] template;

    public BinaryTree(K[] template) {
        this.template = template;
    }
    
     // return pairs of keys and values from smallest to largest (alphabetically)
    Pair<K,V>[] getPairsInOrder() {
        Pair<K,V> []pairArrayTemplate = new Pair[0]; // ???
        // resultKeysValuesArray = new Pair<K,V>[nodesCount];
        resultKeysValuesArray = (Pair<K,V>[])java.lang.reflect.Array.newInstance(pairArrayTemplate.getClass().getComponentType(), nodesCount);
        resultKeysValuesIndex = 0;
        collectKeysValuesInOrder(root);
        return resultKeysValuesArray;
    }

    // private helper recursive method to implement the above method
    private void collectKeysValuesInOrder(Node node) {
        // recursion must end at some point
        if (node == null) {
            return;
        }
        // handle recursion
        collectKeysValuesInOrder(node.left);
        resultKeysValuesArray[resultKeysValuesIndex++] = new Pair<K,V>(node.key, node.value);
        collectKeysValuesInOrder(node.right);
    }

    private Pair<K,V>[] resultKeysValuesArray;
    private int resultKeysValuesIndex;
}
