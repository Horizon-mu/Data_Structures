package com.Tree;



/**
 * Created with IntelliJ IDEA.
 * 创建二叉树
 * @author : Horizon~muu
 * @Date: 2020/10/07/16:31
 * @Description:
 */
public class BinaryTree {
    private BinaryTreeNode root;            //根节点
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
}
