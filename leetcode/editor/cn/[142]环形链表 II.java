package editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution142{
    public static void main(String[] args) {
        Solution solution = new Solution142().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null)return null;
    //    显然哈希表,哈希表有3种解法——数组、set、map
        //    这里显然是第二种，set的，因为数组不可能，map在这里没有value的意义，浪费空间。只有set最美，刚好合适这种单对象的存储判重。
        Set<ListNode> set=new HashSet<>();
        ListNode A = head;
        while (A!=null){
            if (set.contains(A))return A;
            else {
                set.add(A);
                A=A.next;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












