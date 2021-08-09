package listNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left - 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        
        reverseListNode(leftNode);

        pre.next = leftNode;
        leftNode.next = cur;
        return dummy.next;
    }

    private void reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

    }
}
