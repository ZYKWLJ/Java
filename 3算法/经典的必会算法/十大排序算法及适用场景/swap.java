package 十大排序算法及适用场景;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 21:26
 **/
public class swap {
    public static void swap(int i, int j, int[] num) {
        int temp=num[j];
        num[j]=num[i];
        num[i]=temp;
    }
}
