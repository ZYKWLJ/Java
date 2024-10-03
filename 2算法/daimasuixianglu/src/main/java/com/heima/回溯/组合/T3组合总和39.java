package com.heima.回溯.组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 14:55
 **/
class Solution {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] num=new int[]{2 ,3 ,6,7};
        int target=7;
        System.out.println(combinationSum(num, target).toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        slove(target, candidates, res, path, 0, 0);
        return res;
    }

    private static void slove(int target, int[] nums, List<List<Integer>> res, List<Integer> path, int sum, int startIndex) {
        if (sum == target) {
            res.add(new LinkedList<>(path));
        }
        for (int i = startIndex; i < nums.length; i++) {

            if (sum + nums[i] > target) {
                //直接掐断！！还有一种是continue，是重复的元素！！
                break;
            }

            sum+=nums[i];
            path.add(nums[i]);
            slove(target, nums, res, path, sum, i);
            sum -= nums[i];
            path.removeLast();
        }
    }
}
