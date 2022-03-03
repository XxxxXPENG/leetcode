package hot100;

import sf.ListNode.ListNode;

public class L2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int a = 0, b = 0, carry = 0;
        while (cur1 != null || cur2 != null) {
            if (cur2 == null) {
                a = cur1.val;
                b = 0;
                cur1 = cur1.next;
            } else if (cur1 == null) {
                a = 0;
                b = cur2.val;
                cur2 = cur2.next;
            } else {
                a = cur1.val;
                b = cur2.val;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            temp.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            temp = temp.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(1);
        }
        return res.next;
    }
}
