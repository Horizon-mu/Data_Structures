package com.orderedLinearList.Test;

import com.orderedLinearList.MyArrayList;
import com.orderedLinearList.MyList;


public class MyTest {
    public static void main(String[] args) {
        //创建一个MyArrayList对象
        MyList myList = new MyArrayList();
        //判断数组是否为空
        System.out.println(myList.isEmpty());
        myList.insert(0,"China");
        myList.insert(1,"shanxi");
        myList.insert(2,"zhejiang");
        myList.insert(3,"Beijing");
        myList.insert(1,"Shanghai");
        System.out.println(myList.isEmpty());
        System.out.println(myList.getSize());
        //输出线性表中的内容
        System.out.println(myList);
        //判断当前线性表中是否包含元素e
        System.out.println(myList.contains("zhejiang"));
        System.out.println(myList.indexOf("zhejiang"));
        System.out.println(myList.remove("shanxi"));
        System.out.println(myList);
        System.out.println(myList.remove(0));
        System.out.println(myList);
        System.out.println(myList.getSize());
        System.out.println(myList.replace(0,"china"));
        System.out.println(myList);
       // System.out.println(myList.get(2));
        System.out.println(myList.insertAfter("china","world"));
        System.out.println(myList);
        System.out.println(myList.remove("world"));
        System.out.println(myList);
        System.out.println(myList.insertBefore("china","world"));
        System.out.println(myList);
        System.out.println(myList.remove("world"));
        System.out.println(myList);
    }
}
