package twoPointer.stage;

import sf.ListNode.ListNode;

/**
 * 判断2个链表是否相交
 * 当一个链表为null时让他等于另外一个链表的头结点，
 * 交换完一次后，2个链表长度就相等了。
 * 然后在碰到2个链表相等的时候，直接返回
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}
