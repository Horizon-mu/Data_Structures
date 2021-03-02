package com.Linked.Test;

import com.Linked.MyLinkedStack;
import com.Ordered.MyStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/04/11:30
 * @Description:test
 */
public class myTest {
    public static void main(String[] args) {
        MyStack stack = new MyLinkedStack();
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        stack.push("world");
        stack.push("china");
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack);
    }
}
