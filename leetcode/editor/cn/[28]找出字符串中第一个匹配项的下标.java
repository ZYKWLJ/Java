package editor.cn;

import java.util.Arrays;

class Solution28 {
    public static void main(String[] args) {
        Solution solution = new Solution28().new Solution();
        String str = "aabaafaa";
        int[] next = new int[str.length()];
        solution.getNext(next, str);
        System.out.println("str = " + Arrays.toString(str.toCharArray()));
        System.out.println("next = " + Arrays.toString(next));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //KMP 算法就二个点：
        //next数组——最长公共前后缀，用于记录下一次匹配模式串失败后的跳转至模式串的前面特点的位置，从这重新开始匹配。
        //主程序与求解next数组的算法基本一致。都是4行代码两个循环，很美。
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return -1;
            int len=needle.length();
            int[] next = new int[len];
            getNext(next,needle);
            int j=0;
            for (int i = 0; i <haystack.length() ; i++) {//注意这里是从0开始的，显然的
                while (j>0&&needle.charAt(j)!=haystack.charAt(i))j=next[j-1];
                if (needle.charAt(j)==haystack.charAt(i))j++;
                if (j==needle.length())return i+1-needle.length();
            }
            return -1;

        }

        private void getNext(int[] next, String needle) {
            int j=0;
            next[0]=0;
            for (int i = 1; i < next.length; i++) {//注意这里是从1开始的，因为从0开始没有任何意义。前后缀吗，不包含首尾字符。
                while (j>0&&needle.charAt(j)!=needle.charAt(i))j=next[j-1];
                if (needle.charAt(j)==needle.charAt(i))j++;
                next[i]=j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//a a b a a f











