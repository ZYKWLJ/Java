package com.itheima.腾讯;
/*
 * @description 二叉树节点定义
 * @params
 * @return
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val=val;
    }
}

public class WeightAdvantagePathCount {
    static int countOneThanZero(TreeNode root,int oneNum,int zeroNum){
        if(root==null){
            return 0;
        }
//            处理叶子结点的特殊情况
        if (root.left==null&&root.right==null){
            if (root.val==1)oneNum++;
            zeroNum++;
//            只要符合条件就计数加1，否则就不计数
            if (oneNum-zeroNum==1)return 1;
            return 0;
        }

        if (root.val==1)oneNum++;
        zeroNum++;
//        遍历完左右节点就可以得到总的满足条件的路径数
        int left=countOneThanZero(root.left,oneNum,zeroNum);
        int right=countOneThanZero(root.right,oneNum,zeroNum);
//        这里的操作就是将满足的所有路径数相加。(想不不明白的话，可以假定是只有两天支路，就很好想了)；
        return left+right;
    }

    /*
     * @description 快速根据数组构建二叉树(层序遍历)
     * @params
     * @return
     */

       public static  TreeNode buildTree(Integer[] data) {
//           先判断是非，宏观把握，很好
               if (data.length == 0 || data[0] == -1) return null;

               Queue<TreeNode> queue = new LinkedList<>();
               TreeNode root = new TreeNode(data[0]);
               queue.add(root);
               int index = 1;

               while (!queue.isEmpty() && index < data.length) {
                   TreeNode currentNode = queue.poll();

                   // Assign left child(赋值左子树)
                   if (index < data.length && data[index] != -1) {
                       currentNode.left = new TreeNode(data[index]);
                       queue.add(currentNode.left);
                   }
                   index++;

                   // Assign right child(赋值右子树)
                   if (index < data.length && data[index] != -1) {
                       currentNode.right = new TreeNode(data[index]);
                       queue.add(currentNode.right);
                   }
                   index++;
               }

               return root;
           }


           /*
            * @description 快速创建数组测试ACM
            * @params
            * @return
            */

       public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);
               int n = scanner.nextInt();
               Integer[] data = new Integer[n];
               for (int i = 0; i < n; i++) {
                   data[i] = scanner.nextInt();
               }
               TreeNode root= buildTree(data);
               int total=countOneThanZero(root,0,0);
                System.out.println(total);

        }
}