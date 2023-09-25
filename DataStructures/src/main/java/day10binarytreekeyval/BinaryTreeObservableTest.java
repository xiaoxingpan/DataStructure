package day10binarytreekeyval;

public class BinaryTreeObservableTest {

    public static void main(String[] args) {
        BinaryTreeStringIntObservable tree = new BinaryTreeStringIntObservable();
        tree.setObserver(new ObserverInt<BinaryTreeStringIntObservable.Node>() {
            @Override
            public void added(BinaryTreeStringIntObservable.Node node) {
                System.out.printf("Added: %s -> %d\n", node.key, node.value);
            }

            @Override
            public void modified(BinaryTreeStringIntObservable.Node nodeOld, BinaryTreeStringIntObservable.Node nodeNew) {
                System.out.printf("Modified: %s -> (%d became %d)\n", nodeNew.key, nodeOld.value, nodeNew.value);
            }

            @Override
            public void deleted(BinaryTreeStringIntObservable.Node node) {
                System.out.printf("Deleted: %s -> %d\n", node.key, node.value);
            }
        });

        tree.put("Jerry", 183);
        tree.put("Terry", 177);
        tree.put("Barry", 190);
        tree.put("Larry", 167);
        tree.put("Barry", 187);
    }

}
