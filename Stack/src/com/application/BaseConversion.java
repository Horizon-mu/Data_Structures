package com.application;

import com.Ordered.MyArrayStack;
import com.Ordered.MyStack;

/**
 * Created with IntelliJ IDEA.
 * @author : Horizon~muu
 * @Date: 2020/10/04/14:15
 * @Description:
 */
public class BaseConversion {
    public static void convert(int num , int decimal){
        MyStack stack = new MyArrayStack();
        int result = num % decimal;
        while(num != 0){
            stack.push(result);
             num = num / decimal;
             result = num % decimal;
        }
        System.out.println(stack);
    }
}
