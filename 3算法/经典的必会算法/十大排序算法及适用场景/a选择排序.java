package 十大排序算法及适用场景;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 23:20
 **/
public class a选择排序 {
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min=nums[i];
            for (int j = i; j < nums.length; j++) {
                if (min>nums[j])swap.swap(i,j,nums);
            }
        }
    }
}
