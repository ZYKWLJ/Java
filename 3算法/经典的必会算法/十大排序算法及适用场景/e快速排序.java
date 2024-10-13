package 十大排序算法及适用场景;


/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 23:28
 **/
//设置一个标记位，一般为第一个元素，核心就在于每一次递归都确定了当前标记位的位置，这个位置之前的所以元素都小于标记元素，之后的所有元素都大于标记元素，
//并将这一次的位置作为左右分区间的分界线返回！在对左右区间进行这样的操作。最后所有元素的位置都确定好了。


public class e快速排序 {
    public static void qiuckSort(int[] nums, int start, int end) {
        if (start > end) return;
        int r = partition(nums, start, end);
        qiuckSort(nums, start, r - 1);//每递归一次r就定好了一次，所以两边就去除了r(包含右边界)
        qiuckSort(nums, r + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int mark = nums[start];//以第一个为标记
        int l = start + 1;
        int r = end;
        while (l <= r) {//1  2  4  5  2  6 （求3）==>l=2,r=4
            while (l <= r && nums[l] <= mark) l++;//从左到右一直遍历到完比mark小的所有元素，直至退出
            while (l <= r && nums[r] >= mark) r--;//从右到左一直遍历到完比mark大的所有元素，直至退出
            if (l >= r) break;//前缀后缀已经全部是小于mark和大于mark的了，直接后面交换就好了
            swap.swap(l, r, nums);//交换元素，一定要确保比mark小的数全部经可能靠近左边
        }
        swap.swap(start, r, nums);

        return r;//得到了左右两边的区间分界。至此，r元素位置定下来了。
    }
}
