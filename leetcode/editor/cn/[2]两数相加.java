package editor.cn;

class Solution2 {
    public static void main(String[] args) {
        Solution solution = new Solution2().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        static int jinwei=0;
        //static int sum=0;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //    迭代法
            //return Iter(l1, l2);
            //    递归法
            int carry=0;
            return dfs(l1,l2,carry);
        }

        // l1 和 l2 为当前遍历的节点，carry 为进位
        private ListNode dfs(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null) { // 递归边界：l1 和 l2 都是空节点
                return carry != 0 ? new ListNode(carry) : null; // 如果进位了，就额外创建一个节点
            }
            if (l1 == null) { // 如果 l1 是空的，那么此时 l2 一定不是空节点
                l1 = l2;
                l2 = null; // 交换 l1 与 l2，保证 l1 非空，从而简化代码
            }
            int sum = carry + l1.val + (l2 != null ? l2.val : 0); // 节点值和进位加在一起
            l1.val = sum % 10; // 每个节点保存一个数位
            l1.next = dfs(l1.next, (l2 != null ? l2.next : null), sum / 10); // 进位
            return l1;
        }


        //迭代法
        private ListNode Iter(ListNode l1, ListNode l2) {
            int jinwei = 0;
            ListNode res = new ListNode(); // 初始化结果链表的头节点
            ListNode tempNode = res;
            while (l1 != null || l2 != null) {
                int tempSum = 0;
                if (l1 != null) {
                    tempSum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    tempSum += l2.val;
                    l2 = l2.next;
                }
                tempSum += jinwei;
                if (tempSum >= 10) {
                    tempNode.val = tempSum % 10;
                    jinwei = 1;
                } else {
                    tempNode.val = tempSum;
                    jinwei = 0;
                }
                // 如果l1或l2还有下一个节点，或者进位为1，则需要创建新的节点
                if (l1 != null || l2 != null || jinwei == 1) {
                    tempNode.next = new ListNode();
                    tempNode = tempNode.next;
                }
            }
            // 如果最后还有进位，需要创建一个新的节点(很严谨)
            if (jinwei == 1) {
                tempNode.val = 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












