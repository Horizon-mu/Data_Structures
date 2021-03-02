package com.DualLinearList;

import com.orderedLinearList.MyList;

import java.util.IdentityHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/02/17:49
 * @Description:
 */
public class MyDualLinearList implements MyList {
    //定义头结点和尾结点
    private Node first;     //头结点
    private Node last;      //尾结点
    private int size;       //存储元素个数

    //定义一个内部类描述双向链表的结构
    public class Node{
        Object data;
        Node prev;      //指向前驱结点
        Node next;      //指向后继结点

        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int i, Object e) {
        //判断索引值是否合法
        if(i < 0 || i > size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        //如果i==0，在头部添加元素
        if (i == 0){
            addFirst(e);
        }else if(i == size){
            addLast(e);
        }else {
            //找到i结点，在i结点的前面插入结点
            Node pNode = getNode(i);
            Node prevNode = pNode.prev;
            //生成新的结点
            Node newNode = new Node(e,prevNode,pNode);
            //修改前驱结点后继
            pNode.prev = newNode;
            prevNode.next = newNode;
            size++;
        }
        /*//创建新结点
        Node newNode = new Node(e,null,null);
        //判断头结点是否为空
        if(first == null){
            first = newNode;
            last = newNode;
        }
        //在尾部添加
        if (i == size){
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        //在0位置插入元素
        if (i == 0){
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }else{
            Node pNode = first;
            for (int x = 0; x < i; x++){
                pNode = pNode.next;
            }
            newNode.prev = pNode.prev;
            pNode.prev.next = newNode;
            newNode.next = pNode;
        }
        size++;
        System.out.println("插入成功！！");*/
    }
    //返回索引值为i的结点
    private Node getNode(int i) {
        Node pNode = first;
        for(int x = 0; x < i; x++){
            pNode = pNode.next;
        }
        return pNode;
    }

    //在尾部添加元素e
    private void addLast(Object e) {
        Node pNode = last;
        Node newNode = new Node(e,last,null);
        if (pNode == null){
            first = newNode;
        }else{
            pNode.next = newNode;
        }
        last = newNode;
        size++;
    }

    //在头部添加元素e
    private void addFirst(Object e) {
        //生成一个新结点
        Node newNode = new Node(e,null,first);
        //修改first指向新结点
        first = newNode;
        Node pNode = first.next;
        if(pNode == null){
            last = newNode;
        }else {
            pNode.prev = newNode;
        }
        size++;
    }

    //判断线性表中是否有元素e
    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    //返回线性表中元素e的索引值
    @Override
    public int indexOf(Object e) {
        int count = 0;
        for(Node node = first; node != null; node = node.next){
            if(e.equals(node.data)){
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0){
            return false;
        }
        Object ele = remove(index);
        return ele;
    }

    @Override
    public Object remove(int i) {
        Node pNode = first;
        Object ele = null;
        if(i == 0){
            ele = pNode.data;
            first = pNode.next;
            pNode.next = null;
        }
        if (i == size - 1){
            ele = last.data;
            last = last.prev;
            last.next.prev = null;
            last.next = null;
        }else if(i > 0 && i < size - 1)
        {
            for (int x = 0; x < i; x++){
                pNode = pNode.next;
            }
            ele = pNode.data;
            pNode.prev.next = pNode.next;
            pNode.next.prev = pNode.prev;
        }
        size--;
        return ele;
    }

    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        Object ele = null;
        Node pNode = first;
        for(int x = 0; x <= i; x++){
            pNode.data = e;
            pNode = pNode.next;
            ele = pNode.data;
        }
        return ele;
    }

    @Override
    public Object get(int i) {
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        Node pNode = first;
        Object ele = null;
        for(int x = 0; x <= i; x++){
            ele = pNode.data;
            pNode = pNode.next;
        }
        return ele;
    }

    @Override
    public boolean insertBefore(Object p, Object e) {
        int index = indexOf(p);
        if(index < 0){
            return false;
        }
        insert(index,e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {
        int index = indexOf(p);
        if(index < 0){
            return false;
        }
        insert(index + 1,e);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node node = first; node != null; node = node.next){
            sb.append(node.data);
            if(node != last){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
