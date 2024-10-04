/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-04 09:51
 **/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SkipList7<K extends Comparable<K>, V> {
    /**
     * Node 类，用于实际存储数据
     * @param <K>
     * @param <V>
     */
    private static class Node<K extends Comparable<K>, V> {
        K key;    // 存储的 key
        V value;  // 存储的 value
        int level;  // 节点所在的层级
        ArrayList<Node<K, V>> forwards;

        Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.forwards = new ArrayList<>(Collections.nCopies(level + 1, null));
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
    /**
     * 跳表的最大高度
     */
    private static final int MAX_LEVEL = 32;  // 跳表的最大高度
    /**
     * 跳表的头节点
     */
    private Node<K, V> header;  // 头节点
    /**
     * 跳表中的节点数量
     */
    private int nodeCount;
    /**
     * 跳表当前的层级
     */
    private int skipListLevel;

    /**
     * 跳表构造方法
     */
    SkipList7() {
        this.header = new Node<>(null, null, MAX_LEVEL);
        this.nodeCount = 0;
        this.skipListLevel = 0;
    }

    /**
     * 创建 Node 方法
     *
     * @param key 存入的键
     * @param value 存入的值
     * @param level 该节点所在的层级
     * @return 返回创建后的该节点
     */
    private Node<K, V> createNode(K key, V value, int level) {
        return new Node<>(key, value, level);
    }

    /**
     * 生成 Node 所在层级方法
     * @return 返回节点层级
     */
    private static int generateRandomLevel() {  // 生成随机层级方法
        int level = 1;
        Random random = new Random();
        while (random.nextInt(2) == 1) {
            level++;
        }
        return Math.min(level, MAX_LEVEL);
    }

    /**
     * @return 返回跳表中节点的数量
     */
    public int size() {
        return this.nodeCount;
    }

    /**
     * 向跳表中插入一个键值对，如果跳表中已经存在相同 key 的节点，则更新这个节点的 value
     * @param key 插入的 Node 的键
     * @param value 插入的 Node 的值
     * @return 返回插入结果，插入成功返回 true，插入失败返回 false
     */
    public synchronized boolean insertNode(K key, V value) {
        Node<K, V> current = this.header;
        ArrayList<Node<K, V>> update = new ArrayList<>(Collections.nCopies(MAX_LEVEL + 1, null));

        for (int i = this.skipListLevel; i >= 0; i--) {
            while (current.forwards.get(i) != null && current.forwards.get(i).getKey().compareTo(key) < 0) {
                current = current.forwards.get(i);
            }
            update.set(i, current);
        }

        current = current.forwards.get(0);

        if (current != null && current.getKey().compareTo(key) == 0) { // 如果 key 已经存在
            // 更新 key 对应的 value
            current.setValue(value);
            return true;
        }

        // 生成节点随机层数
        int randomLevel = generateRandomLevel();

        if (current == null || current.getKey().compareTo(key) != 0) {

            if (randomLevel > skipListLevel) {
                for (int i = skipListLevel + 1; i < randomLevel + 1; i++) {
                    update.set(i, header);
                }
                skipListLevel = randomLevel;  // 更新跳表的当前高度
            }

            Node<K, V> insertNode = createNode(key, value, randomLevel);

            // 修改跳表中的指针指向
            for (int i = 0; i <= randomLevel; i++) {
                insertNode.forwards.set(i, update.get(i).forwards.get(i));
                update.get(i).forwards.set(i, insertNode);
            }
            nodeCount++;
            return true;
        }
        return false;
    }

    /**
     * 搜索跳表中是否存在键为 key 的键值对
     * @param key 键
     * @return 跳表中存在键为 key 的键值对返回 true，不存在返回 false
     */
    public boolean searchNode(K key) {
        Node<K, V> current = this.header;

        for (int i = this.skipListLevel; i >= 0; i--) {
            while (current.forwards.get(i) != null && current.forwards.get(i).getKey().compareTo(key) < 0) {
                current = current.forwards.get(i);
            }
        }

        current = current.forwards.get(0);
        return current != null && current.getKey().compareTo(key) == 0;
    }

    public synchronized boolean deleteNode(K key) {
        Node<K, V> current = this.header;
        ArrayList<Node<K, V>> update = new ArrayList<>(Collections.nCopies(MAX_LEVEL + 1, null));

        for (int i = this.skipListLevel; i >= 0; i--) {
            while (current.forwards.get(i) != null && current.forwards.get(i).getKey().compareTo(key) < 0) {
                current = current.forwards.get(i);
            }
            update.set(i, current);
        }

        current = current.forwards.get(0);

        // 搜索到 key
        if (current != null && current.getKey().compareTo(key) == 0) {
            for (int i = 0; i < this.skipListLevel; i++) {

                if (update.get(i).forwards.get(i) != current) break;

                update.get(i).forwards.set(i, current.forwards.get(i));
            }
        }

        while (this.skipListLevel > 0 && this.header.forwards.get(this.skipListLevel) == null) {
            this.skipListLevel--;
        }

        this.nodeCount--;
        return true;
    }

    public void displaySkipList() {
        // 从最上层开始向下遍历所有层
        for (int i = this.skipListLevel; i >= 0; i--) {
            Node<K, V> node = this.header.forwards.get(i);
            //Node<K, V> node = this.header;
            System.out.print("Level " + i + ": ");
            // 遍历当前层的所有节点
            while (node != null) {
                // 打印当前节点的键和值，键值对之间用":"分隔
                System.out.print(node.getKey() + ":" + node.getValue() + "——>");
                // 移动到当前层的下一个节点
                node = node.forwards.get(i);
            }
            System.out.print("null");
            // 当前层遍历结束，换行
            System.out.println();
        }
    }

    public void dumpFile() {
        // 使用 try-with-resources 语句自动管理 BufferedWriter 资源
        // 确保在操作完成后自动关闭资源，防止资源泄露
        // BufferedWriter 包装了一个 FileWriter，用于向 STORE_FILE 文件写入数据
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\1code\\Java\\Java\\4项目\\3跳表K-V数据库\\7生成和读取持久化文件\\data.txt"))) {
            // 获取跳表的头节点的下一个节点
            Node<K, V> node = this.header.forwards.get(0);

            // 遍历跳表中的每个节点直到链表末尾（即 node 为 null）
            while (node != null) {
                // 格式化节点数据为 "键:值;" 的形式
                String data = node.getKey() + ":" + node.getValue() + ";";

                // 将格式化后的数据写入到文件中
                bufferedWriter.write(data);
                // 在每条记录后面添加一个新行，确保每个节点的数据占用一行
                bufferedWriter.newLine();

                // 移动到链表中的下一个节点
                node = node.forwards.get(0);//(这里是全部移入，那就只要第0层就好)
            }
            // 捕获并处理可能发生的 IOException 异常
        } catch (IOException e) {
            throw new RuntimeException("Failed to dump file", e);
        }
    }

    private boolean isValidString(String data) {
        // 检查是否是空字符串
        if (data == null || data.isEmpty()) {
            return false;
        }
        // 检查是否包含分号
        if (!data.contains(":")) {
            return false;
        }
        return true;
    }

    private Node<K, V> getKeyValueFromString(String data) {
        if (!isValidString(data)) return null;
        String substring = data.substring(0, data.indexOf(":"));//该字符在串中第一次出现的地方
        K key = (K) substring;
        String substring1 = data.substring(data.indexOf(":") + 1, data.length() - 1);
        V value = (V) substring1;
        return new Node<K, V>(key, value, 1);
    }

    public void loadFile() {
        // 使用 try-with-resources 语句自动管理 BufferedReader 资源，
        // 确保在操作完成后自动关闭资源，防止资源泄露。
        // BufferedReader 包装了一个 FileReader，用于从 STORE_FILE 文件中读取数据。
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\1code\\Java\\Java\\4项目\\3跳表K-V数据库\\7生成和读取持久化文件\\data.txt"))) {
            String data;
            // 循环读取文件中的每一行，直到文件末尾（readLine() 返回 null）。
            while ((data = bufferedReader.readLine()) != null) {
                // 将读取的字符串转换成 Node 对象。
                Node<K, V> node = getKeyValueFromString(data);

                // 如果从字符串中成功解析出 Node 对象，则将该节点插入到数据结构中。
                if (node != null) {
                    insertNode(node.getKey(), node.getValue());
                }
            }
            // 捕获并处理可能发生的所有异常。
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        SkipList7<Integer, Integer> skiplist = new SkipList7<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Random randomValue = new Random(N);
        int[] keys = new int[N];
        for (int i = 0; i < N; i++) {
            keys[i]=i;
        }
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i]=randomValue.nextInt(N*100);
        }
        for (int i = 0; i < N; i++) {
            int key=keys[i];
            int value =values[i];
            if (skiplist.insertNode(key, value)) {
                System.out.println("Insert Success");
            } else {
                System.out.println("Insert Failed");
            }
        }
        System.out.println("====================");
        System.out.println("成功写入文件：");
        skiplist.dumpFile();
        //System.out.println("====================");
        //System.out.println("成功加载文件：");
        //skiplist.loadFile();
        System.out.println("====================");
        System.out.println("跳表的展示:");
        skiplist.displaySkipList();
        scanner.close();

    }
}