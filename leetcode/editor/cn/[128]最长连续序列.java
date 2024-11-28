package editor.cn;

import java.util.*;

class Solution128 {
    public static void main(String[] args) {
        Solution solution = new Solution128().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num - 1)) {//核心就是这，找到开头的那一个数(不是开头的就直接跳过)，然后开始一直遍历就好！
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












