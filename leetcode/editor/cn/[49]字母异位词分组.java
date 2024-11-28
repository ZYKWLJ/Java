package editor.cn;

import java.util.*;

class Solution49 {
    public static void main(String[] args) {
        Solution solution = new Solution49().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //    首先所有的单词全都有，因为一个单词就是一个字母异位词.
            //    使用hash表来解决方法的话，直接将单词从大到小排序就好，然后看是否一致，一直就加入。
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);
                if (!map.containsKey(sortedStr)) {
                    map.put(sortedStr, new ArrayList<>());//建立哈希索引的，后面会统一遍历
                }
                map.get(sortedStr).add(str);
            }
            return new ArrayList<>(map.values());
        }

        //这一点很重要，利用数组将单个的字符排序！！！
        private String sort(String str) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return Arrays.toString(charArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












