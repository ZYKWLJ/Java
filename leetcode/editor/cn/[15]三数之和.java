package editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution15{
    public static void main(String[] args) {
        Solution solution = new Solution15().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            //既然说了是双指针，那就开始吧,还可以减枝
            return doublePointer(nums);

    }
        //正确版本的双指针，一头一尾.这是一个公式！！！
        //这代码是真优美！！
        private List<List<Integer>> doublePointer(int[] nums) {
            Arrays.sort(nums);
            // 找出a + b + c = 0
            // a = nums[i], b = nums[left], c = nums[right]

            for (int i = 0; i < nums.length; i++) {
                // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了

                if (nums[i] > 0) {
                    return res;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[left] + nums[right];
                    //这里就是这个算法的核心@！！！
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;

                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重(就是担心出现0,0,0 这种情况，所以不能直接压缩去重)
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












