package editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution239 {
    public static void main(String[] args) {
        Solution solution = new Solution239().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            //方法2：单调栈
            return Indexstack(nums, k);
        }

        //单调栈又称为序号栈，就是存储的元素的下标用的。
        private int[] Indexstack(int[] nums, int k) {
            int[] max = new int[nums.length - k + 1];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();//维护st的单调性
                st.addLast(i);
                if (i - st.getFirst() >= k) st.removeFirst();//端口出队列了
                if (i >= k - 1) max[i - k + 1] = nums[st.getFirst()];//因为单调，所以窗口首就是最大值。
            }
            return max;
        }


        //单调栈又称为序号站，就是存储的元素的下标用的。
        //private int[] Indexstack(int[] nums, int k) {
        //    int n = nums.length;
        //    int[] ans = new int[n - k + 1];
        //    Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        //    for (int i = 0; i < n; i++) {
        //        // 1. 入
        //        while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
        //            q.removeLast(); // 维护 q 的单调性
        //        }
        //        q.addLast(i); // 入队
        //        // 2. 出
        //        if (i - q.getFirst() >= k) { // 队首已经离开窗口了
        //            q.removeFirst();
        //        }
        //        // 3. 记录答案
        //        if (i >= k - 1) {
        //            // 由于队首到队尾单调递减，所以窗口最大值就是队首
        //            ans[i - k + 1] = nums[q.getFirst()];
        //        }
        //    }
        //    return ans;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}












