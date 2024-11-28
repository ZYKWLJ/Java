package editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution94 {
    public static void main(String[] args) {
        Solution solution = new Solution94().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return list;
            Stack<TreeNode> st = new Stack<>();
            st.add(root);
            while (!st.isEmpty()) {
                    TreeNode node = st.peek();
                    if (node != null) {
                        TreeNode realNode = st.pop();
                        if (realNode.right != null) st.push(realNode.right);
                        st.push(realNode);
                        st.push(null);
                        if (realNode.left != null) st.push(realNode.left);
                    } else {
                    //    弹出空节点
                        st.pop();
                        TreeNode peekNode = st.peek();
                        st.pop();
                        list.add(peekNode.val);
                    }
                }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












