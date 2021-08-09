package listNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            //头结点指向尾部
            head.next = pre;
            //让原始的头变为前驱
            pre = head;
            //改变下一个节点
            head = next;
        }
        return pre;
    }
}
