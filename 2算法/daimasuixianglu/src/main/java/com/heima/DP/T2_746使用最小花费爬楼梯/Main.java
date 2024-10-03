package com.heima.DP.T2_746使用最小花费爬楼梯;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-13 21:38
 **/
public class Main {
    public static void main(String[] args) {
    //    定义dp[i]为爬到第i个楼梯的最小花费
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] cost=new int[n];
        for (int i = 0; i < n; i++) {
            cost[i]=input.nextInt();
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+ cost[i-2]);
        }
        System.out.println(dp[n]);
    }
}
