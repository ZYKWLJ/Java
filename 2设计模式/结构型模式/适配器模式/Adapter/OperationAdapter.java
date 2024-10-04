package com.EthanYankang.结构型模式.适配器模式.Adapter;


import com.EthanYankang.结构型模式.适配器模式.Adaptee.BinarySearch;
import com.EthanYankang.结构型模式.适配器模式.Adaptee.QuickSort;
import com.EthanYankang.结构型模式.适配器模式.Target.ScoreOperation;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-14 08:42
 **/ //操作适配器：适配器        即方法调用方法(做到接口适配)
public class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj; //定义适配者QuickSort对象
    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int array[]) {
        return sortObj.quickSort(array); //调用适配者类QuickSort的排序方法
    }

    public int search(int array[], int key) {
        return searchObj.binarySearch(array, key); //调用适配者类BinarySearch的查找方法
    }
}
