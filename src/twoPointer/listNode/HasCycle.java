package twoPointer.listNode;


import sf.ListNode.ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head == null ? head : head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
