package sf.ListNode.re;

public class SwapPairs {
    /**
     *1,2,3,4  --> 2,1,4,3
     */
    public static void main(String[] args) {
        ListNode temp = new ListNode(-1);
        temp.init(4);
        ListNode head = temp.next; // 1,2,3,4
        //开始交换
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head){
       ListNode res = new ListNode(-1);
       res.next = head;
       ListNode pre = res;
       while(pre.next != null && pre.next.next != null){
           //保存下要改变的节点
           ListNode temp1 = pre.next;
           ListNode temp2 = pre.next.next;
           ListNode next = temp2.next;
           //交换
           temp1.next = next;
           temp2.next = temp1;
           //重建
           pre.next = temp2;
           pre = temp1;
       }
       return res.next;
    }
}
