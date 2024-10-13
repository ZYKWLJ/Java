package 十大排序算法及适用场景;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 23:28
 **/
public class d希尔排序 {
    public static void shellSort(int[] nums) {
        for (int gap = nums.length/2; gap > 0; gap /= 2) {
            for (int j = gap; j < nums.length; j++) {
                int key = nums[j];
                int k =j-gap;
                while (k >= 0 && key < nums[k]) {
                    nums[k+gap] = nums[k];//核心动作就是抽出来，往后移动
                    k -= gap;
                }
                nums[k + gap] = key;
            }
        }
    }
}
