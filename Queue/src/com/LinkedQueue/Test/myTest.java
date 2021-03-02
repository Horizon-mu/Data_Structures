package com.LinkedQueue.Test;

import com.LinkedQueue.MyLinkedQueue;
import org.w3c.dom.ls.LSOutput;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/06/18:04
 * @Description:
 */
public class myTest {
    public static void main(String[] args) {
        MyLinkedQueue queue = new MyLinkedQueue();
        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        queue.insert("5");
        queue.insert("6");
        queue.insert("7");
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.insert("8");
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.getSize());
        System.out.println(queue);

    }
}
