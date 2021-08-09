package sf.ListNode;

public class Test_insert {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        l1.init(3);// l1: -1,1,2,3
        ListNode cur = l1.next; //1,2,3
        ListNode l2 = new ListNode(0);
        //要想l1变为 -1，0，1，2，3
        l2.next = cur;
        l1.next = l2;
        System.out.println(l1);

        //测试head != null 和 head.next != null
        ListNode head = l1;
        while(head.next != null ){
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}
