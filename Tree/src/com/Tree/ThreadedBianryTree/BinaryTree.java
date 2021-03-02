package com.Tree.ThreadedBianryTree;


/**
 * Created with IntelliJ IDEA.
 * 创建二叉树
 * @author : Horizon~muu
 * @Date: 2020/10/07/16:31
 * @Description:
 */
public class BinaryTree {
    private BinaryTreeNode root;            //根节点
    private BinaryTreeNode pre = null;
    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
    /*
    * 二叉树的遍历
    * */
    public void preOrder(){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("空树，无法遍历");
        }
    }
    public void infixOrder(){
        root.infixOrder();
    }
    public  void postOrder(){
        root.postOrder();
    }
    /*
    * 查找
    * */
    public BinaryTreeNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }

    }
    public BinaryTreeNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    public BinaryTreeNode postOrderSearch(int no){
        if (root != null) {
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }
    /*
    * 递归删除结点
    * */

    public void deleteNode(int no){
        //判断root结点是否为空，是否是需要删除的结点
        if(root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.deleteNode(no);
            }
        }else{
            System.out.println("二叉树为空，无法删除结点！");
        }
    }
    //中序线索化
    public void threadedNode(BinaryTreeNode node){
        //先判断当前结点是否为空
        if(node == null){
            return;
        }
        /*
         * 1.先线索化左子树
         * 2.线索化当前结点
         * 3.最后线索化右子树
         * */

        //线索化左子树
        threadedNode(node.getLeft());
        //线索化当前结点

        //处理当前结点的前驱结点
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理当前节点的后继结点
        if (pre != null && pre.getRight() == null ){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //线索化右子树
        threadedNode(node.getRight());
    }
    public void threadNode(){
        threadedNode(root);
    }


    //线索化二叉树中序遍历
    public void threadedLst(){
        //定义一个变量来保存当前结点，从root开始
        BinaryTreeNode node = root;
        //一直循环
        while(node != null){

            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            //输出当前结点

            System.out.println(node);

            while(node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }
}
