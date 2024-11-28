package editor.cn;
class Solution70{
    public static void main(String[] args) {
        Solution solution = new Solution70().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n<2)return n;
    //    显然动态规划。dp[i]表示爬到第i阶楼梯的方法数量。显然dp[i]=dp[i-1]+dp[i-2];
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i < n + 1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












