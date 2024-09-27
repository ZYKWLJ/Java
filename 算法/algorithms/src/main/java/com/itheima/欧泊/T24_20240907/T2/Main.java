package com.itheima.欧泊.T24_20240907.T2;

import java.util.*;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 11:45
 **/
public class Main {
    static List<Long> path=new ArrayList<>();
    static  int count=0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 6;
        long[] nums=new long[]{1,1,2,2,3,4,};
        boolean[] used =new boolean[n];
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("下面是没有去重的");
        System.out.println(Solve(nums,0));
        System.out.println();
        System.out.println("下面是去重了的");
        count=0;
        System.out.println(SolveWithoutSame(nums,0,used));
    }


    private static int Solve(long[] nums,int startIndex) {
        if (path.size()==3){
            System.out.println("path = " + path.toString());
            count++;
            return count;
        }
        for (int i = startIndex; i <nums.length; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
            }else{
                continue;
            }
            count= Solve(nums,i+1);//注意这里不能写成++i之类，因为这会导致i变化！！只能是i+1,切记！！！
            path.removeLast();
        }
        return count;
    }

    private static int SolveWithoutSame(long[] nums,int startIndex,boolean[] used) {
        if (path.size()==3){
            System.out.println("path = " + path.toString());
            count++;
            return count;
        }
        for (int i = startIndex; i <nums.length; i++) {
            if (i>0&&nums[i-1]==nums[i]&&(!used[i-1])){
                continue;
            }else if(path.contains(nums[i])){
                continue;
            }else{
                path.add(nums[i]);
            }
            used[i]=true;
            count= SolveWithoutSame(nums,i+1,used);//注意这里不能写成++i之类，因为这会导致i变化！！只能是i+1,切记！！！
            path.removeLast();
            used[i]=false;
        }
        return count;
    }
}
