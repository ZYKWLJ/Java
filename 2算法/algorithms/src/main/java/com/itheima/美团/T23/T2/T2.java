package com.itheima.美团.T23.T2;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-06 17:03
 **/

/*
 * @description 本题要点
 * 1.在输入的时候就处理数组和(一种很重要的技巧)
 * 2.注意数据类型一定是long
 * 3.注意这中正逆问题一定要从小入手，减小计算量，否则会超时
 * @params
 * @return
 */

public class T2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int  n = input.nextInt();
        //因为题目细节比较多，这里必须处理为long，否则会溢出！！！
        long[] nums=new long[n];
        long res=0;
        //这一步很重要，直接在输入就处理和了！！
        for (int i = 0; i < n; i++) {
             nums[i]=input.nextInt();
             res+=nums[i];
        }
        int x= input.nextInt();
        int y=input.nextInt();
        //这一部很关键，因为要尽可能地减少计算量，如果出现100，99这种情况，和99,100是一样的，反正最后都要比较两者。最终的计算一定要小。
        //
        System.out.println(solve(nums,Math.min(x,y),Math.max(x,y),res));
    }

    private static long solve( long[] nums, int x, int y,long res) {

        long sum1 = 0;
        for (int i = x - 1; i < y - 1; i++) {
                sum1 += nums[i];
        }
        return Math.min(sum1, res - sum1);
    }
}
