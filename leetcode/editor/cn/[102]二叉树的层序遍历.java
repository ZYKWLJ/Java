package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution102{
    public static void main(String[] args) {
        Solution solution = new Solution102().new Solution();
        // 创建一个二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    //List<TreeNode> path=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        return iter(root);
    }
    private List<List<Integer>> iter(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root==null)return list;
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer>path = new LinkedList<>();
            while (size-->0){
                TreeNode node = q.pop();
                path.add(node.val);
                if (node.left!=null)q.add(node.left);
                if (node.right!=null)q.add(node.right);
            }
            list.add(path);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












