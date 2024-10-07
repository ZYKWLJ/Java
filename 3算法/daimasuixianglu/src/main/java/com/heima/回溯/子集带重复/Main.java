package com.heima.回溯.子集带重复;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-10 20:18
 **/
public class Main {
    static List<List<Integer>> res=new LinkedList<>();
    static List<Integer> path=new LinkedList<>();
static int count=0;
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,3};
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        dfs(nums, 0,used);
        System.out.println(res.toString());
    }

    private static void dfs(int[] nums, int startIndex, boolean[] used) {
        //if (startIndex==nums.length) {
        res.add(new LinkedList<>(path));
        //}
        for (int i = startIndex; i < nums.length; i++) {

            if (i>0&&(nums[i]==nums[i-1])&&!used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(nums,i+1, used);
            path.removeLast();
            used[i]=false;
        }
    }
}