package editor.cn;
class Solution63{
    public static void main(String[] args) {
        Solution solution = new Solution63().new Solution();
        int[][] nums = {{0, 1, 0, 0}, {0, 0, 0, 0}};
        solution.uniquePathsWithObstacles(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        if (obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1)return 0;
        //如果是
        //0   1   0   0
        //0   0   0   0呢？
        for (int i = 1; i < m &&obstacleGrid[i][0]==0; i++) {//(这里很巧妙。如果有遇到障碍物，直接就退出循环了，后面都截止了，全是0！)
            dp[i][0]=1;
        }
        for (int j = 1; j < n &&obstacleGrid[0][j]==0; j++) {
            dp[0][j]=1;
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                dp[i][j]=(obstacleGrid[i][j]!=1)?dp[i-1][j]+dp[i][j-1]:0;
                //System.out.println("dp["+i+"]["+j+"] =" + dp[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("dp["+i+"]["+j+"] =" + dp[i][j]);
            }
        }
        return dp[m-1][n-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












