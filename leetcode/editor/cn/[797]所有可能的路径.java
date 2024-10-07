package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution797 {
    public static void main(String[] args) {
        Solution solution = new Solution797().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            path.add(0);
            dfs(graph, 0);
            return res;
        }

        private void dfs(int[][] graph, int currNode) {
            if (currNode==graph.length-1){
                res.add(new LinkedList<>(path));
                return;
            }
            //这是邻接矩阵的写法
            //for (int i = 1; i < graph.length; i++) {
            //    //if (graph[currNode][i]==1){     //找到链接当前节点的下一个节点,这是邻接矩阵的写法
            //        path.add(i);
            //        dfs(graph,i);
            //        path.removeLast();
            //    //}
            //}

            //本题给出的是邻接表的图，所以用这种
            for(int i:graph[currNode]){     //这是临街表的写法，group[currNode]表示与currNode相连接的节点有哪些！！！
                path.add(i);
                dfs(graph,i);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}





//graph = [[1,2],[3],[3],[]]具体含义如下：
//这个图一共有 4 个节点，因为列表中有 4 个子列表。
//第一个子列表[1, 2]表示节点 0 指向节点 1 和节点 2。
//第二个子列表[3]表示节点 1 指向节点 3。
//第三个子列表[3]表示节点 2 指向节点 3。
//第四个子列表[]表示节点 3 没有向外的边。


//Scanner scanner = new Scanner(System.in);
////int N = scanner.nextInt();
////int M = scanner.nextInt();
////int[][] graph = new int[N][N];
////
////for (int i = 0; i < M; i++) {
////    //不一定要有N*N个连接，但是一定要右自己的输入的连接。这里的M代表的那几条边的连接情况。
////    int s = scanner.nextInt();
////    int t = scanner.nextInt();
////    // 使用邻接矩阵表示无向图，1 表示 s 与 t 是相连的
////    graph[s][t] = 1;
////}
//
//int N=5;
//int M=5;
//int[][] graph = new int[N][N];
//graph[0][2]=1;
//graph[2][4]=1;
//graph[0][1]=1;
//graph[1][3]=1;
//graph[3][4]=1;
//
//solution.path.add(0);
//solution.dfs(graph,0,N-1);
//
//if (solution.res.isEmpty()){
//    System.out.println(-1);
//}
//for (List<Integer> path:solution.res) {
//    for (int i = 0; i < path.size() - 1; i++) {
//        System.out.print(path.get(i)+1+"->");
//    }
//    System.out.println(path.get(path.size()-1)+1);
//}









