package com.heima.回溯.组合;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 14:12
 **/
public class T1 {
    static List<List<Integer>> res= new LinkedList<>();
    static List<Integer> path= new LinkedList<>();
    static int count =0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k=input.nextInt();
        solve(n,k,1);
        System.out.println(res.toString());
        System.out.println("count="+count);
    }

    private static void solve(int n, int k, int startIndex) {
        if (path.size()==k){
            res.add(new LinkedList<>(path));
            count++;
            return;
        }
        //这里可以做一个优化，就是至少要保证有k个数字，那么在层遍时，剩余的数字小于k之后就不能继续了，所以这里应该是i<XXX
        //总共有n个数字，我要k个数字，path里面有path.size()个，那么初始时我的起始不能超过：n-k+1，但是后面我的path里面装有元素了
        //最多不能超过n-k+1+path.size();
        //比如我要3个，总共有5个，不能超过3

        //初始版本
        //for (int i = startIndex; i <=n; i++) {
        //剪枝版本
        for (int i = startIndex; i <=n-k+1+path.size(); i++) {
            path.add(i);
            solve(n,k,i+1);
            path.removeLast();
        }
    }
}
