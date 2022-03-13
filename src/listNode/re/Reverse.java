package listNode.re;

import sf.ListNode.ListNode;

public class Reverse {
    public static void main(String[] args) {

        Reverse r = new Reverse();
        System.out.println(r.headReverse(ListNode.init(new int[]{1,2,3,4})));
    }


    ListNode reverse(ListNode head) {
        ListNode next = null, pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    ListNode headReverse(ListNode head) {
        ListNode tail = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = tail.next;
            tail.next = head;
            head = next;
        }
        return tail.next;
    }

}
