package com.itheima.欧泊.T23.T1;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-06 21:17
 **/
public class T1 {
    static int x1 = 0;
    static int x2 = 0;
    static int y1 = 0;
    static int y2 = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean flag = true;
        //首先如果大于800，小于-800没戏。
        //其次要刚好相等的话，就要使得x-y=n。使得x=x1*x2，y=y1*y2
        //功能拆分，分别算出x，y，再算出是否可以作为两个数相乘就行了
        for (int i = 1; i < 401; i++) {
            for (int j = 1; j < 401; j++) {
                if (i - j == n && canSplitx1y2(i) && canSplitx2y1(j)) {
                    flag = false;
                    //System.out.println( x1 + " " + y1 + "\n" + x2 + " " + y2);
                    // 打印出每一个行列式
                    //System.out.println("=================");
                }
            }
        }
        System.out.println(flag ? -1 : x1 + " " + y1 + "\n" + x2 + " " + y2);
}
    private static boolean canSplitx2y1(int j) {
        for (int i = 0; i <= 20; i++) {
            for (int k = 0; k <= 20; k++) {
                if (i*k==j){
                    x2=i;
                    y1=k;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canSplitx1y2(int i) {
        for (int j = 0; j <= 20; j++) {
            for (int k = 0; k <= 20; k++) {
                if (j*k==i){
                    x1=j;
                    y2=k;
                    return true;
                }
            }
        }
        return false;
    }
}
