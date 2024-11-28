package editor.cn;

class Solution459 {
    public static void main(String[] args) {
        Solution solution = new Solution459().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            //方法1：通过数学判断，相加去除首尾法
            //return doublePlus(s);

            //方法2：KMP
            return KMP(s);
        }

        //方法2：KMP
        private boolean KMP(String s) {
            //这是基于去除了原串的最长前后缀的长度后，剩下的长度的串一定是原串整除的
            if (s.length() == 0) return false;
            int[] next = new int[s.length()];
            getNext(next, s);
            int len = s.length();
            return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
        }
        //abab(最长相等前后缀为2)
        //aabaabaaf

        //aabaaf
        private void getNext(int[] next, String s) {
            int j = 0;
            next[0] = 0;
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
                if (s.charAt(j) == s.charAt(i)) j++;
                next[i] = j;
            }

        }

        //方法1：数学归纳法
        private boolean doublePlus(String s) {
            //其实这是基于数学归纳法的。你想想，如果是重复字符串，那么最少有两个重复单元，那么同理，如果已有的串相加，那么原串就成为了基本单元，那么double串去除首尾就必须包含原串。这就是数学归纳法。
            String s2 = (s + s).substring(1, (s + s).length() - 1);
            return s2.contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












