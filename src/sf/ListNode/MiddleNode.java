package sf.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.init(5);
//        System.out.println(head.toString());
        System.out.println(middleNode2(head).toString());
        System.out.println(head.toString());

    }


    public static ListNode middleNode2(ListNode head){
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head){
        int i = 0;
        ListNode cur = head,res = head;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        for (int j = 0; j < i/2; j++){
            res = res.next;
        }
        return res;
    }
}
