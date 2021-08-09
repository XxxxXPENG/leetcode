package sf.ListNode;

public class FindKthToTail {
    public static void main(String[] args) {
        //如何自己创建链表实例？  [1,2,3,4,5]的链表
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2 ; i <= 5; i++){
            ListNode temp = new ListNode(i);
            //在head后插入temp
            cur.next = temp;
            cur = cur.next; //head最后会变为5
        }
//        head = head.next;
        //顺序打印链表    咋就1 5？
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }

    }
    public static ListNode findKthToTail(ListNode head, int k ){
        if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        //判断是否有K个数
        while(p1 != null && k-- > 0){
            p1 = p1.next;
        }
        if(k > 0) return null;
        //有K个数后，P1走到底，p2就是倒数第K个
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return  p2;
    }

}
