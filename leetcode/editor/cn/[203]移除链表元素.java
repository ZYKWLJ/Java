package editor.cn;

class Solution203{
    public static void main(String[] args) {
        Solution solution = new Solution203().new Solution();
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
    public ListNode removeElements(ListNode head, int val) {
        //传统迭代也很妙
        //return Iteration(head, val);

        //递归很妙，核心在于递归返回值一定要接收
        return dfs(head,val);
    }

    private ListNode dfs(ListNode head, int val) {//函数的作用就是直接跳过等于val的节点。妙呀
        if (head==null)return null;//
        head.next= dfs(head.next,val);//注意这里的递归返回值是node，随意就是一定要用node来接收，不然指定错！
        return head.val==val?head.next:head;
    }



    private ListNode Iteration(ListNode head, int val) {
        ListNode dummy = new ListNode(val);
        dummy.next= head;
        ListNode node=dummy;
        while (node.next!=null){//保证这不是最后的元素就行了
            if (node.next.val== val){
            //    跳过next指向nextnext了
                node.next=node.next.next;//这里是跳过且后移
            }else{
                node=node.next;//后移指向
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}












