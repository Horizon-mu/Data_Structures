package com.Tree;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Horizon~muu
 * @Date: 2021/02/17/20:32
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        //将数组进行升序排序
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }
        /*
        *2） 将堆顶元素与末尾元素进行交换，将最大元素“沉入”数组末端
        *3） 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+步骤交换，直到整个序列有序
        * */
        for (int j = arr.length - 1; j > 0; j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    //将一个数组(二叉树),调整成为一个大顶堆
    /*
    *功能：完成 将以 i 对应的非叶子结点的树调整成为大顶堆
    * @Param  arr    待调整的数组
    * @Param  i      表示非叶子节点在数组中的索引下标
    * @Param  length 表示对多少个元素进行调整，length在逐渐减少
    * */
    public  static void adjustHeap(int[] arr,int i, int length){
        int temp = arr[i];//声明临时变量保存当前结点的值
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if (k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
            arr[i] = temp;
        }
    }
}
