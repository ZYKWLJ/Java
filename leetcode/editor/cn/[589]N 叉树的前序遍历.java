package editor.cn;

import java.util.*;

class Solution589{
    public static void main(String[] args) {
        Solution solution = new Solution589().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
        Stack stack=new Stack<Node>();
        List<Integer> list=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        //迭代法
        return iter(root);

        //    dfs
        //return dfs(root);
    }

    private List<Integer> dfs(Node root) {
        if(root==null)return list;
        list.add(root.val);
        for(Node node: root.children){
            dfs(node);
        }
        return list;
    }

    private List<Integer> iter(Node root) {
        Stack<Node> st = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root==null) return list;
        st.push(root);
        while (st.isEmpty()==false){
            Node node = st.pop();
            list.add(node.val);
            int size=node.children.size();

            while (size>0){
                st.push(node.children.get(--size));
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












