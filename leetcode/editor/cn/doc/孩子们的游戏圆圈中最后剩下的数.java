package editor.cn.doc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-09-28 19:35
 **/
public class 孩子们的游戏圆圈中最后剩下的数 {
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
        int[] hash = new int[n];
        Arrays.fill(hash,1);
        int basicIndex=0;
        for (int i = 0; i < n - 1; i++) {
        //    只需要n-1轮就可以确定了
        //    凡是选到的就设置为0
            //每一轮要在m个人头上转圈(可以重复，使用while+计数)，一共要进行n次
            int count=0;//计数本轮计数人数
            int Index=(basicIndex+count)%n;

            while (count<m){  //确保一定会计数到m次，到第m个就直接将其设置为0;
              //每一轮开始的那个人的序号
                if (hash[Index%n]!=0){
                    if (count==m-1){
                        hash[Index%n]=0;
                    }
                    count++;            //如果当前人没有选过，就选上，设置为0，选了就跳过，剩下的最后一个没有选的就是答案
                    Index++;            //同样这里也要加1
                }else{
                    Index++;           //这是跳过了之前选过的人。
                }
            }
            basicIndex=Index;//标记下一次起始位置
        }

        for (int i = 0; i < n; i++) {
            if (hash[i]!=0){
                return i;
            }
        }
        return 1;//剩下的最后一个找出来就好了！这里实际上不会走到，但是程序要求的语法不能省略
    }
}
