package sf.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *  A:  a1 -> a2 -> c1 -> c2 -> c3
 *  B:  b1 -> b2 -> b3 -> c1 -> c2 -> c3
 * 在节点 c1 开始相交。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        //当一个短的链表遍历结束，让他遍历另外一个链表。当2个链表相等
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}
