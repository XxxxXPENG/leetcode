package hot100;

import sf.ListNode.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class L23_合并K个升序链表 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.init(new int[]{1,4,5});
        ListNode l2 = ListNode.init(new int[]{1,3,4});
        ListNode l3 = ListNode.init(new int[]{2, 6});
        ListNode[] arr = new ListNode[]{l1, l2, l3};
        L23_合并K个升序链表 a = new L23_合并K个升序链表();
        System.out.println(a.mergeKLists2(arr));

    }

    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            //每次只改变尾节点位置，直插入一个元素
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }



    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = lists[0];
        for (int i = 1; i < lists.length; i++) {
            cur = merge(cur, lists[i]);
        }
        return cur;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = new ListNode(a.val);
                a = a.next;
            } else {
                cur.next = new ListNode(b.val);
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) {
            cur.next = b;
        } else {
            cur.next = a;
        }
        return dummy.next;
    }
}
