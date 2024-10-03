package com.heima.回溯.组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-08 22:49
 **/
public class T4 {
    List<List<Integer>> res=new LinkedList<List<Integer>>();
    List<Integer> path=new LinkedList<>();

     public List<List<Integer>> combinationSum2(int[] candidates, int target, int i, int i1, boolean[] used) {
        //boolean used[] = new boolean[candidates.length];
        Arrays.sort(candidates);
        return backTracking(candidates,target,0,0,used);
    }

    private List<List<Integer>> backTracking(int[] candidates,int target,int startIndex,int sum,boolean[] used){
        if(sum==target){
            this.res.add(new LinkedList<Integer>(this.path));
            return res;
        }
        for(int i=startIndex;i<candidates.length;i++){
            if(i>0&&(candidates[i]==candidates[i-1]&&!used[i-1])){
                continue;
            }
            if(candidates[i]+sum>target)break;
            this.path.add(candidates[i]);
            sum+=candidates[i];
            used[i]=true;
            this.res = backTracking(candidates,target,i+1,sum,used);
            this.path.removeLast();
            sum-=candidates[i];
            used[i]=false;
        }
        return res;
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
       int[] nums= new int[]{1,3,4,1,3,3,2,2,2,5,6,0,4,2};
       Arrays.sort(nums);
       boolean[] used=new boolean[nums.length];
        System.out.println(t4.combinationSum2(nums,5,0,0,used).toString());

    }
}
