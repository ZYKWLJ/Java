package editor.cn;

import java.lang.annotation.Target;
import java.util.Arrays;

class Solution34{
    public static void main(String[] args) {
        Solution solution = new Solution34().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int val) {
        Arrays.sort(nums);
        if (nums.length==0||val<nums[0]||val>nums[nums.length-1])return new int[]{-1,-1};
        int left=leftBinary(nums,val);
        int right=rightBinary(nums,val);
        //二分逼近的精髓在于借助while循环与具体工作查询最终逼近的那个值！！
        return new int[]{left,right};
    }
        private int leftBinary(int[] nums, int val) {
            int l=0;
            int r=nums.length-1;
            while (l<=r){
                int mid=l+((r-l)>>>1);
                if (nums[mid]>= val){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
            return nums[r+1]==val?r+1:-1;
        }

        private int rightBinary(int[] nums, int val) {
            int l=0;
            int r=nums.length-1;
            while (l<=r){
                int mid=l+((r-l)>>>1);
                if (nums[mid]<= val){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            return nums[l-1]==val?l-1:-1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}












