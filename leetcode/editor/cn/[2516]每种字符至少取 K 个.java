package editor.cn;
class Solution2516{
    public static void main(String[] args) {
        Solution solution = new Solution2516().new Solution();
        //String str="aabbcc"
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       static   int[] abc=new int[3];
    public int takeCharacters(String s, int k) {
    //    正难则反，因为从前取从后取后剩余的子串是连续的，而且至少包含k个，那么剩余子串就最多包含x-k,y-k,z-k个a，b，c了，那么转化过来
    //    就是求解最长的最多包含x-k,y-k,z-k个a，b，c个子串，显然用滑动窗口解决
    //
        char[] charArray = s.toCharArray();
        int n=s.length();

        for (char c : charArray) {
            if (c=='a'){
                abc[0]++;
            }if (c=='b'){
                abc[1]++;
            }if (c=='c'){
                abc[2]++;
            }
        }

        for (int i : abc) {
            if (i<k)return -1;
        }

        //只能是从n-k开始逐渐减小！全部要最多包含这么多个数字！
        int finalLen=0;
        boolean f=false;
        for (int len =n-3*k; len >0; len--) {
            int l=0;
            int r=len-1;
            while (r<n){
                if (AllContain_ABC(l,r,s,k)){
                    finalLen=r-l+1;
                    f=true;
                    break;
                }
                l++;
                r++;
            }
            if (f)break;
        }
        return n-finalLen;
    }

        private boolean AllContain_ABC(int l, int r, String s,int k) {
            int[] ABC = new int[3];

            for (int i = l; i < r; i++) {
                char c = s.charAt(i);
                if (c=='a'){
                    ABC[0]++;
                }if (c=='b'){
                    ABC[1]++;
                }if (c=='c'){
                    ABC[2]++;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (ABC[0]<=abc[0]-k&&ABC[1]<=abc[1]-k&&ABC[2]<=abc[2]-k){
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












