package editor.cn;

import java.io.CharConversionException;
import java.util.Arrays;

class Solution209 {
    public static void main(String[] args) {
        Solution solution = new Solution209().new Solution();
        int[] ints = new int[]{1,2,3,4,5};
        solution.prefix(2,ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //子数组也好，子串也好，前缀和是通杀
            return prefix(target,nums);

            //return slidingWindow(target, nums);

        }

        private int slidingWindow(int target, int[] nums) {
            int l = 0;
            int r = 0;
            int currSum = 0;
            int minLen = Integer.MAX_VALUE;
            //外部划窗
            while (r < nums.length) {
                currSum += nums[r];
                //内部划窗
                while (currSum >= target) {
                    minLen = Math.min(minLen, r - l + 1);
                    currSum -= nums[l++];
                }
                r++;
            }
            return minLen==Integer.MAX_VALUE?0:minLen;
        }


        private int prefix(int target, int[] nums) {
            //因为是正整数，所以前缀和一定是递增的，注意要在最前面留出来一个0，那么显然
            //前缀+二分(nlong(n)复杂度，美丽！)
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[n + 1];
            // 为了方便计算，令 size = n + 1
            // sums[0] = 0 意味着前 0 个元素的前缀和为 0
            // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
            // 以此类推
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                int sum = target + sums[i - 1];
                int bound = Arrays.binarySearch(sums, sum);
                if (bound < 0) {
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












