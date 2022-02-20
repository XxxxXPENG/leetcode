package week.wk4;

import sf.ListNode.ListNode;

public class L6013_合并零之间的节点 {

    public static void main(String[] args) {
        L6013_合并零之间的节点 a = new L6013_合并零之间的节点();
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(0);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(0);

        System.out.println(a.mergeNodes(listNode));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int tmp = 0;
        boolean start = true;
        while (head != null) {
            while ((head != null && head.val == 0 ) || start) {
                tmp += head.val;
                head = head.next;
                if (head != null && head.val == 0) {
                    cur.next = new ListNode(tmp);
                    cur = cur.next;
                    start = false;
                }
            }
            tmp = 0;
            start = true;
        }
        return res.next;
    }
}
