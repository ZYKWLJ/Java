package editor.cn;
class Solution746{
    public static void main(String[] args) {
        Solution solution = new Solution746().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
    //显然动态规划。dp[i]表示爬到第i阶楼梯需要的费用。显然dp[i]=max(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        int[] dp = new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i < cost.length + 1; i++) {//注意这里是要登顶，所以是cost.length+1;
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












