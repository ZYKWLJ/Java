package com.EthanYankang.结构型模式.适配器模式.Adaptee;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-14 08:41
 **/

//二分查找类：适配者
public class BinarySearch {
    public int binarySearch(int array[],int key) {
        int low = 0;
        int high = array.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if(midVal < key) {
                low = mid +1;
            }
            else if (midVal > key) {
                high = mid -1;
            }
            else {
                return 1; //找到元素返回1
            }
        }
        return -1;  //未找到元素返回-1
    }
}