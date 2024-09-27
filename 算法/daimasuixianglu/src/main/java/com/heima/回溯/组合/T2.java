package com.heima.回溯.组合;

import java.util.LinkedList;
import java.util.List;
//import java.util.ResourceBundle;
import java.util.Scanner;

//import static com.heima.backTracking.组合.T1.solve;

//import static com.heima.backTracking.组合.T1.solve;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 14:37
 **/
public class T2 {
    static List<List<Integer>> res=new LinkedList<>();
    static List<Integer> path=new LinkedList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k=input.nextInt();
        solve(n,k,0,1);
        System.out.println(res.toString());
    }

    private static void solve(int n, int k,int sum,int startIndex) {
        if (path.size()==k&&sum==n){
            res.add(new LinkedList<>(path));
            System.out.println("path = " + path.toString());
            return;
        }
        if (path.size()>k)return;

        for (int i = startIndex; i < 10; i++) {
            sum+=i;
            if(sum>n){
                break;
            }
            path.add(i);
            solve(n,k,sum,i+1);
            sum-=i;
            path.removeLast();
        }
    }
}
