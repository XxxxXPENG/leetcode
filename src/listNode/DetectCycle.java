package listNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast= fast.next;
        }
        return fast;
    }

}
