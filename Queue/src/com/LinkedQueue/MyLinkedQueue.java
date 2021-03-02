package com.LinkedQueue;

import java.security.PrivateKey;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/06/17:39
 * @Description:
 */
public class MyLinkedQueue {
    private Node front;
    private Node rear;
    private int size;
    public class Node{
        Object data;
        Node next;

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return size <= 0;
    }
    //返回队列元素个数
    public int getSize(){
        return size;
    }
    //入队
    public void  insert(Object e){
        Node newNode = new Node(e,null);
        if (front == null){
            front = newNode;
        }else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }
    //出队
    public Object remove(){
        if (front == null){
            return false;
        }
        Object ele = front.data;
        front = front.next;
        size--;
        return ele;
    }
    //获取队列首个元素
    public Object peek(){
        if(isEmpty()){
            return false;
        }
        return front.data;
    }

    //重写toString


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pNode = front;
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(pNode.data);
            pNode = pNode.next;
            if (i + 1 < size){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
