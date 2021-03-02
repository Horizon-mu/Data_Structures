package com.DualLinearList.Test;

import com.DualLinearList.MyDualLinearList;
import com.orderedLinearList.MyList;
import org.w3c.dom.ls.LSOutput;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2020/10/02/17:50
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
        MyList linkedList = new MyDualLinearList();
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.getSize());
        linkedList.insert(0,"china");
        linkedList.insert(0,"shanghai");
        linkedList.insert(1,"world");
        System.out.println(linkedList);
        System.out.println(linkedList.contains("china"));
        System.out.println(linkedList.indexOf("china"));
        System.out.println(linkedList.indexOf("world"));
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.replace(0,"shanghai"));
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.insertBefore("shanghai","world"));
        System.out.println(linkedList);
        System.out.println(linkedList.insertAfter("china","Beijing"));
        System.out.println(linkedList);
    }
}
