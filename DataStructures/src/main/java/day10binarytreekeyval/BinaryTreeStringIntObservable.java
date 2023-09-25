package day10binarytreekeyval;

public class BinaryTreeStringIntObservable {

    private ObserverInt<Node> observer;

    public void setObserver(ObserverInt<Node> observer) {
        this.observer = observer;
    }

    class Node {

        String key;
        int value;
        Node left, right;
    }

    private Node root;
    private int nodesCount;

    // if put attempts to insert a key that already exists then value is updated (no exception is thrown)
    // values may be duplicates but keys may not
    public void put(String key, int value) {
        // if tree is empty
        if (root == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            root = newNode;
            nodesCount++;
            if (observer != null) {
                observer.added(newNode);
            }
            return;
        }

        //iterate each data
        Node currentNode = root;
        while (true) {
            int res = key.compareTo(currentNode.key);
            // if key is duplicated
            if (res == 0) {
                int oldVal = currentNode.value;
                currentNode.value = value;
                if (observer != null) {
                    Node oldNodeVal = new Node();
                    oldNodeVal.value = oldVal;
                    observer.modified(oldNodeVal, currentNode);
                }
                return;
            }
            if (res < 0) { // go left side
                if (currentNode.left == null) {
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.key = key;
                    currentNode.left = newNode;
                    nodesCount++;
                    if (observer != null) {
                        observer.added(newNode);
                    }
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.key = key;
                    currentNode.right = newNode;
                    nodesCount++;
                    if (observer != null) {
                        observer.added(newNode);
                    }
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }
    // throws exception if key is not found, otherwise returns the value

    public int getValByKey(String key) throws RuntimeException {
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
    public void printAllKeyValPairs() { // from smallest to largest
        traversalKeyValPairsInOrder(root);
    }

    // private helper recursive method to implement the above method
    private void traversalKeyValPairsInOrder(Node node) {
        if (node == null) {
            return;
        }
        traversalKeyValPairsInOrder(node.left);
        System.out.println(node.key + ":" + node.value);
//      System.out.printf("%s => %d\n", node.key, node.value);
        traversalKeyValPairsInOrder(node.right);
    }
}
