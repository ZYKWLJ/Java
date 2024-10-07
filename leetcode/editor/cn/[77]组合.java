package editor.cn;

import java.util.LinkedList;
import java.util.List;

class Solution77{
    public static void main(String[] args) {
        Solution solution = new Solution77().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path= new LinkedList<Integer>();
    List<List<Integer>>  res= new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

        private void dfs(int n, int k, int startIndex) {
            if (path.size()==k){
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = startIndex; i < n+1; i++) {
                path.add(i);
                dfs(n,k,i+1);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
