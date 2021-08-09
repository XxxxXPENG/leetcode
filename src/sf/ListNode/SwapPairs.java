package sf.ListNode;

/**
 * 链表节点两两交换
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.init(4);
//        System.out.println(head.next);
        System.out.println(swapPairs(head.next));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1),next = null, temp1 = null,temp2=null;
        res.next = head;
        ListNode pre = res;//错了，让中介去做
        while(pre.next != null && pre.next.next != null){ //错了，都少了.next
            //保存要交换的节点
            temp1 = pre.next;//存放头节点 :1
            temp2 = pre.next.next;//第二个节点 :2
            next =temp2.next;//后继节点 :3
            //交换
            temp1.next = next;// 1,3
            temp2.next = temp1;//2,1,3
            //重建 : pre.next = temp2
            pre.next = temp2;
            //跳
            pre = temp1;//
        }// 1 2 3 4 -->
        return res.next;
    }
}
