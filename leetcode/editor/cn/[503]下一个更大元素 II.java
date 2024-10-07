package editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

class Solution503{
    public static void main(String[] args) {
        Solution solution = new Solution503().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
    //    首先明确方向，显然是单调栈，那就四行代码，两个循环呗，开干
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        LinkedList<Integer> integersStack = new LinkedList<>();
        for (int i = 0; i < 2*nums.length-1; i++) {//最多两圈-1全部over！最后的最大值，就直接赋值为-1了呗，最后留出来的一个一定是最大值！！直接全部初始化为-1，万事大吉！！
            while (!integersStack.isEmpty()&&nums[integersStack.peek()]<nums[i%nums.length]){
                res[integersStack.pop()]=nums[ i% nums.length];
            }
                integersStack.push(i%nums.length);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












