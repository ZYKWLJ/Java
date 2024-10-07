package editor.cn;
class Solution392{
    public static void main(String[] args) {
        Solution solution = new Solution392().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
    //  方法1：dp
    //    return dp(s,t);
    //  方法2：双指针
        return doublePointer(s,t);
    //    方法3： 内置函数（当然这一题是子序列，如果是子串就OK的，KMP或者直接库函数）
    //   return t.contains(s);
    }


        private boolean doublePointer(String s, String t) {
            int lens=s.length();
            int lent=t.length();
            //思路就是t在里面按顺序寻找
            if (lens==0)return true;
            int count=0;
            char[] charArray_t = t.toCharArray();
            for (char c : charArray_t) {
                if (c==s.charAt(count)){
                    count++;
                    if (count==lens) {
                        break;
                    }
                }

            }
            return count==lens;
        }

        private boolean dp(String s, String t) {//后面的要长！
            int lens=s.length();
            int lent=t.length();
        //    dp的精髓就是在两个线段之间不断遍历
            int[][] dp = new int[lens+1][lent+1];//dp[i][j]表示s中以下标i为结尾的子串、t中以下标j为结尾的子串(不包含)的相同子串长度为dp[i][j]
            //初始化，dp[0][0]显然等于0
            //dp[0][0]=0;
            for (int i = 1; i <= lens; i++) {
                for (int j = 1; j <= lent; j++) {
                    dp[i][j]=s.charAt(i-1)==t.charAt(j-1)?(dp[i-1][j-1]+1):dp[i][j-1];
                    //只能是最长的串删除元素，因为你看看dp的定义就知道了，定义为：最长的相同子串嘛，既然当期不能相同，那只能在之前寻求相同的可能性了。
                }
            }
            return dp[lens][lent]==lens;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}