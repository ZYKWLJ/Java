package com.itheima.小红书.T1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-22 16:34
 **/
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
            sum+=a[i];
        }
    //    显然这是粉碎石头的原题
        int space=sum>>1;//不管是奇是偶，都只是最小的那个，OK的。
        int [] dp=new int[space+1];//背包的重量为space
        for (int i = 0; i < n; i++) {
            for (int j = space; j >=a[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-a[i]]+a[i]);
            }
        }
        System.out.println(sum-2*dp[space]);
    }
}
