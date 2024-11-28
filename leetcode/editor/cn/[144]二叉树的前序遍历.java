package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution144 {
    public static void main(String[] args) {
        Solution solution = new Solution144().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<Integer> list = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            //    递归法
            return dfs(root);

            //    迭代法
            //return iter(root);
        }

        //DFS使用栈来完成迭代模拟！！
        private List<Integer> iter(TreeNode root) {
            Stack<TreeNode> st = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) return list;
            st.push(root);
            while (st.isEmpty() == false) {
                TreeNode node = st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                list.add(node.val);
            }
            return list;
        }

        private List<Integer> dfs(TreeNode root) {
            if (root == null) return list;
            //    在遍历头结点就好了
            list.add(root.val);
            //   左右子树已经遍历好了
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            //    返回递归的入口root
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












