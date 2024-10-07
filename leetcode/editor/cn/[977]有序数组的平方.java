package editor.cn;
class Solution977{
    public static void main(String[] args) {
        Solution solution = new Solution977().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
    //    简单题，简单做，O(n)时空杂度是在所难免了
        int[] ans = new int[nums.length];
    //    说白了就是中间两个指针向外一起扎！！！反之，外面的指针一起往里面咋，直到l>=r
        int l=0;
        int r=nums.length-1;
        int count= nums.length-1;
        while (l<=r){
            if ((long)nums[l]*nums[l]>(long) nums[r]*nums[r]){
                ans[count--]= (int) ((long)nums[l]*nums[l]);
                l++;
            }else {
                ans[count--]= (int) ((long)nums[r]*nums[r]);
                r--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












