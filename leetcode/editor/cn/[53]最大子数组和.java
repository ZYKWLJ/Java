package editor.cn;

import javax.print.attribute.standard.NumberUp;

class Solution53{
    public static void main(String[] args) {
        Solution solution = new Solution53().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //方法1：使用贪心
        //return tanixn(nums);
        //方法2：使用动归
        //return dp(nums);
        //方法3：前缀和
        return preSum(nums);

    }

        private int preSum(int[] nums) {
            //前缀和的妙处：数组的任何连续子串的和可以用两个前缀和之差来表示。

            int n= nums.length;
            int presum=0;   //当前前缀和
            int minPresum=0;//最小前缀和
            int ans=Integer.MIN_VALUE;
            //显然当前前缀和前去最小前缀和就是子串的值，维护这个最大值即可
            for (int i = 0; i < n; i++) {
                presum+=nums[i];
                ans=Math.max(presum-minPresum,ans);//最大值就等于当前前缀和与最小前缀和之差(出来的就是连续串)，与原来的ans取小。
                //肯定是先答案，再更新最小值了！
                minPresum=Math.min(presum,minPresum);
            }
            return ans;
        }


        private int dp(int[] nums) {
            int n= nums.length;
            int[] dp = new int[n+1];//dp[j]表示以当前位置为j元素结尾的连续子串的最大和，显然这不是最后的 dp[n]最大，所以要维护最大值
            dp[0]=nums[0];
            int ans=nums[0];
            for (int i = 1; i < n; i++) {
                dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
                ans=Math.max(ans,dp[i]);//此处必须维护，因为不是连续的，中间要断！！
            }
            return ans;
        }


        private int tanixn(int[] nums) {
            int n= nums.length;
            int currSubSum=0;
            int MaxSubSum=Integer.MIN_VALUE;//注意这里一定是MIN_VALUE!!
            for (int i = 0; i < n; i++) {
                currSubSum=Math.max(nums[i],currSubSum+ nums[i]);
                MaxSubSum=Math.max(MaxSubSum,currSubSum);
            }
            return MaxSubSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












