package org.morshed.tree;

public class TreeTest {
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(7);
    tree.insert(4);
    tree.insert(9);
    tree.insert(1);
    tree.insert(6);
    tree.insert(8);
    tree.insert(10);

    System.out.println(tree.find(11));

    tree.traversePreOrder();
    System.out.println("--------");
    tree.traverseInOrder();
    System.out.println("--------");
    tree.traversePostOrder();

    System.out.println("Height of the tree");
    System.out.println(tree.height());
    System.out.println("End of height of the tree");

    System.out.println("Min value");
    System.out.println(tree.min());


    Tree second = new Tree();
    second.insert(7);
    second.insert(4);
    second.insert(9);
    second.insert(1);
    second.insert(6);
    second.insert(8);
    second.insert(10);

    System.out.println(tree.equals(second));
    System.out.println(tree.isBinarySearchTree());
  }
}
