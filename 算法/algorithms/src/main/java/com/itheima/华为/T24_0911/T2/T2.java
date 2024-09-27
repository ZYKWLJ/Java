package com.itheima.华为.T24_0911.T2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-11 19:27
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums=new int[n*3];//表示所有数据
        int[] maxNum=new int[n];
        Map<Integer ,Integer> map=new HashMap<>();
        int[][] min2MaxNum=new int[n][2];//表示每一行的最小值、最大值的数组表
        int max=0;
        int min=0;
        int count=0;
        for (int i = 0; i < 3*n; i++) {
            nums[i]=input.nextInt();
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            //统计每一次(3个数)的最大值\最小值，判断最小值是否大于下面的最大值即可，如果可以，那就是可以重叠
            if((i+1)%3==0){
                min2MaxNum[count++][0]=min;
                min2MaxNum[count][1]=max;

                max=0;//下一个盒子的最大值置
                min=0;//下一个盒子的最小值置零零
            }
        }
        //将所有的礼盒大小按照最小值先排序
        int[][] min2MaxNumNoDup=new int[n][2];//表示每一行的最小值、最大值的数组表,并且去重了的。
        Arrays.sort(min2MaxNum,(a,b)->Integer.compare(a[0],b[0]));
        //贪心。如果满足，就要找到最小满足的那一个（最小的最大值），因为这样方便上面再加盒子
        int left=0;
        int right=0;
        for (; left < n; left++) {
            while (min2MaxNum[left][0]==min2MaxNum[right][0]){
                min2MaxNumNoDup[count][0]=min2MaxNum[count][0];
                min2MaxNumNoDup[count][1]=Math.min(Math.min(min2MaxNum[left][1],min2MaxNum[right][1]),min2MaxNumNoDup[count][1]);//最大值要最小的。
                right++;//不等于的时候就可以找最大的了！
            }
            left=right;
            count++;






            //if (min2MaxNum[i-1][0]<min2MaxNum[i][0])
            if (min2MaxNum[left][1]>=min2MaxNum[right][0]) {
                right++;//说明还要往后移
            }else{
            //    这里说明最值条件满足了，但是还要满足最值里面的最小的那个！就只要满足相同的最小值，取最小的最大值就行了。

            }
        }

        //先要分区间，将最小值相同的情况统计完即可！，直至遇到下一个最小值不一样的盒子。这样每一次放置的都是最满足最贪心的盒子。

        System.out.println(slove(n,nums,maxNum));
    }

    private static int slove(int n, int[] nums, int[] maxNum) {
        //逻辑就是如果maxNum


        return 0;
    }
}
