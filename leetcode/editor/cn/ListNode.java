package editor.cn;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-01 12:02
 **/
public class ListNode {
//    值
    int val;
    //下一个指向
    ListNode next;

    public ListNode(int val) {
        this.val=val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
