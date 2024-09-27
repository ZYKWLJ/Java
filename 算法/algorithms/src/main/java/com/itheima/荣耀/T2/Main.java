package com.itheima.荣耀.T2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-26 19:32
 **/
public class Main {
    static class Task{
        int files;
        int servers;

        public Task(int files, int servers) {
            this.files = files;
            this.servers = servers;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total=scanner.nextInt();//集群中的机器数量

    //    定义任务列表
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(300,20));
        tasks.add(new Task(500,30));
        tasks.add(new Task(620,50));
        tasks.add(new Task(370,30));
        tasks.add(new Task(400,50));
        tasks.add(new Task(450,30));
        tasks.add(new Task(380,40));
        tasks.add(new Task(150,10));
        //纯背包问题，价值为文件数量，重量为服务器数量

        int[] dp = new int[total+1];
        for (Task task : tasks) {
            for (int i = total; i >= task.servers; i--) {
                dp[i]= Math.max(dp[i],dp[i-task.servers]+task.files);
            }
        }
        System.out.println(dp[total]);
    }
}
