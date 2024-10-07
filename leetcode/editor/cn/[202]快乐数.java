package editor.cn;

import java.util.HashSet;

class Solution202 {
    public static void main(String[] args) {
        Solution solution = new Solution202().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            //哈希表法
            //return hash(n);

            //双指针法
            return pointer2(n);
        }

       public boolean hash(int n){

           //    对应这种有规律的数学问题不要怕。肯定是重复出现，那就是哈希问题。
           //    退出条件有两个：1/最后遇到1   2/出现重复。最后在判断是不是1就好了
           int happy = n;
           HashSet<Integer> hashSet = new HashSet<>();
           while (happy != 1 && !hashSet.contains(happy)) {
               hashSet.add(happy);//就是不等于1才能进入循环的。
               happy = getNext(happy);
           }
           return happy == 1;
       }

        //典型的环形链表。
        // 有两种可能，要么快者比慢者先到达1，要么快者在一个环中走，那么就一定会与慢者相遇，而且一定是走完了一整圈环的。
        public boolean pointer2(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);
            while (fastRunner != 1 && slowRunner != fastRunner) {
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }
            return fastRunner == 1;
        }

        private int getNext(int happy) {
            int sum = 0;
            while (happy != 0) {
                sum += (happy % 10) * (happy % 10);
                happy /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












