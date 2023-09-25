package day10binarytree;

import java.util.Iterator;

public class BinaryTreeOfIntsVisitable implements Iterable<Integer> {

    private VisitorInt<NodeOfInt> visitor;

    public void setVisitor(VisitorInt<NodeOfInt> visitor) {
        this.visitor = visitor;
    }
    
    public void traverseAllVisiting() {
        traverseInOrderVisiting(root);
    }
    
    private void traverseInOrderVisiting(NodeOfInt node) {
        // recursion must end at some point
        if (node == null) return;
        //
        traverseInOrderVisiting(node.left);
        if (visitor != null) {
            // node.accept(visitor);
            visitor.visit(node); // call to visitor via interface
        }
        traverseInOrderVisiting(node.right);
    }
    

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int[] resultArray = getValuesInOrder();
            int nextItemIndex = 0;

            @Override
            public boolean hasNext() {
                return (nextItemIndex < resultArray.length);
            }

            @Override
            public Integer next() {
                return resultArray[nextItemIndex++];
            }
        };
    }

    // class iteratorChildHkidden implements Iterator<Integer>() {...}
    // new iteratorChildHidden();
    
    // should change it to public class that allows visit
    class NodeOfInt {

        int value; // could also be key, value pair
        NodeOfInt left, right;
    }

    private NodeOfInt root;
    private int nodesCount;

    // throws exception if put attempts to insert value that already exists (a duplicate)
    public void put(int value) throws IllegalArgumentException {
        // if tree is empty
        if (root == null) {
            NodeOfInt newNode = new NodeOfInt();
            newNode.value = value;
            root = newNode;
            nodesCount++;
            return;
        }

        //iterate each data
        NodeOfInt currentNode = root;
        while (true) {
            // if data is duplicated
            if (currentNode.value == value) {
                throw new IllegalArgumentException("Valued already exists!");
            }
            if (currentNode.value > value) { // go left side
                if (currentNode.left == null) {
                    NodeOfInt newNode = new NodeOfInt();
                    newNode.value = value;
                    currentNode.left = newNode;
                    nodesCount++;
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else { // go right side
                if (currentNode.right == null) {
                    NodeOfInt newNode = new NodeOfInt();
                    newNode.value = value;
                    currentNode.right = newNode;
                    nodesCount++;
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public int getSize() {
        return nodesCount;
    }

    public boolean hasValue(int val) {
        NodeOfInt currentNode = root;
        while (currentNode != null) {
            // check the root data
            if (currentNode.value == val) {
                return true;
            }
            if (currentNode.value > val) { // go left side
                currentNode = currentNode.left;
            } else if (currentNode.value < val) { // go right side
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    // uses recursion to compute the sum of all values in the entire tree
    public int getSumOfAllValues() {

        return getSumOfThisAndSubNodes(root);

    }

    // private helper recursive method to implement the above method
    private int getSumOfThisAndSubNodes(NodeOfInt node) {
        if (node == null) {
            return 0;
        }
        int sumOfSubtree = node.value;
        sumOfSubtree += getSumOfThisAndSubNodes(node.left);
        sumOfSubtree += getSumOfThisAndSubNodes(node.right);
        return sumOfSubtree;
    }

    // uses recursion to collect all values from largest to smallest
    public int[] getValuesInOrder() { // from largest to smallest
        resultArray = new int[nodesCount];
        resultIndex = 0;
        collectValuesInOrder(root);
        assert (resultIndex == nodesCount);
        return resultArray;
    }

    // private helper recursive method to implement the above method
    private void collectValuesInOrder(NodeOfInt node) {
        if (node == null) {
            return;
        }

        collectValuesInOrder(node.right);
        resultArray[resultIndex++] = node.value;
        collectValuesInOrder(node.left);
    }
    // data structures used to make collecting values in order easier
    private int[] resultArray;
    private int resultIndex;
}
