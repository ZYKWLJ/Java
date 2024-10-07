package editor.cn;

class Solution707 {
    public static void main(String[] args) {
        MyLinkedList solution = new Solution707().new MyLinkedList();
    }
    //本题题意都还没搞懂呢！这个是操作类，链表类得在之前就定义了，这个类就是以链表类和链表长度为属性操作罢了！！核心思想还得见下面的构造函数。
    //leetcode submit region begin(Prohibit modification and deletion)
    //单链表
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }
    class MyLinkedList {
        //size存储链表元素的个数
        int size;
        //虚拟头结点
        ListNode head;

        //初始化链表
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
        public int get(int index) {
            //如果index非法，返回-1
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currentNode = head;
            //包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            //时时刻刻记住head是虚拟头结点
            newNode.next = head.next;
            head.next = newNode;
            size++;

            // 在链表最前面插入一个节点，等价于在第0个元素前添加
            // addAtIndex(0, val);
        }


        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = newNode;
            size++;

            // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
            // addAtIndex(size, val);
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到要插入节点的前驱
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            //因为有虚拟头节点，所以不用对Index=0的情况进行特殊处理
            ListNode pred = head;
            for (int i = 0; i < index ; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}












