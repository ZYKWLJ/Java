package editor.cn;

import java.util.UnknownFormatConversionException;

class Solution35{
    public static void main(String[] args) {
        Solution solution = new Solution35().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>>1);
            if (nums[mid]>target)r=mid-1;
            else if (nums[mid]<target)l=mid+1;
            else return mid;
        }//[1,2,4] 3结合while循环的退出，一定是这样的结果：r=小于tar的第一个数的下标，l=大于tar的第一个数下标,现在就要替换这个下标嘛，所以返回l或者r+1
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












