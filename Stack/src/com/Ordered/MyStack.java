package com.Ordered;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/03/22:46
 * @Description:
 *  定义接口，定义栈的操作
 */
public interface MyStack {
    int getSize();              //返回元素的个数
    boolean isEmpty();          //判断栈是否为空
    void push(Object e);        //压栈
    Object pop();               //弹栈，返回删除
    Object peek();              //返回栈顶元素，仅仅返回
}
