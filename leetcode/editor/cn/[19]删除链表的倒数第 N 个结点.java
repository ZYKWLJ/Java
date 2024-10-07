package editor.cn;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;

class Solution19{
    public static void main(String[] args) {
        Solution solution = new Solution19().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //3种解法，由易到难
        if (head == null || n <= 0) return head;
        ListNode leftNode = head;
        ListNode rightNode = head;

        // 让 rightNode 先走 n 步
        for (int i = 0; i < n; i++) {
            if (rightNode == null) return head; // 如果 n 大于链表长度，直接返回原链表(这一步很重要)
            rightNode = rightNode.next;
        }

        // 处理删除头节点的情况
        if (rightNode == null) return head.next;//这是神来之笔，说明了left就是头结点，就是要删除的节点。

        // 同时移动 leftNode 和 rightNode，直到 rightNode 到达链表末尾
        while (rightNode.next!= null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }

        // 删除倒数第 n 个节点
        leftNode.next = leftNode.next.next;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












