package com.Tree.binarysorttree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/19/17:35
 * @Description:
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BST binarySortTree = new BST();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        System.out.println();
        binarySortTree.delNode(3);
        binarySortTree.infixOrder();
    }
}

//二叉排序树
class BST{
    Node root;

    //添加结点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {

            root.add(node);
        }
    }

    //中序遍历

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("empty tree ,can not travel~");
        }
    }

    //查找需要删除的结点
    public Node search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    //查找父结点
    public Node searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }
    //删除右子树中的最小值结点

    public int delRightTreeMin(Node node){
        //循环遍历左子树
        Node target = node;
        while(target.left != null){
            target = target.left;
        }
        delNode(target.val);
        return target.val;
    }

    //删除结点
    public void delNode(int val){
        if (root == null){
            return;
        }else {
            Node targetNode = search(val);
            if (targetNode == null){
                return;
            }
            //如果BST只有一个结点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            //删除叶子结点
            Node parent = searchParent(val);
            if (targetNode.left == null && targetNode.right == null){
                //targetNode 是parent的左子节点
                if (parent.left != null && parent.left.val == val){
                    parent.left = null;
                }else if (parent.right != null && parent.right.val == val){
                    parent.right = null;
                }
                //删除两颗子树的结点
            }else if(targetNode.left != null && targetNode.right != null){
                int min = delRightTreeMin(targetNode);
                targetNode.val = min;
            }else{
                //删除一颗子树的结点
                if (parent.left == targetNode){
                    if(targetNode.left != null){
                        parent.left = targetNode.left;
                    }else{
                        parent.left = targetNode.right;
                    }
                }else{
                    if(targetNode.left != null){
                        parent.right = targetNode.left;
                    }else{
                        parent.right = targetNode.right;
                    }
                }
            }
        }

    }
}


//结点类
class Node{
    int val;

    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    //添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (node.val <= this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //查找要删除的结点

    public Node search(int val) {
        //当前结点就是要删除的结点
        if (this.val == val) {
            return this;
        }
        if (val < this.val) {
            if (this.left != null) {
                return this.left.search(val);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.search(val);
            } else {
                return null;
            }
        }
    }

    //查找要删除的结点的父结点

    public Node searchParent(int val) {
        if ((this.left != null && this.left.val == val) ||
                (this.right != null && this.right.val == val)) {
            return this;
        }
        //当前结点的值小于val，并且左子树不为空，向左子树递归查找
        if (this.left != null && val < this.val) {
            return this.left.searchParent(val);
            //。。。。。。。向右子树递归查找
        } else if (this.right != null && val >= this.val) {
            return this.right.searchParent(val);
        } else {
            return null;
        }
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
