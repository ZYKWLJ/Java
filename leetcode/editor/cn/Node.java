package editor.cn;

import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-09 09:52
 **/
public // Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
