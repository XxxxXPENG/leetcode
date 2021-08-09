package listNode;

public class AddTwoNumbers {
    public static void main(String[] args) {


        ListNode l1 = ListNode.createListNode(new int[]{9, 9, 9, 9});
        ListNode l2 = ListNode.createListNode(new int[]{9, 9, 9, 9, 9, 9, 9});


        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0;
        ListNode tempRes = res;
        int a = 0, b = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                a = cur2.val;
                b = 0;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                b = cur1.val;
                a = 0;
                cur1 = cur1.next;
            } else {
                a = cur1.val;
                b = cur2.val;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            tempRes.next = new ListNode((a + b + carry) % 10);
            carry = carry + a + b >= 10 ? 1 : 0;
            tempRes = tempRes.next;

        }
        if (carry != 0) {
            tempRes.next = new ListNode(1);
        }
        return res.next;
    }
}
