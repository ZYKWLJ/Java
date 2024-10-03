package 代码;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-03 10:45
 **/
//这里实现的是泛型类，简介见此
public class SkipList<K extends Comparable<K>, V> {

    //静态私有内部类，定义用于存储数据的节点
    private static class Node<K extends Comparable<K>, V> {
        K key;
        V value;
        int level;
        ArrayList<Node<K, V>> forwards;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.forwards = new ArrayList<>(Collections.nCopies(level + 1, null));
            //Collections.nCopies(level + 1, null)的作用是创建一个包含level + 1个null元素的不可变列表。这个列表是针对层级的。即该节点分布在level+1个层级上。
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int value = scanner.nextInt();
        int level = scanner.nextInt();
        Node<Integer, Integer> node = new Node<>(key, value, level);
        System.out.println(node.getKey() + " " + node.getValue());
        scanner.close();

    }
}
