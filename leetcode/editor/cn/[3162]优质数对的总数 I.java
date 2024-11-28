package editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution3162 {
    public static void main(String[] args) {
        Solution solution = new Solution3162().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            //  方法一：显然测试长度为50，暴力肯定能过
            //return forfor(nums1, nums2, k);

            //   方法二：枚举因子法(哈希表)(虽说方法一也是哈希表的一种，但是体现的确实暴力的思想)
            return hash(nums1, nums2, k);
        }

        private int hash(int[] nums1, int[] nums2, int k) {
            //例子讲解：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
            //nums2乘以k之后，nums2 = [6,12]
            //那么nums1中每个因子为{{1},{1,2},{1,2,4},{1,2,3,4,6,12}}；
            //显然在nums2中出现的只有6、12

            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums1) {
                if (x % k != 0) {//先确保是因子，后面在确保所有的因子加入
                    continue;
                }
                x /= k;

                for (int d = 1; d * d <= x; d++) { // 枚举因子,只需要枚举到根号x就好。
                    if (x % d > 0) {
                        continue;
                    }
                    cnt.merge(d, 1, Integer::sum); // cnt[d通过线程池]++(每枚举一个元素，相同的因子就累加呗！)

                    if (d * d < x) {//小陷阱，防止重复统计，因为2*2=4的话，2会统计两次！
                        cnt.merge(x / d, 1, Integer::sum); // cnt[x/d通过线程池]++
                    }
                }
            }

            int ans = 0;
            for (int x : nums2) {//再在这里寻找出现的因子数量，即为答案！(这种写法也很好！！)
                ans += cnt.getOrDefault(x, 0);
            }
            return ans;

        }

        //暴力法
        private int forfor(int[] nums1, int[] nums2, int k) {
            int count=0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] % (k * nums2[j]) == 0) {
                       count++;
                    }
                }
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












