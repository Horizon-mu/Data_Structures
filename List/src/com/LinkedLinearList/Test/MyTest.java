package com.LinkedLinearList.Test;

import com.LinkedLinearList.MySingleList;
import com.orderedLinearList.MyList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/02/12:11
 * @Description:
 */
public class MyTest {
    public static void main(String[] args){
        //创建链表
        MyList link = new MySingleList();

        //判断是否为空
        System.out.println(link.isEmpty());

        //查询数组元素个数
        System.out.println(link.getSize());
        //插入元素
        link.insert(0,"world");
        link.insert(1,"china");
        link.insert(2,"Beijing");
        link.insert(3,"shanxi");

        System.out.println(link);

        System.out.println(link.contains("china"));

        System.out.println(link.indexOf("china"));
        System.out.println(link.indexOf("world"));

        System.out.println(link.remove("china"));
        System.out.println(link);
        System.out.println(link.remove(0));
        System.out.println(link);
        System.out.println(link.replace(1,"shanghai"));
        System.out.println(link);

        link.insertAfter("Beijing","china");
        System.out.println(link);
        link.insertBefore("Beijing","world");
        System.out.println(link);


    }
}
