package hot100;

import sf.ListNode.ListNode;

public class L21_合并两个有序链表 {

    public static void main(String[] args) {
        L21_合并两个有序链表 a = new L21_合并两个有序链表();
        ListNode l1 = new ListNode(1);
        ListNode temp = new ListNode(2);
        temp.next = new ListNode(4);
        l1.next = temp;

        ListNode l2 = new ListNode(1);
        ListNode temp2 = new ListNode(3);
        temp2.next = new ListNode(4);
        l2.next = temp2;
        System.out.println(a.mergeTwoLists(l1, l2));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummy.next;
    }
}
