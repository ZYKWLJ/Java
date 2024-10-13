package 十大排序算法及适用场景;


/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 23:28
 **/

//核心点是先分割，在合并排序。将最初的数组划分成只有2个元素的最小单元，针对这个单元排序，然后在合并成4个元素的单元，在合并成8个元素的单元，最终完成排序。
//    最大的特点就是分割+合并(体现了分治思想==>java里面的fork-join框架就是借鉴的这个思想。)


public class f归并排序 {
    //分割函数

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + ((r - l) >>> 1));//又在这里吃亏了，记住有》》》一定要括起来！！

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);//(将左右排序好在合并(当然合并时也要排序)，不就是有序的了吗？)
        merge(nums, l, mid, r);
    }

    //合并数组函数
    private static void merge(int[] nums, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;//r-(mid+1)-1 = r-mid

        //    创建临时数组
        int[] l_arr = new int[n1];
        int[] r_arr = new int[n2];

        //    拷贝数据到临时数组
        System.arraycopy(nums, l, l_arr, 0, n1);
        System.arraycopy(nums, mid + 1, r_arr, 0, n2);

        //    合并临时数组
        int i = 0, j = 0;
        int k = l;//从左边开始
        while (i < n1 && j < n2) {
            if (l_arr[i] <= r_arr[j]) {
                nums[k++] = l_arr[i++];
            }else{
                nums[k++] = r_arr[j++];
            }
        }

        //    拷贝剩余数组
        while (i<n1){
            nums[k++]=l_arr[i++];
        }
        while (j<n2){
            nums[k++]=r_arr[j++];
        }
    }
}
