package com.OrderedQueue;

/**
 * Created with IntelliJ IDEA.
 * @author : Horizon~muu
 * @Date: 2020/10/06/13:56
 * @Description:
 * 队列的顺序存储实现
 */
public class MyArrayQueue {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 8;
    private int front;
    private int rear;
    private int size;

    public MyArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayQueue(int initialCapacity){
        elements = new Object[initialCapacity];
    }

    //返回元素个数
    public int getSize(){
        return size;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return size <= 0;
    }

    //入队
    public void insert(Object e){
        //判断队列是否已满
        if (size == elements.length){
            //队列扩容
            Object[] newElement = new Object[elements.length * 2];
            //把原来来数组的内容复制到新数组中，从队首元素开始复制到新数组索引值为0开始的位置
            for (int i = 0; i < size; i++){
                newElement[i] = elements[front];
                front = (front + 1) % elements.length;
            }
            elements = newElement;
            //调整新的队首，队尾指针
            front = 0;
            rear = size;
        }
        elements[rear] = e;
        rear = (rear + 1) % elements.length;
        size++;
    }

    //出队
    public Object remove(){
        //判断队列是否为空
        if (size <= 0){
            throw new QueueIsEEmptyException("队列为空");
        }
        Object ele = elements[front];
        front = (front + 1) % elements.length;
        size --;
        return ele;
    }

    //返回队首元素
    public Object peek(){
        if (isEmpty()){
            throw new QueueIsEEmptyException("队列为空");
        }
        return elements[front];
    }
    //重写toString 方法

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       for (int i = front; i < rear; i++){
           sb.append(elements[i]);
           if (i + 1 < rear){
               sb.append(",");
           }
       }
       sb.append("]");
       return sb.toString();
    }

    public class QueueIsEEmptyException extends RuntimeException{
        public QueueIsEEmptyException() {
            super();
        }

        public QueueIsEEmptyException(String message) {
            super(message);
        }
    }
}

