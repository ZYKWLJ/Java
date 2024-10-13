package 零一背包;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 20:42
 **/
public class 一维01背包 {
    static int bagWeight=1;
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1, 5, 2};
        int[] value = new int[]{2, 3, 1, 5, 4, 3};
        System.out.println("共可以装物品的价值为：" + dp(nums, value));
    }
    //01背包核心代码就3行
    private static int dp(int[] nums, int[] value) {
        int[] dp = new int[bagWeight+1];//dp[j]表示容量为j的背包可以装的最大价值
        dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j>=nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+value[i]);
            }
        }
        return dp[bagWeight];
    }
}
