package com.itheima.美团.T23.T3;

import java.util.Scanner;


/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-06 17:51
 **/

/*核心点：横竖单变量声明！
*heng[i]+=cake[i][j];
 shu[j]+=cake[i][j];
*/
public class T3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m=input.nextInt();
        int[][] cake=new int[n][m];

        int total=0;
        //heng[i]表示截止切到第几行时，上面的蛋糕总美味度。
        int[] heng=new int[n];
        //shu[i]表示截止切到第i列时，左边的蛋糕总美味度。
        int[] shu =new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cake[i][j]=input.nextInt();
                total+=cake[i][j];
                heng[i]+=cake[i][j];
                shu[j]+=cake[i][j];

            }
        }
          for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("cake["+i+"]["+j+"]=" + cake[i][j]+"\t");
                System.out.print("heng["+i+"]=" + heng[i]+"\t");
                System.out.println("shu["+j+"]=" + shu[j]);
                System.out.println(total);
            }
        }
        System.out.println(solve(n,m,heng,shu,total));
    }

    private static int solve(int n, int m, int[] heng,int[] shu,int total) {
        /*
         * @description 显然考察的是矩阵的运算能力。共有横着n-1，竖着m-1刀，求最小即可。
         * @params
         * @return
         */
        int minDIff=Integer.MAX_VALUE;
        //横着qie的最大值

        int[] hengTotal=new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            hengTotal[i]+=heng[i]+(i>0?hengTotal[i-1]:0);;
            minDIff=  Math.min( Math.abs(hengTotal[i]-(total-hengTotal[i])),minDIff) ;

            System.out.print("hengTotal["+i+"]=" + hengTotal[i]+"\t");
            System.out.println("minDIff = " + minDIff);;
        }
        int[] shuTotal=new int[m-1];
        for (int i = 0; i < m-1 ; i++) {
            shuTotal[i]+=shu[i]+(i>0?shuTotal[i-1]:0);
            minDIff=Math.min( Math.abs(shuTotal[i]-(total-shuTotal[i])),minDIff);
            System.out.print("shuTotal["+i+"]=" + shuTotal[i]+"\t");
            System.out.println("minDIff = " + minDIff);
        }
        return minDIff;
    }
}
