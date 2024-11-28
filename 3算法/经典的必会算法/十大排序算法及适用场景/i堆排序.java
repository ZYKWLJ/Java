package 十大排序算法及适用场景;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-12 23:28
 **/
//核心点：
//        1.把无序数组构建成二叉堆。
//        2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。

public class i堆排序 {
    public static void heapSort(int[] arr){
        int n = arr.length;
        // 构建大顶堆()
        for (int i = n / 2 - 1; i >= 0; i--) {//从最后一个非叶子结点开始往上构建的！(也很自然嘛)[第一个叶子结点的索引一定是n/2][因为公式2^n-1]
            heapify(arr, n, i);
        }
        // 逐个提取堆顶元素至末尾并调整堆
        for (int i = n - 1; i > 0; i--) {
            swap.swap(0,i,arr);// 交换堆顶和当前未排序部分的最后一个元素[所以这里会i--](对，已经排序了就定下来了！！)
            heapify(arr, i, 0);// 对剩余未排序部分调整堆(这里为什么是0，因为刚之前索引0处是最大的，后面交换了，就不是了，但是其他的都OK的，所以要交换这里)
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;//最后一个非叶子结点下标
        int left = 2 * i + 1;//左节点
        int right = 2 * i + 2;//右节点

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest!= i) {
            swap.swap(i,largest,arr);//至此，母节点就是最大的值了
            heapify(arr, n, largest);// 递归调整子树(这一步有点懵，那还有什么子树)【就是在中间的节点调整后可能会对下面的节点造成影响！】
        }
    }
}

// 1
//2 3
//||
//\/
// 3
//2 1
