package editor.cn;
class Solution115{
    public static void main(String[] args) {
        Solution solution = new Solution115().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
    //    显然用dp
        int lens=s.length();
        int lent=t.length();
        int[][] dp = new int[lens+1][lent+1];//dp[i][j]表示以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j](注意不是子串的字母数字)。
        //初始化很讲究的
        //由地推公司，可以看出，dp[i][j]依赖于上方、左上方的元素，所以这里的dp[0][j]\dp[i][0]均要初始化(其实很简单，因为这里的递推公式全部是dp[][])
        //dp[0][j]表示在空字符串s中，s删除任何元素都不能得到j-1结尾的串t，所以为0
        //dp[i][0]表示在以i-1结尾的字符串中，删除元素出现空字符串的个数，显然为1(全部删除)
        //dp[0][0]表示为1，显然
        for (int i = 0; i < lens; i++) {
            dp[i][0]=1;
        }

        for (int j = 1; j < lent; j++) {
            dp[0][j]=0;
        }

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                //dp[i][j]=s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]+dp[i][j-1]:dp[i][j-1];
                dp[i][j]=s.charAt(i-1)==t.charAt(j-1)?dp[i-1][j-1]+dp[i-1][j]:dp[i-1][j];//这里是为了和前面匹配，s中可能前面还有匹配的！！！所以j不删，i删除一个，在前面进行匹配
            }
        }
        return dp[lens][lent];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












