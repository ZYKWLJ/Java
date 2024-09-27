package com.itheima.美团.T24_1.T2;

import java.util.Arrays;

/**
 * @Author: Ethan Yankang
 * @Program: 真题
 * @Date: 2024-08-31 22:34
 **/
public class Main3 {
     public static void main(String[] args) {
        int n = 3;
        int k = 6;
        int[] positions = {1, 2, 5};

        int result = minIntervalToPlantTrees(n, k, positions);
        System.out.println(result);  // 输出: 3
    }

    public static int minIntervalToPlantTrees(int n, int k, int[] positions) {
        // 对工人位置进行排序
        Arrays.sort(positions);

        // 初始化二分查找的范围
        int low = 1;
        int high = positions[n - 1] - positions[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (canPlantTrees(mid, positions, k)) {
                high = mid;  // 尝试找更小的区间长度
            } else {
                low = mid + 1;  // 增大区间长度
            }
        }

        return low;
    }

    public static boolean canPlantTrees(int mid, int[] positions, int k) {
        int n = positions.length;
        int totalTrees = 0;
        int end = positions[0] + mid - 1;

        for (int i = 0; i < n; i++) {
            if (positions[i] > end) {
                totalTrees += mid;  // 开始一个新的区间
                end = positions[i] + mid - 1;
            }
            if (totalTrees >= k) {
                return true;  // 已经满足种树的要求
            }
        }

        return totalTrees >= k;  // 检查最终是否种够了树
    }
}
