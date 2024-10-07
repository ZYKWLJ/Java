package editor.cn;


import javax.print.DocFlavor;
import java.util.HashMap;

class Solution1 {
    public static void main(String[] args) {
        Solution solution = new Solution1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            //使用哈希表来解决，意思是每一个元素存在里面，查找对应的num[i],查找有咩有target-num[i]。这是O(n2)
            return hash(nums, target);
            //暴力解法既然能过
            //return forfor(nums, target);
        }

        private int[] hash(int[] nums, int target) {
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = target - nums[i];
                if (integerIntegerHashMap.containsKey(num)) {
                    return new int[]{i, integerIntegerHashMap.get(num)};
                }
                integerIntegerHashMap.put(nums[i], i);//这里巧妙解决了重叠问题，即当前还没有加入进来不可能用两次，而且是极大提速。
            }
            return null;
        }

        private int[] forfor(int[] nums, int target) {
            int l = 0;
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        l = i;
                        r = j;
                        break;
                    }
                }
            }
            return new int[]{l, r};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












