import java.util.Map;
import java.util.Random;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-03 11:39
 **/
public class GenerateRandomLevel {
    private static int Max_level=10;
    private static int generateRandomLevel(){
        int level=1;
        Random random = new Random();
        while (random.nextInt(2)==1){
            level++;
        }
        return Math.min(level,Max_level);
    }
    //测试层级生成
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(generateRandomLevel()+"\t");
            if ((i+1)%10==0){
                System.out.println();
            }
        }
    }
}
