package 零一背包;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 17:22
 **/
public class 二维01背包 {
    static int bagWeight=1;
    //    二维01背包就只有9行代码，死记住都给我记住
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1, 5, 2};
        int[] value = new int[]{2, 3, 1, 5, 4, 3};
        System.out.println("共可以装物品的价值为：" + dp(nums, value));
    }

    private static int dp(int[] nums, int[] value) {
        int[][] dp = new int[nums.length][bagWeight + 1];//dp[i][j]表示在前i个物品中选出装进容量为j的背包中，获取的最大价值。
        //初始化

        //    显然i=0时，只能装一个物品，但是前提是背包容量要大于第一个。
        for (int j = nums[0]; j <= bagWeight; j++) {
            dp[0][j] = nums[0];
        }
        //  当j=0时，背包容量为0.那么显然为0。
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <=bagWeight; j++) {
                if (nums[i] <= j) {//当前物品加
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];//让前物品不加
                }
            }
        }
        return dp[nums.length - 1][bagWeight];
    }
}
