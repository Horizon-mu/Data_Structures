package com.application;

import com.Ordered.MyArrayStack;
import com.Ordered.MyStack;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/05/12:13
 * @Description:
 */
public class TestBrackets {
    public static void main(String[] args) {

        String expression = "(3+5)*[3-6]-{12/4}+([{}])";
        System.out.println(TestBrackets.bracketMatch(expression));
    }
    //检测表达式中的括弧是否匹配
    public static boolean bracketMatch(String expression){
        //保存左括号
        MyStack stack = new MyArrayStack();
        //遍历整个表达式，如果是左括号就入栈，如果是右括号，就出栈进行判断
        for (int i = 0; i < expression.length(); i++){
            //取出表达式的每个字符
            char element = expression.charAt(i);
            switch (element){
                case '(':
                case '[':
                case '{':
                    stack.push(element);        //左括号入栈，自动装箱拆箱
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop().equals('{'))
                    {
                        break;
                    }else {
                        return false;
                    }
                case ']':
                    if (!stack.isEmpty() && stack.pop().equals('['))
                    {
                        break;
                    }else {
                        return false;
                    }
                case ')':
                    if (!stack.isEmpty() && stack.pop().equals('('))
                    {
                        break;
                    }else {
                        return false;
                    }
            }
        }
        //表达式遍历完后，如果栈是空的，表达式合法
        if (stack.isEmpty()){
            return true;
        }else {
            System.out.println(stack);
            return false;
        }
    }
}
