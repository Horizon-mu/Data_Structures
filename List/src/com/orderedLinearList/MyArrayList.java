package com.orderedLinearList;

import java.util.Arrays;

/**
 * 通过数组实现线性表
 * @author Horizon~muu
 */

public class MyArrayList  implements MyList{
    private Object[] elements;      //定义数组保存数据元素
    private static final int DEFAULT_CAPACITY = 16;     //数组的初始化容量
    private int size;               //保存数据元素的个数

    //构造方法
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int initialCapacity){
        elements = new Object[initialCapacity];
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

    //在线性表i索引值处添加元素e
    @Override
    public void insert(int i, Object e) {
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("i=" + i +"越界");
        }
        //如果数组已满， 需要对数组扩容
        if (size >= elements.length){
            expandSpace();  //数组扩容
        }
        //从i开始，把元素依次后移
        for (int j = size ; j > i ; j--){
            elements[j] = elements[j-1];
        }
        //把元素e存储到i位置
        elements[i] = e;
        size++;
        System.out.println("插入成功！！");
    }

    //数组扩容
    /*
    * 定义一个更大的数组
    * 把原来数组的内容复制到新数组中
    * 让原来数组名指向新数组
    * */
    public void expandSpace(){
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0 ; i<elements.length; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    //输出线性表中的内容
    @Override
    public String toString() {
        //遍历数组中已添加的元素
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0 ; i < size ; i++){
            sb.append(elements[i]);
            if (i + 1 < size){
                sb.append(",");
            }
        }
        sb.append("]");
       return sb.toString();
    }

    //判断当前线性表中是否包含元素e
    @Override
    public boolean contains(Object e) {
      return indexOf(e) >= 0 ;
    }


    //返回元素e在线性表中第一次出现的索引值，如果不存在，返回-1
    @Override
    public int indexOf(Object e) {
        if (e == null){
            for(int i = 0; i < size; i++){
                if (elements[i] == null)
                    return i;
            }
        }
        for(int i = 0; i < size; i++){
            if (e.equals(elements[i]))
                return i;
        }

        return -1;
    }

    // 在线性表中删除第一个与e相同的元素
    @Override
    public Object remove(Object e) {
        int index = indexOf(e);
        if (index < 0)
            return false;
        Object ele = remove(index);
        return ele;
    }

    // 删除指定索引值的元素
    @Override
    public Object remove(int i) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException("i=" + i +"越界");
        }
        Object m = elements[i];
        for (int j = i + 1; j < size; j++){
            elements[j-1] = elements[j];
        }
        elements[size-1] = null;
        size--;
        return m;
    }

    //使用元素e替换线性表中索引值为i的元素，并返回旧的元素
    @Override
    public Object replace(int i, Object e) {
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        if (i == size){
            elements[size] = e;
            size++;
            return null;
        }
        Object m = elements[i];
        elements[i] = e;
        return m;
    }

    //返回索引值为i的元素
    @Override
    public Object get(int i) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException("i=" + i + "越界");
        }
        return elements[i];
    }

    //在线性表元素p的前面插入元素e
    @Override
    public boolean insertBefore(Object p, Object e) {
        int i = indexOf(p);
        if (i < 0){
            return false;   //p元素不存在
        }
        insert(i,e);
        return true;
    }

    @Override
    public boolean insertAfter(Object p, Object e) {
        int i = indexOf(p);
        if (i < 0){
            return false;   //p元素不存在
        }
        insert(i+1,e);
        return true;
    }
}
