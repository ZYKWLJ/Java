package com.itheima.小红书.T2;

import java.util.HashSet;
import java.util.Scanner;

//import static com.itheima.华为.T24_0911.T2.T2.slove;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-22 16:45
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            String[][] MCNS = new String[n][];
            for (int j = 0; j < n; j++) {
                int m1 = scanner.nextInt();
                MCNS[j]=new String[m1];//这里必须为之分配内存！！
                for (int k = 0; k < m1; k++) {
                    String MCN = scanner.next();
                    MCNS[j][k]=MCN;
                }

            }
            boolean flag=false;
            for (int a = 0;  a<n; a++) {
                for (int b = a+1; b < n; b++) {
                   if(slove(MCNS[a],MCNS[b])==x){
                       System.out.println("YES");
                       System.out.println(a+1+" "+b+1);
                       flag=true;
                       break;
                   }
                }
                if (flag)break;
            }
            if (!flag){
                System.out.println("NO");
            }

        }
    }

    private static int slove(String[] mcn1, String[] mcn2) {
        HashSet<String> diffStr = new HashSet<>();
        for (String mcn : mcn1) {
            diffStr.add(mcn);
        }
        for (String mcn : mcn2) {
            diffStr.add(mcn);
        }
        return diffStr.size();
    }
}
