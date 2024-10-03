package editor.cn.doc;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-09-28 20:40
 **/
public class 孩子们的游戏圆圈中最后剩下的数一行代码 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String str = input.nextLine();
            String[] in = str.split(",");
            System.out.println("in = " + Arrays.toString(in));
            System.out.println(solve(Integer.parseInt(in[0]), Integer.parseInt(in[1])));
        }
    }

    private static int solve(int n, int m) {
        int f=0;
        for (int j = 2; j <=n; j++) {//这里的循环从2开始的原因是两个孩子才有的选，只有一个孩子直接游戏结束
            f=(f+m)%j;//分别从2——N个孩子入手，逆向思维，从每次减少一个孩子变为每次增加一个孩子，看这个孩子增加进去的位置下标。巧妙地避开了正向思维中前者会影响后者下标的这个行为，因为逆向思维中，前者已经定下来了，后者对他未影响。
            System.out.print(f+"\t");
        }
        System.out.println();
        return f;
    }
}