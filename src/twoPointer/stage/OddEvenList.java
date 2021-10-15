package twoPointer.stage;

import sf.ListNode.ListNode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            count++;
            head = head.next;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
