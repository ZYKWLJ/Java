package com.itheima.美团.T24_1.T2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 真题
 * @Date: 2024-08-31 21:45
 **/
public class Main2 {
     public static void main(String[] args) {
             Scanner input = new Scanner(System.in);
             while (true) {
                 int n = input.nextInt();
                 int k = input.nextInt();
                 int[] nums = new int[n];
                 for (int i = 0; i < n; i++) {
                     nums[i] = input.nextInt();
                 }

                 System.out.println(solve(n, k, nums));
             }
         }

    private static int solve(int n, int k, int[] nums) {

//        假设工人位置最后一名与第一名差值为diff，之间全部种满，不能达到最大值的话，最多只是每个人种k-diff+1颗。
//        最小就是每个工人种的树都不重叠，全部算数即可，但肯定会超出diff。
//        哈希表的大小为nums[n-1]+k-diff+1
        int diff= nums[n-1]-nums[0];
        int max=n*k;
        int i=1;
//         每人种一棵树，一直种到最大去。
            for (; i <= max; i++) {

//                从第一个人遍历
                int[] hash=new int[max];
                for (int num : nums) {
                    for (int l = 1; l <= i; l++) {
                        hash[num + l] = 1;
                    }
                }
                if (Arrays.stream(hash).sum()>k)return i;
            }
        return i;
    }
}
