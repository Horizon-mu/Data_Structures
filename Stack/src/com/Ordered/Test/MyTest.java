package com.Ordered.Test;

import com.Ordered.MyArrayStack;
import com.Ordered.MyStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/03/22:52
 * @Description: top 只是int类型变量，不受数组长度，容量的限制
 */
public class MyTest {
    public static void main(String[] args) {
        MyStack stack = new MyArrayStack(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        stack.push("china");
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        stack.push("world");
        stack.push("shanghai");
        stack.push("xian");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


    }
}
