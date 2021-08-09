package listNode;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(val + ",");
        ListNode temp = next;
        while (temp != null) {
            res.append(temp.val).append(",");
            temp = temp.next;
        }
        return res.toString();
    }

   static ListNode createListNode(int[] arr) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return res.next;
    }
}

public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyNode.next;
    }
}
