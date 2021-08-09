package sf.ListNode;

public class Test_del {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i = 0; i < 3 ; i++){
            cur.next = new ListNode(1);
        }
        head = head.next;
        System.out.println(head);
        head.next = head.next.next;
        System.out.println(head);

    }
}
