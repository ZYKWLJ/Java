package editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution145{
    public static void main(String[] args) {
        Solution solution = new Solution145().new Solution();
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
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root==null)return list;
        st.push(root);
        while (st.isEmpty()==false){
            TreeNode pop = st.pop();
            list.add(pop.val);//这只是前序遍历，改变不了的。
            if (pop.left!=null)st.push(pop.left);
            if (pop.right!=null)st.push(pop.right);
        //    只有参加栈的才会顺序变化，所以这里的顺序是中右左。之后再反转就是左右中，刚好是后序遍历的顺序。很巧妙的！
        }
        Collections.reverse(list);
        return list;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












