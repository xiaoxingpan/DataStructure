/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day10binarytree;

/**
 *
 * @author xiaoxingpan
 */
class PrintingVisitor implements VisitorInt<BinaryTreeOfIntsVisitable.NodeOfInt> {

    @Override
    public void visit(BinaryTreeOfIntsVisitable.NodeOfInt node) {
        System.out.printf("Visited node %s with value %d\n", node, node.value);
    }
}
public class BinaryTree {

    public static void main(String[] args) {
        //test visit
        BinaryTreeOfIntsVisitable test = new BinaryTreeOfIntsVisitable();
        int[] data = {3, 9, 1, 5, 11, 2};
        for (int n : data) {
            test.put(n);

        }
        for (int i : test) {
            System.out.println("Val " + i);
        }

        // first way, use PrintingVisitor class
        test.setVisitor(new PrintingVisitor());
        test.traverseAllVisiting();


        // second way, don't need the PrintingVisitorclass
        test.setVisitor(new VisitorInt<BinaryTreeOfIntsVisitable.NodeOfInt>() {
            int sum = 0;

            @Override
            public void visit(BinaryTreeOfIntsVisitable.NodeOfInt node) {
                sum += node.value;
                System.out.println("sum so far is " + sum);
            }
        });
        test.traverseAllVisiting();

//        // test iterator
        BinaryTreeOfInts tree = new BinaryTreeOfInts();
        int[] vals = {3, 9, 1, 5, 11, 2};
        for (int n : vals) {
            tree.put(n);
        }

        for (int i : tree) {
            System.out.println("Val " + i);        
        }
    }
}
