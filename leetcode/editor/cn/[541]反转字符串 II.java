package editor.cn;



class Solution541{
    public static void main(String[] args) {
        Solution solution = new Solution541().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int n = s.length();
            char[] arr = s.toCharArray();
            for (int i = 0; i < n; i += 2 * k) {
                reverse(arr, i, Math.min(i + k, n) - 1);//这就是算法的优美！！！
            }
            return new String(arr);
        }

        public void reverse(char[] arr, int left, int right) {
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}












