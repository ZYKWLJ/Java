package editor.cn;

import java.util.SimpleTimeZone;

class Solution367{
    public static void main(String[] args) {
        Solution solution = new Solution367().new Solution();
        System.out.println(solution.isPerfectSquare(16));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int l=0;
        int r=(num/2)+1;
        while (l<=r){
            int mid=l+((r-l)>>>1);
            long curr=(long) mid*mid;//唯有要注意的一点就是，这里的mid*mid前面一定要有(long)，加在curr前面不起作用，要加在这个前面
            if (num>curr)l=mid+1;
            else if (num<curr)r=mid-1;
            else return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}































