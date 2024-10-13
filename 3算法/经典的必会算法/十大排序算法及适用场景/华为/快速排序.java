package 十大排序算法及适用场景.华为;

import java.util.Arrays;

import 十大排序算法及适用场景.swap;
import 十大排序算法及适用场景.swap.*;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-13 12:03
 **/
public class 快速排序 {
    public static void main(String[] args) {
        int[] nums=new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println("nums = " + Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start>end)return;
        int r=partition(nums,start, end);
        quickSort(nums,start,r-1);
        quickSort(nums,r+1,end);

    }

    private static int partition(int[] nums, int start, int end) {
        int mark=nums[start];
        int l=start+1;
        int r=end;
        while (l<=r){
            while (l<=r&&nums[l]<=mark)l++;
            while (l<=r&&nums[r]>=mark)r--;
            if (l>=r)break;
            swap.swap(l,r,nums);
        }
       swap.swap(start,r,nums);
        return r;
    }
}
