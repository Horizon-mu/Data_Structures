package com.Tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/15/14:19
 * @Description:
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrTree = new ArrayBinaryTree(arr);
        arrTree.preOrder(0);//1 2 4 5 3 6 7
        System.out.println();
        arrTree.infixOrder(0);// 4 2 5 1 6 3 7
        System.out.println();
        arrTree.postOrder(0);// 4 5 2 6 7 3 1
    }
}
//编写一个类实现顺序存储二叉树的遍历
class ArrayBinaryTree{
    private int[] arr;//存储结点数据的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法来实现顺序存储二叉树的前序遍历index 表示数组下标
    public void preOrder(int index){
        //如果数组为空，或者arr.length == 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空~");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if(2 * index + 1 < arr.length){
            preOrder(2 * index +1);
        }
        //向右递归
        if (2 * index + 2 < arr.length){
            preOrder(2 * index +2);
        }
    }
    public void infixOrder(int index){
        //如果数组为空，或者arr.length == 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空~");
        }
        //向左递归
        if(index * 2 + 1 < arr.length){
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        //向右递归
        if (index * 2 + 2 <  arr.length){
            infixOrder(index * 2 + 2);
        }
    }
    public void postOrder(int index){
        //如果数组为空，或者arr.length == 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空~");
        }
        //向左递归
        if(index * 2 + 1 < arr.length){
            postOrder(index * 2 + 1);
        }
        //向右递归
        if (index * 2 + 2 <  arr.length){
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}