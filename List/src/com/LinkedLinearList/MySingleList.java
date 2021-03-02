package com.LinkedLinearList;

import com.orderedLinearList.MyList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/02/12:11
 * @Description:
 */
public class MySingleList implements MyList {
    private Node head;      //头结点
    private int size;       //保存元素的个数

    public class Node {
        Object data;        //数据域
        Node next;          //指针域

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //返回元素的个数
    @Override
    public int getSize() {
        return size;
    }

    //判断线性表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //在线性表中插入元素
    @Override
    public void insert(int i, Object e) {
        //判断索引值是否为空
        if (i < 0 || i > size)
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        //创建节点
        Node newNode = new Node(e, null);
        //判断头结点是否为null
        if (head == null) {
            head = newNode;
        }else{
            //在0位置插入节点
            if (i == 0) {
                newNode.next = head;        //修改新节点的next域指向原来的头结点
                head = newNode;             //刚插入的结点作为新结点
                System.out.println("插入成功！！");
            }else {
                //插入节点,先找到i-1这个结点
                Node pNode = head;
                for (int x = 1; x < i; x++) {
                    pNode = pNode.next;
                }
                //注意：先修改新结点的next指针域，再修改i-1结点的指针域
                newNode.next = pNode.next;
                pNode.next = newNode;
                System.out.println("插入成功！！");
            }
        }
        //size更新
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
        Node pNode = head;
        for (int i = 0; i < size; i++){
            if (e.equals(pNode.data)){
                return i;
            }else {
                pNode = pNode.next;
            }
        }
        return -1;
    }

    //删除线性表中第一个与e相同的元素，并返回该元素
    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0){
            return false;
        }
        Object ele = remove(index);
        return ele;
    }

    //删除线性表中索引值为i的元素，并返回该元素
    @Override
    public Object remove(int i) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        Node pNode = head;
        Object ele;
        if (i == 0){
            ele = head.data;
            head = head.next;
        }else {
            for (int x = 1; x < i; x++){
                pNode = pNode.next;
            }
             ele = pNode.next.data;
            pNode.next = pNode.next.next;
        }
        size--;
        return ele;
    }

    //使用元素e替换线性表中索引值为i的元素，并返回旧的元素
    @Override
    public Object replace(int i, Object e) {
        Node pNode = head;
        Object ele = null;
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        if (i == size){
            for (int x = 0 ; x < size; x++){
                pNode = pNode.next;
            }
            Node newNode = new Node(e,null);
            newNode = pNode.next;
            size++;
        }else{
            for (int x = 0; x < i; x++){
                pNode = pNode.next;
            }
            ele = pNode.data;
            pNode.data = e;
        }

        return ele;
    }

    //返回索引值为i的元素
    @Override
    public Object get(int i) {
        Node pNode = head;
        Object ele = null;
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        for (int x = 0; x < i; x++){
            pNode = pNode.next;
        }
        ele = pNode.data;
        return ele;
    }

    //在线性表元素p的前面插入元素e
    @Override
    public boolean insertBefore(Object p, Object e) {
        int index = indexOf(p);
        if (index < 0){
            return false;
        }
        insert(index,e);
        return true;
    }

    //在线性表元素p的后面插入元素e
    @Override
    public boolean insertAfter(Object p, Object e) {
        int index = indexOf(p);
        if (index < 0){
            return false;
        }
        insert(index+1,e);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node pNode = head;
        for(int i = 0; i < size; i++){
            sb.append(pNode.data);
            pNode = pNode.next;
            if (i + 1 < size)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
