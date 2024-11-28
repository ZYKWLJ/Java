package editor.cn;

import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution590 {
    public static void main(String[] args) {
        Solution solution = new Solution590().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

  class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> postorder(Node root) {
            //    dfs
            //    return dfs(root);

            //    一般迭代
            //    return iter(root);

            //    统一迭代
            return iterUniform(root);
        }

        //这里是完全模拟递归，是完全迭代，全部都加入栈了。
        //将调整顺序与加入结果分离。目标明确！
        private List<Integer> iterUniform(Node root) {
            Stack<Node> st = new Stack<>();
            if (root == null) return list;
            st.push(root);
            while (st.isEmpty() == false) {
                Node peek = st.peek();
                if (peek != null) {
                    Node pop = st.pop();
                    st.push(pop);//这里再加入刚才弹出的节点，仅仅只是做一个模拟递归的动作，这里就是调整顺序用的。
                    st.push(null);
                    for (int i = pop.children.size() - 1; i >= 0; i--) {
                        if (pop.children.get(i) != null) st.push(pop.children.get(i));
                    }

                } else {//真正的加入节点结果值是在这里！
                    st.pop();//先弹出空节点
                    list.add(st.pop().val);//再加入真实节点
                }
            }
            return list;
        }

        //这里只有两层迭代，因为只有左右加入栈。
        private List<Integer> iter(Node root) {
            Stack<Node> st = new Stack<>();
            if (root == null) return list;
            st.push(root);
            while (st.isEmpty() == false) {
                Node pop = st.pop();
                int size = pop.children.size();
                for (int i = 0; i < size; i++) {
                    st.push(pop.children.get(i));
                    //对了嘛，这里的遍历要先全部相反，后面再调换顺序，刚好就是后序。结束了顺序就是中、右、左。反过来刚好是左、右、中。这里很妙的！！
                }
                list.add(pop.val);
            }

            Collections.reverse(list);
            return list;
        }

        //这里的递归是最简单的@！
        private List<Integer> dfs(Node root) {
            if (root == null) return list;
            for (Node node : root.children) {
                dfs(node);
            }
            list.add(root.val);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












