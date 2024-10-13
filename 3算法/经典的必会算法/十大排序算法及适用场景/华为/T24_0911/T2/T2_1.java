package 十大排序算法及适用场景.华为.T24_0911.T2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-11 20:17
 **/
//最长上升子序列典型题目

public class T2_1 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();//这里将长宽高分组就很好！！
        //int[][] nums=new int[n][3];
        //for(int i = 0; i < n; i++) {
        //    nums[i][0]=input.nextInt();//记录长
        //    nums[i][1]=input.nextInt();//记录宽
        //    nums[i][2]=input.nextInt();//记录高
        //}
        //int[][] nums = new int[][]{{1,1,1},{2,3,4},{3,6,7},{4,5,6}};
        int[][] nums=new int[][]{{1,1,1},{1,1,1},{2,2,2},{2,2,2}};
        System.out.println(MaxHeightBox(nums));
    }

    private static int MaxHeightBox(int[][] nums) {
        //定义dp[i]表示前i个盒子能堆起来的最高高度
        int n=nums.length;
        int[] dp=new int[n];

        //初始化dp数组
        for (int i = 0; i < n; i++) {
            dp[i]=nums[i][2];//初始化高度为盒子自身高度
        }

        //dp求解最值
        for (int i = 0; i < n; i++) {//按顺序遍历所有盒子
            for (int j = 0; j < i; j++) {//就是考虑当前盒子加了后，重新遍历前面所有盒子的情况。[和最少次数加油站的一题极为相似，也是这么说的，添加都差不多，转化一下就好了]
                if (nums[j][0]<nums[i][0]&&nums[j][1]<nums[i][1]&&nums[j][2]<nums[i][2]){
                    dp[i]=Math.max(dp[i],dp[j]+nums[i][2]);
                }
            }
        }
        //求解最值
        int maxHeight = 0;
        for (int height : dp) {
            maxHeight=Math.max(maxHeight,height);//求解所有dp的最大值(从下面的测试也看出了，不一定dp越到后面越大，因为后面的盒子不一定参与，所以一定要遍历)
        }
        for (int i = 0; i < n; i++) {
            System.out.println("dp["+i+"] = " + dp[i]);
        }
        return maxHeight;
    }
}


//测试用例1
//4
//        1 1 1
//        2 3 4
//        3 6 7
//        4 5 6
//dp[0] = 1
//dp[1] = 5
//dp[2] = 12
//dp[3] = 11
//        12

//测试用例2
//{1,1,1},{1,1,1},{2,2,2},{2,2,2}

//dp[0] = 1
//dp[1] = 1
//dp[2] = 3
//dp[3] = 3
//        3
//
