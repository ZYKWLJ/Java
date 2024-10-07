package editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

class Solution344{
    public static void main(String[] args) {
        Solution solution = new Solution344().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while (l<r){
            s[l]^=s[r];
            s[r]^=s[l];
            s[l]^=s[r];
            l++;r--;
        }
        System.out.println(Arrays.toString(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












