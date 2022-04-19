package hot100;

import sf.ListNode.ListNode;

public class L142_环形链表II {

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head,slow = head;
        while (true){
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
