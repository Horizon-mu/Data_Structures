package com.orderedLinearList;

/**
 * @author Horizon~muu
 *
 * 顺序存储的特点：
 *      优点：顺序存储是使用数组实现的，数组可以通过索引值快速访问到每个元素
 *      缺点：在插入/删除是，需要移动大量的元素
 *            当线性表长度变化较大时，很难确定存储空间的容量
 *      应用场景：适合存储插入和删除操作少的元素，以查询为主的
 */

public interface MyList {
    int getSize();                              //线性表中元素的个数
    boolean isEmpty();                          //判断线性表是否为空
    void insert(int i , Object e);              //在线性表i索引值出添加元素e
    boolean contains(Object e);                 //判断线性表中是否有元素e
    int indexOf(Object e);                      //返回线性表中元素e的索引值
    Object remove(Object e);                    //删除线性表中第一个与e相同的元素，并返回该元素
    Object remove(int i);                       //删除线性表中索引值为i的元素，并返回该元素
    Object replace(int i , Object  e);          //使用元素e替换线性表中索引值为i的元素，并返回旧的元素
    Object get(int i);                          //返回索引值为i的元素
    boolean insertBefore(Object p , Object e);  //在线性表元素p的前面插入元素e
    boolean insertAfter(Object p , Object e);   //在线性表元素p的后面插入元素e
}
