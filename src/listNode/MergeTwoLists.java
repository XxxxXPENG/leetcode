package listNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createListNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.createListNode(new int[]{1, 3});
        System.out.println(mergeTwoLists2(l1,l2));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            } else if (l2 == null) {
                cur.next = l1;
                break;
            } else if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            Integer val1 = null,val2 = null;
            if(l1 != null){
                val1 = l1.val;
            }
            if(l2 != null){
                val2 = l2.val;
            }
            if (val1 != null && val2 != null &&l1.val <= l2.val) {
                cur.next = new ListNode(val1);
                l2 = l2.next;
            }
            if(val1 != null && val2 != null && l1.val > l2.val){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l2 == null){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;

        }
        return dummy.next;
    }
}
