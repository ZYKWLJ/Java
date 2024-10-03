package com.itheima.途虎.T1;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-12 19:23
 **/
public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m=0;
        int n=0;
        int[][] nums=new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j]=input.nextInt();
            }
        }

        int[][] dp=new int[m][n];//dp[i][j]表示从0-i行路走过，取得的最大价值为
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }
        }

    }
}
