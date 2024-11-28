package editor.cn;

import java.util.Arrays;

class Solution871{
    public static void main(String[] args) {
        Solution solution = new Solution871().new Solution();
        int[][] station = new int[][]{{10,60},{20,30},{30,60},{60,40}};
        System.out.println("station = " + Arrays.deepToString(station));
        System.out.println(solution.minRefuelStops(100,10,station));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    这个是好题呀，动归之精髓体现的淋漓尽致
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n=stations.length;
        int[] dp = new int[n+1];//dp[j]表示加j次油能走的最远距离。
        dp[0]=startFuel;//当然了。第一次就是不加油的，那么就是初识油量。
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0; j--) {
                //这里就是每进来一个加油站(体现了后面依赖前面的dp思想)，就会更新每次加油次数对应的能跑的最远距离。所以前面的全部要更新，
                // 但是条件就是本来就可以跑到这个加油站才行。这就是if条件的由来，而j在一直减少。就是更新的加入本次加油站后的全部最远距离可能情况。
                if (stations[i][0]<=dp[j]){//只有上一次的油加了能跑的距离大于或等于本次的车站距离stations[i][0]才能更新相应次数加油的最大油量。
                    dp[j+1]=Math.max(dp[j+1],dp[j]+stations[i][1]);//显然每一个都会更新相应次数加油量的最大值，所以这里会覆盖，就要本次和上一次取最值。
                }
            }
        }
        //这里显然，肯定是先遍历，最早满足最早退出。
        for (int i = 0; i <= n; i++) {
            if (dp[i]>=target)return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












