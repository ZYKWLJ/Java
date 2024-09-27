package com.heima.回溯.子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-10 20:04
 **/
public class Main {
    static List<List<Integer>> res=new LinkedList<>();
    static List<Integer> path=new LinkedList<>();

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        Arrays.sort(nums);
        dfs(nums, 0);
        System.out.println(res.toString());
    }
//[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

    private static void dfs(int[] nums, int startIndex) {
        //if (startIndex==nums.length) {
            res.add(new LinkedList<>(path));
        //}
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums,i+1);
            path.removeLast();
        }
    }
}
