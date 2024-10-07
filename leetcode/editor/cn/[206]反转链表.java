package editor.cn;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.nimbus.State;
import java.util.LinkedList;
import java.util.Stack;

class Solution206{
    public static void main(String[] args) {
        Solution solution = new Solution206().new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        listNode1.next.next.next.next=new ListNode(5);
        solution.reverseList(listNode1);
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
    public ListNode reverseList(ListNode head) {
        //return Iteration1(head);//迭代-临时变量
        return Iteration2(head);//迭代-栈化(BFS)
        //return dfs(head);//递归
    }

    private ListNode Iteration1(ListNode head) {
        //核心思想就是留 3 反转 1 2，不断迭代。这是最美的实现了，4行代码
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode node = cur.next;//必须提前保留，因为后面就找不到了
            cur.next = pre;
            pre = cur;//pre没有指向，本来也不需要要指向，因为反转后2 1的1后面本来就是空！
            cur = node;//可以保留起来之前的next
        }
        return pre;
    }

    private ListNode Iteration2(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!= null) {//先将全部入栈
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();//不断出栈+拼接
            current = current.next;
        }
        current.next = null;//最后封尾
        return newHead;
    }

    private ListNode dfs(ListNode head) {

        if (head == null || head.next == null) {    //只有一个几点也没有什么好翻转的
            return head;
        }
        ListNode newHead = reverseList(head.next);  //newHead是除了第一个节点外翻转后的链表，比如1 2 3 4 5，这就是 5 4 3 2
        (head.next).next = head;    //这里加了括号你就明白了，head.next是将除了第一个节点的剩余节点翻转后的链表看成一个整体，将他的后继节点指向头结点。
        head.next = null;   //头结点指向null完成翻转！！
        return newHead; //返回新的头结点
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












