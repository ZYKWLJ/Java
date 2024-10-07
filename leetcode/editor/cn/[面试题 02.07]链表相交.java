package editor.cn;
class Solution面试题0207{
    public static void main(String[] args) {
        Solution solution = new Solution面试题0207().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA;
            ListNode B = headB;
            while (A!=B){
                A=A!=null?A.next:headB;
                B=B!=null?B.next:headA;
            }
            return B;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}












