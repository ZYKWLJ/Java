package editor.cn;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-07 13:27
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
