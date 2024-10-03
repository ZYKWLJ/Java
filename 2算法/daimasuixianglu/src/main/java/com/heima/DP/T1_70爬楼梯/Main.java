package com.heima.DP.T1_70爬楼梯;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-13 20:44
 **/
public class Main {
    public static void main(String[] args) {
    //    显然这一题是用dp来做，5大步
    //    铭记5大步：定推初序例

    //    1.定义(确定dp数组及下标的含义)：dp[i]表示爬到第i阶楼梯的种类数。
    //    2.递推关系：dp[i]=dp[i-2]+dp[i-1];（因为显然当前的阶梯数量，来自于前面的两步阶梯数量之和）
    //    3.初始化：因为i=1.所以显然，dp[1]=1，dp[2]=2;（爬一步）
    //    4.确定遍历顺序  这里是从前到后遍历。
    //    5.举例推导dp数组    能打印出来就能理解的更好。
        while (true) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[0]=1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                System.out.println("dp[" + i + "]=" + dp[i]);
            }
            System.out.println("爬到"+n+"阶楼梯的种数："+dp[n]);
        }
    }
}
