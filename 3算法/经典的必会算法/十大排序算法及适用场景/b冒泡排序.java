package 十大排序算法及适用场景;
import static 十大排序算法及适用场景.swap.swap;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 21:15
 **/
public class b冒泡排序 {
    public static void bubble(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {//排序n-1个就好了
            boolean f=true;
            for (int j = 0; j < nums.length -1 - i; j++) {//每一次进行比较交换
                if (nums[j+1]<nums[j]){
                    f=false;
                    swap(j,j+1,nums);
                }
            }
            if (f)return;
        }
    }
}
