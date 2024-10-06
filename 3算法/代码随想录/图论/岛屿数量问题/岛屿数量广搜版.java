package 岛屿数量问题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-05 17:19
 **/
public class 岛屿数量广搜版 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//代表每一个步骤x与y的变化趋势，每一个子集都是x与y的变化

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<pair> queue = new LinkedList<pair>();//定义坐标队列，需要自定义一个pair类
        queue.add(new pair(x, y));
        visited[x][y] = true;//遇到入队直接标记为优先，否则后面还有重复访问【这一部很重要，防止超时】
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;

            for (int i = 0; i < 4; i++) {//顺时针遍历新节点next。下面记录坐标。
                int nextX = curX + dir[i][0];//横坐标
                int nextY = curY + dir[i][1];//纵坐标
                if (nextY < 0 || nextY >= grid.length || nextX < 0 || nextX >= grid.length) {
                    continue;
                }//去除越界部分
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] grid = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    bfs(grid, visited, i, j);//将周围的全部标记
                }
            }
        }

        System.out.println(ans);
    }


    static class pair {
        int first;
        int second;

        public pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }
}
