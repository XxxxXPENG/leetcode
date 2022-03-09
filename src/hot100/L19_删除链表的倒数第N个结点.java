package hot100;

import sf.ListNode.ListNode;

public class L19_删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        dummy.init(1);
        ListNode head = dummy.next;
        L19_删除链表的倒数第N个结点 a = new L19_删除链表的倒数第N个结点();
        System.out.println(a.removeNthFromEnd(head, 1));
    }

    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode quick = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 去除倒数第K个节点，计算链表长度len，移除第K个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //why ? cur = dummy ? -- 链表就1个元素，倒数第1个移除直接返回dummy
        ListNode cur = dummy;
        for (int i = 1; i < len - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
