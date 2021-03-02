package com.Tree.ThreadedBianryTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/17/15:23
 * @Description:
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1,"战士");
        BinaryTreeNode node1 = new BinaryTreeNode(3,"刺客");
        BinaryTreeNode node2 = new BinaryTreeNode(6,"法师");
        BinaryTreeNode node3 = new BinaryTreeNode(8,"坦克");
        BinaryTreeNode node4 = new BinaryTreeNode(10,"谨慎");
        BinaryTreeNode node5 = new BinaryTreeNode(14,"啦啦");

        BinaryTree tree = new BinaryTree(root);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        tree.threadNode();


        //测试线索化

        System.out.println(node3.getLeft());
        System.out.println();
        tree.threadedLst();

    }
}
