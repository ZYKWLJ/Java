package editor.cn;

import java.lang.annotation.Target;
import java.util.Arrays;

class Solution27{
    public static void main(String[] args) {
        Solution solution = new Solution27().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
    // 原地、移除元素、不使用额外空间==>100%双指针
        Arrays.sort(nums);
       int l=0;
       int r=0;
        for (; r <nums.length; r++) {
            int curr=nums[r];
            if (curr!=val){
                nums[l++]=curr;
            }
        }
        return l;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












