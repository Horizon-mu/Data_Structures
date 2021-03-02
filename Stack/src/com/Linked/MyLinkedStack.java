package com.Linked;

import com.Ordered.MyStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/04/11:35
 * @Description:
 */
public class MyLinkedStack implements MyStack {

    private int top;
    private Node head;

    public class Node{
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public void push(Object e) {
        Node newNode;
        if (head == null){
          newNode = new Node(e,null);
        }else {
            newNode = new Node(e,head);
        }
        head = newNode;
        top++;
        System.out.println("入栈成功！！");
    }

    @Override
    public Object pop() {
        Object ele = peek();
        head = head.next;
        top--;
        return ele;
    }

    @Override
    public Object peek() {
        if (top <= 0){
            throw new StackOverflowError("栈已空！！");
        }
        return head.data;
    }

    @Override
    public String toString() {
        Node pNode = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < top; i++){
            sb.append(pNode.data);
            if (i + 1 < top){
                sb.append(",");
            }
            pNode = pNode.next;
        }
        sb.append("]");
        return "MyLinkedStack = " + sb.toString();
    }
}
