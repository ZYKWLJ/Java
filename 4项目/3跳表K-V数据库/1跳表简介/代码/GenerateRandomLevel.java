package 代码;

import java.util.Random;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-03 10:09
 **/
public class GenerateRandomLevel {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
                System.out.print(generateRandomLevel()+"\t");
        }
    }
    private static int generateRandomLevel() {
        int level = 1;
        Random random = new Random();
        while (random.nextInt(2) == 1) {
            level++;
        }
        return level;
    }
}
