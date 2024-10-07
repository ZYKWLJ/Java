package editor.cn;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.LinkedList;

class Solution151{
    public static void main(String[] args) {
        Solution solution = new Solution151().new Solution();
        String string = new String("  the sky is blue   ");
        String string1 = new String("    ");
        System.out.println("string1.length()="+ string1.length());
        System.out.println("string = " + Arrays.toString(string.toCharArray()));
        System.out.println("string = " + Arrays.toString(solution.reverseWords(string).toCharArray()));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {
            //    双指针
            //return pointer2(s);

            //   栈(天然翻转的功效)
            return stack(s);
        }

        //栈化
        private String stack(String s) {
            LinkedList<String> stack = new LinkedList<>();
            s = s.trim();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {//这里先将单个单词拼接好在进行下一步
                    temp.append(s.charAt(i));
                    continue;
                }
                if (s.charAt(i) == ' ' && temp.length() > 0) {//将上一步拼接而来的单词入栈(这里的第二个条件就将连续的空格直接去除了，很妙的)
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            }
            if (temp.length() > 0) {//针对的是最后一个单词，因为他后面没有" "了
                stack.push(temp.toString());
            }
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
                if (!stack.isEmpty()) {
                    ans.append(" ");
                }
            }
            return ans.toString();
        }


        //双指针
        private String pointer2(String s) {
            // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
            // 1.去除首尾以及中间多余空格
            StringBuilder sb = removeSpace(s);//这里的一部很重要，直接去除所有的空格了
            // 2.反转整个字符串
            reverseString(sb, 0, sb.length() - 1);
            // 3.反转各个单词
            reverseEachWord(sb);
            return sb.toString();
        }

        private StringBuilder removeSpace(String s) {
            // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
            int start = 0;
            int end = s.length() - 1;
            while (s.charAt(start) == ' ') start++;
            while (s.charAt(end) == ' ') end--;
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                char c = s.charAt(start);
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {//时隔多年还是为之震惊！逻辑之严密！
                    sb.append(c);
                }
                start++;
            }
            // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
            return sb;
        }

        /**
         * 反转字符串指定区间[start, end]的字符
         */
        public void reverseString(StringBuilder sb, int start, int end) {
            // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
            // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
        }

        private void reverseEachWord(StringBuilder sb) {
            int start = 0;
            int end = 1;
            int n = sb.length();
            while (start < n) {
                while (end < n && sb.charAt(end) != ' ') {//这一步直呼牛逼，只有当遇到' '才往下走
                    end++;
                }
                reverseString(sb, start, end - 1);
                start = end + 1;
                end = start + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












