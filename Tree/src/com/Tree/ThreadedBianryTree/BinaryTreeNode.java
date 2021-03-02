package com.Tree.ThreadedBianryTree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/07/12:59
 * @Description:
 */
public class BinaryTreeNode {
    //数据域
    private int no;
    private Object data;
    //左节点
    private BinaryTreeNode left;
    //右节点
    private BinaryTreeNode right;
    /*
    * 规定:当 leftType == 0 时表示指向的是左子树， 如果 1 表示指向前驱结点
    *       当rightType == 0 时 表示指向的是右子树， 如果 1 表示指向后继结点
    * */
    //左子树类型
    private int leftType;
    //右子树类型
    private int rightType;

    public BinaryTreeNode(int no, Object data) {
        this.no = no;
        this.data = data;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "no=" + no +
                ", data=" + data +
                '}';
    }

    //前序遍历
    public void  preOrder(){
        System.out.println(this.toString());
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public  void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.toString());
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public  void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this.toString());
    }

    /*
    * 按照前序、中序、后序遍历查找
    * 查找no
    * @return 如果找到就返回该node，如果没有就返回null
    * */

    //前序遍历查找
    public BinaryTreeNode preOrderSearch(int no){
        BinaryTreeNode resNode = null;
        System.out.println("进入前序遍历~");
        if (this.no == no){
            return this;
        }
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    //中序查找
    public BinaryTreeNode infixOrderSearch(int no){
        BinaryTreeNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入中序遍历~");
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //后序查找
    public BinaryTreeNode postOrderSearch(int no){
        BinaryTreeNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("进入后序遍历~");
        if (this.no == no){
            return this;
        }
        return resNode;
    }
    /*
    * 递归删除结点
    *
    * */
    public void deleteNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right !=  null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.deleteNode(no);
        }
        if (this.right != null){
            this.right.deleteNode(no);
        }
    }


}
