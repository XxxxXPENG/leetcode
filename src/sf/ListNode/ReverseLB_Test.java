package sf.ListNode;

public class ReverseLB_Test {
    public static void main(String[] args) {
        //初始化链表1-5
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++){
            ListNode temp = new ListNode(i);
            //在head后插入temp
             cur.next = temp;
             cur = temp;     //temp就等于cur = cur.next
        }
//        //打印初始化
//        System.out.print("初始化的链表：");
//        while(head != null){
//            System.out.print(head.val+"->");
//            head = head.next;
//        }
        //反转链表
        ListNode dummy = null, next = dummy;
//        while(head != null){
//            ListNode temp = head.next;
//            head.next = dummy.next;
//            dummy.next = head;
//            head = temp;
//        }
        while(head != null){
            next = head.next; //记录下一个节点，因为等下要插入pre
            head.next = dummy;//插入pre,这个pre为上一次的头节点。因此这个方法叫头插法
            dummy = head;//记录头节点，为下一次循环来头插
            head = next;//改变下一个节点
        }
        //打印
        System.out.print("反转后的结果：");
        while(dummy != null){
            System.out.print(dummy.val + "->");
            dummy = dummy.next;
        }


    }
}
