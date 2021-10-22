package listNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = endOfHalf(head);
        ListNode reverse = reverse(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = reverse;
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }

        firstHalfEnd.next = reverse(reverse);
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode endOfHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
