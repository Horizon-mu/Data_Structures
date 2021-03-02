package com.OrderedQueue.Test;

import com.OrderedQueue.MyArrayQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/06/14:15
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue();
        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        queue.insert("5");
        queue.insert("6");
        queue.insert("7");
        queue.insert("8");
        queue.insert("9");
        queue.insert("10");
        System.out.println(queue);
        System.out.println(queue.peek());



    }
}
