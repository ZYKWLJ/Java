package editor.cn;

import java.util.HashMap;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-14 21:15
 **/
public class testHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",0);
        map.put("2",0);
        //练习如果已经存在，就相加(就这么个简单的问题！！)
            if (map.containsKey("1")) {
                map.put("1", map.get("1") + 1);
            } else {
                map.put("1", 1);
            }
        System.out.println(map.values());

    }
}
