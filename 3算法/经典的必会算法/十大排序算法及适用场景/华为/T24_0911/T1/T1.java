package 十大排序算法及适用场景.华为.T24_0911.T1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-11 20:36
 **/
public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n=input.nextInt();
        int[][] nums=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[m][n]=input.nextInt();
            } 
        }
        System.out.println(solve(nums));
    }

    private static int solve(int[][] nums) {
        int len0=nums.length;
        int len1=nums[0].length;
        int PathSum=0;
        int [][] path={{0,1},{1,0},{0,-1},{-1,0}};
        //对每个小区执行BFS
        Queue<int[]> LJ=new LinkedList<>();
        for (int i = 0; i < len0; i++) {
            for (int j = 0; j < len1; j++) {
                if (nums[len0][len1]==0){
                    LJ.add(new int[]{i,j});//标记每一个垃圾的位置
                }}}

        //找到小区
        for (int i = 0; i < len0; i++) {
            for (int j = 0; j < len1; j++) { 
                if (nums[len0][len1]==1){
                    int minSum=Integer.MAX_VALUE;
                //   复位访问过的
                    boolean[][] visit=new boolean[len0][len1];
                //    对每个垃圾执行BFS
                    for (int[] Lj : LJ) {
                        int dis=bfs(nums,visit,i,j,Lj[0],Lj[1]);
                    //    如果找到了最近的垃圾站
                        if (minSum!=Integer.MAX_VALUE){
                            PathSum+=minSum;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static int bfs(int[][] nums, boolean[][] visit, int starti, int startj, int LjRow, int LjCol) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{
                LjRow,LjCol
        });
        visit[LjRow][LjCol]=true;
        int dis=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur=queue.poll();
                int row=cur[0];
                int col=cur[1];
                if (row==starti&&col==startj){
                    return dis;
                }
                for (int i1 : cur) {
                    
                }
            }
        }
        return 0;
    }
}
