package editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution496 {
    public static void main(String[] args) {
        Solution solution = new Solution496().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            //    显然单调栈
            //    首先遍历数组1
            int[] res1 = new int[nums1.length];
            int[] res2 = new int[nums2.length];
            Arrays.fill(res1, -1);
            Arrays.fill(res2, -1);
            LinkedList<Integer> integersStack = new LinkedList<>();

            //求出了原数组里面每一个了，然后再在子数组里面按需求取出便是
            for (int j = 0; j < nums2.length; j++) {
                //   外层的循环就是为了遍历所有，以及找到定位
                while (!integersStack.isEmpty() && nums2[ integersStack.peek()]< nums2[j]) {
                    res2[integersStack.pop()] = nums2[j];
                }
                integersStack.push(j);
            }

            // 使用哈希表存储 nums2 中每个元素的下一个更大元素
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], res2[i]);
            }

            // 根据哈希表快速查找 nums1 中每个元素在 nums2 中的下一个更大元素
            for (int i = 0; i < nums1.length; i++) {
                res1[i] = map.getOrDefault(nums1[i], -1);
            }

            return res1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












