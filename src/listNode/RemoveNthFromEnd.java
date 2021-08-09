package listNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < len - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = dummy.next;
        return res;

    }


    public int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}