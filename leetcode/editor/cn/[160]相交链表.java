package editor.cn;

import java.util.HashMap;
import java.util.Map;

class Solution160{
    public static void main(String[] args) {
        Solution solution = new Solution160().new Solution();
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
        //两种解法：哈希表、双指针
        //哈希表
        return hash(headA,headB);

        //双指针
        //return pointer2(headA,headB);

    }

    //双指针法
    //利用A+B=B+A，如果存在公共部分，A+B的值也就是走过的路径会更小，如果没有相交，那么就会走得到头
    private ListNode pointer2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return B;
    }


    //哈希表法
    private ListNode hash(ListNode headA, ListNode headB) {
        Map<ListNode,ListNode> map=new HashMap<>();
        //先将链表A的全部加入
        ListNode A = headA;
        while (A!=null){
            map.put(A,headA);
            A= A.next;
        }

        ListNode B = headB;
        while (B!=null){
            if (map.containsKey(B))return B;
            else B=B.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












