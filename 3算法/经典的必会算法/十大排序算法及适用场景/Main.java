package 十大排序算法及适用场景;

import java.util.Arrays;


/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 21:16
 **/
public class Main {

    private static void Sort(int[] nums, String sortType, SortFunction sortFunction) {
        System.out.println(sortType + ":");
        int[] cloneArr = nums.clone();
        sortFunction.sort(cloneArr);
        System.out.println("排序后:" + Arrays.toString(cloneArr) + "\n");
    }

    private static void SortPartition(int[] nums, String sortType, SortFunctionPartition sortFunction) {
        System.out.println(sortType + ":");
        int[] cloneArr = nums.clone();
        sortFunction.sortPartition(cloneArr, 0, cloneArr.length - 1);
        System.out.println("排序后:" + Arrays.toString(cloneArr) + "\n");
    }

    public interface SortFunction {
        void sort(int[] nums);
    }

    public interface SortFunctionPartition {
        void sortPartition(int[] nums, int l, int r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.err.println("nums = " + Arrays.toString(nums));
        Sort(nums, "a选择排序", a选择排序::selectSort);//传递函数指针(函数式接口)
        Sort(nums, "b冒泡排序", b冒泡排序::bubble);
        Sort(nums, "c插入排序", c插入排序::insertSort);
        Sort(nums, "d希尔排序", d希尔排序::shellSort);
        SortPartition(nums, "e快速排序", e快速排序::qiuckSort);
        SortPartition(nums, "f归并排序", f归并排序::mergeSort);
        Sort(nums, "i堆排序", i堆排序::heapSort);
    }
}
