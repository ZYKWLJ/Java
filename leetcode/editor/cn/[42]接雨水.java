package editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution42 {
    public static void main(String[] args) {
        Solution solution = new Solution42().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这一题如果可以将这里的全部做法都噶出来就美滴很！！
        public int trap(int[] height) {
            //    双指针
            //    return point2(height);

            //    单调栈
            //return indexStack(height);

            //    dp
                return dp(height);

            //    前后缀分离
            //return preSuf(height);
        }


        //这里的倒扣法和前后缀分离法好像后者是专有的一个算法区块。不过dp和他一样的。
        private int preSuf(int[] height) {
            int n = height.length;
            int[] preMax = new int[n]; // preMax[i] 表示从 height[0] 到 height[i] 的最大值
            preMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                preMax[i] = Math.max(preMax[i - 1], height[i]);
            }

            int[] sufMax = new int[n]; // sufMax[i] 表示从 height[i] 到 height[n-1] 的最大值
            sufMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sufMax[i] = Math.max(sufMax[i + 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(preMax[i], sufMax[i]) - height[i]; // 累加每个水桶能接多少水
            }
            return ans;
        }

        //dp法应该是最好理解的，但是降维打击在于需要先把图像画出来
        //leftMax[i] 表示下标 i 及其左边的位置中，height 的最大高度，rightMax[i] 表示下标 i 及其右边的位置中，height 的最大高度。
        private int dp(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];//精髓在此！这是因为使用倒扣法来做的！！详见题解，这的顶！！
            }
            return ans;
        }


        //单调栈法，凹槽法，构建凹槽并填坑
        //找凹槽，右边第一个最大，左边第一个最大，取较小值，最后乘以宽度即可！
        private int indexStack(int[] height) {
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int right = 0; right < height.length; right++) {//这里使用right更加贴切题意
                while (!st.isEmpty() && height[right] >= height[st.peek()]) {//碰见右边第一个大的了，就在前面去找左边的值。
                    int aoCao = height[st.pop()];
                    if (st.isEmpty()) {
                        break;
                    }
                    int left = st.peek();
                    int dh = Math.min(height[left], height[right]) - aoCao;
                    // 面积的高(防止溢出，所以是较短的最大值减去凹槽值，因为是从左边遍历过来的，所以就算两者的较低值，也比凹槽值低)
                    ans += dh * (right - left - 1);//宽*高=面积
                }
                st.push(right);
            }
            return ans;
        }


        //这是我见过最美的算法代码(迄今为止！！)没有之一
        private int point2(int[] height) {
            int ans = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
            while (left <= right) {
                leftMax = Math.max(leftMax, height[left]);//更新左端的最大值
                rightMax = Math.max(rightMax, height[right]);//更新右端的最大值(一定只有更大值-第二大值才会累积水嘛)
                ans += leftMax < rightMax ? leftMax - height[left++] : rightMax - height[right--];//(谁小计算谁，这样皆可以确保另一头不会溢出！好真实！)
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












