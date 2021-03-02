package com.Ordered;
/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/03/22:53
 * @Description:堆栈的顺序实现
 */
public class MyArrayStack implements MyStack{
    //定义数组保存堆栈的元素
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 16; //堆栈的默认容量
    private int top;                //栈顶指针
    //无参构造中，对数组进行默认初始化
    public MyArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //有参构造，指定堆栈的初始化容量
    public MyArrayStack(int initialCapacity){
        elements = new Object[initialCapacity];
    }

    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public void push(Object e) {
        if (top >= elements.length){
            //数组扩容
            Object[] newElements = new Object[(int) (elements.length * 1.5)];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[top] = e;
        top++;
        System.out.println("入栈成功！！");
    }

    @Override
    public Object pop() {
        Object ele = peek();
        top--;
        return ele;
    }

    @Override
    public Object peek() {
        if(top <= 0){
            throw new StackOverflowError("栈已空，无法弹栈！！");
        }
        return elements[top-1];
    }

    @Override
    public String toString() {
        //从栈顶到栈底返回各个元素
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = top - 1; i >= 0; i--){
            sb.append(elements[i]);
            if(i - 1 >= 0){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}