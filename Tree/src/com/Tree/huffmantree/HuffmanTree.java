package com.Tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/18/14:33
 * @Description:
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node node = creatHuffmanTree(arr);
        preOrder(node);
    }

    //前序遍历的方法
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("空树，无法遍历~");
        }
    }
    //创建哈夫曼树的方法
    public static Node creatHuffmanTree(int[] arr){
        /*
        为了操作方便
        1.遍历整个数组
        2.将每个数组元素构成node对象
        3.将node放入到ArrayList中
         */
        List<Node> nodes = new ArrayList<>();
        for (int val : arr){
            nodes.add(new Node(val));
        }

        while (nodes.size() > 1){
            Collections.sort(nodes);
            System.out.println(nodes);
            //取出权值最小的两颗二叉树（结点）
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.val + rightNode.val);
            //构造一颗新的二叉树
            parent.left = leftNode;
            parent.right = rightNode;
            //删除leftNode和rightNode
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新节点添加到ArrayList 中
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
/*
* 创建结点类
* 为了让node对象支持排序collections集合排序，让node类实现Comparable接口
* */
class Node implements Comparable<Node>{

     int val;   //权值
     Node left; //指向左子结点
     Node right; //指向右子结点

    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.val - o.val;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
