package 岛屿数量问题;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-05 12:54
 **/
public class 岛屿数量深搜版 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//代表上左下右的方向

    public static void dfs(boolean[][] visited, int x, int y, int[][] grid) {//grid是指网格，很经典//这里的dfs就是用来标记网格周围的所有节点全部标记的！！
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length)//这里的条件是指越界了，直接返回
                continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {//没有访问过的同时是陆地的
                visited[nextX][nextY] = true;//立即声明已访问过
                dfs(visited, nextX, nextY, grid);//递归调用下一步的坐标
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//输入网格作为图的连通性
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];//最初所有的网格都没有访问过

        int ans = 0;
        for (int i = 0; i < m; i++) {//这里两个循环与递归是为了遍历每一个节点并且确保与之相邻的所有网格都是标记过的@@@@
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;//这就是最终答案
                    visited[i][j] = true;
                    dfs(visited, i, j, grid);
                }
            }
        }
        System.out.println(ans);
    }
}
