package editor.cn;

import java.util.Arrays;
import java.util.EnumMap;

class Solution704{
    public static void main(String[] args) {
        Solution solution = new Solution704().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
    //    显然排序后的，那么直接二分，二分分两种，一种内置的二分法，还有就自己写呗！！
    //
    //    原理是，找得到，就输出下标，找不到就输出按序的插入位置+1后的负数(可以查看源码)。这是Java里面的集合内置的二分查找，还是很有必要掌握的！很多时候直接用。

        //方法1：内置二分
        // return  Arrays.binarySearch(nums,0,nums.length,target)>=0?Arrays.binarySearch(nums,0,nums.length,target):-1;

        //方法2：自己写的
         return binarySearch(nums,target);

    }

        private static int binarySearch(int[] nums, int target) {
            int l=0;
            int r=nums.length-1;
            while (l<=r){//为什么这里加上`=`就一定要+1、-1呢？因为取得到
                int mid=l+((r-l)>>>1);//切记这里一定是要括起来不然就要栽跟头，因为位运算是最小的
                if (nums[mid]>target){
                    r=mid-1;
                }else if (nums[mid]<target){
                    l=mid+1;
                }else return mid;

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



//在 Java 中，>>和>>>都是位运算符，用于对整数类型进行位移操作。
//        >>（有符号右移）：
//对于正数，右移时高位补 0；对于负数，右移时高位补 1。
//例如，对于整数8（二进制为00001000），8 >> 1的结果是4（二进制为00000100）。而对于整数-8（二进制为11111000），-8 >> 1的结果是-4（二进制为11111100）。
//        >>>（无符号右移）：
//无论操作数是正数还是负数，右移时高位始终补 0。
//例如，对于整数-8（二进制为11111000），-8 >>> 1的结果是2147483644（二进制为01111100）。
//总的来说，>>在右移时会根据操作数的符号来决定高位补 0 还是补 1，而>>>在右移时高位始终补 0，不考虑操作数的符号。








