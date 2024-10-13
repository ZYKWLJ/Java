package 十大排序算法及适用场景;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 22:55
 **/
public class c插入排序 {
    public static void insertSort(int[] nums){
    //    记住流程就好了
        for (int i = 1; i < nums.length; i++) {
            int key=nums[i];
            int j=i-1;
            while (j>=0&&key<nums[j]){
                nums[j+1]=nums[j];//前面的向后移，最后key才插入合适位置
                j--;    //向前推进
            }
            nums[j+1]=key;
        }
    }
}
