package com.EthanYankang.结构型模式.适配器模式.Target;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-14 08:39
 **/
//抽象成绩操作类：目标接口
public interface ScoreOperation {
    public int[] sort(int array[]); //成绩排序
    public int search(int array[],int key); //成绩查找
}

