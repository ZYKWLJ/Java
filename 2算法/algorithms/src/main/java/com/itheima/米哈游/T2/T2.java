package com.itheima.米哈游.T2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 16:49
 **/
/*
 * @description 首先将找到最大的额外奖励值，然后找对应的正常奖励价。再找最大的正常奖励值，找对应的额外奖励值。
 * 则归根到底是求三个成对0正常的奖励值与额外奖励值之和/离散的正常值之和的总和最大值.(用哈希数组)
 * @params
 * @return
 */

public class T2 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m=input.nextInt();
    //代表奖励能量值
    int[] ai=new int[3*n];
    //代表奖励来源
    int[] bi=new int[3*n];
        //标记法
        //标记英雄出现的次数
        int[] ciCount=new int[13];

        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ai[i]=input.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                bi[i]=input.nextInt();
                //英雄出现次数递增
                ciCount[bi[j]]++;
            }
            //如果
        }

        for (int j = 0; j < 3*n; j++) {
            map.put(ai[j],bi[j]);
        }
    //贪心，每一轮选择最大即可


    }
}
