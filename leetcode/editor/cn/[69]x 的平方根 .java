package editor.cn;

import java.util.IdentityHashMap;

class Solution69{
    public static void main(String[] args) {
        Solution solution = new Solution69().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        //记住一定，二分就可以做到不断趋近给定的值，最终一定是在两个整数之间，或者直接相等。所有就能做到这个。
        int l=0;
        int r=(x/2)+1; //这里也可以用int r=x;但是没必要因为均值不等式
        while (l<=r){
            int mid=l+((r-l)>>>1);
            if ((long)mid*mid>x)r=mid-1;//注意这里一定要加(long)不然会寄
            else if (mid*mid<x)l=mid+1;
            else return mid;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












