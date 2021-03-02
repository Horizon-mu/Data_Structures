package com.Tree;

/**
 * Created with IntelliJ IDEA.
 * 二叉树
 * @author : Horizon~muu
 * @Date: 2021/02/14/14:35
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1,"宋江");
        BinaryTreeNode node1 = new BinaryTreeNode(2,"吴用");
        BinaryTreeNode node2 = new BinaryTreeNode(3,"卢俊义");
        BinaryTreeNode node3 = new BinaryTreeNode(4,"林冲");
        BinaryTreeNode node4 = new BinaryTreeNode(5,"关胜");
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        BinaryTree tree = new BinaryTree(root);
        /*tree.preOrder();
        System.out.println();
        tree.infixOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        System.out.println(tree.preOrderSearch(5).toString());
        System.out.println();
        System.out.println(tree.infixOrderSearch(5).toString());
        System.out.println();
        System.out.println(tree.postOrderSearch(5).toString());*/

        //删除前
        tree.preOrder();
        System.out.println();
        //删除结点5，关胜
        tree.deleteNode(1);
        //删除后
        tree.preOrder();
        tree.deleteNode(1);
    }
}
