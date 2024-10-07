package editor.cn;
class Solution24{
    public static void main(String[] args) {
        Solution solution = new Solution24().new Solution();
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
 */
class Solution {
    public ListNode swapPairs(ListNode head) {//显然递归即可。本函数表示后面的都是翻转好的链表
        if (head==null)return null;
        if (head.next==null)return head;
        ListNode newHead = head.next;
        head.next=swapPairs(head.next.next);
        newHead.next=head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












