package sf.ListNode.re;



public class PrintListFromTailToHead {
    public static ListNode printListFromTailToHead(ListNode head){
        //波浪号出现，表示我们重写成功，2个代码一样
        ListNode pre = null,cur = pre;
        while(head != null){
            cur = head.next; //记录下一个节点，因为等下要插入pre,会改变原来链表的下一个节点
            head.next = pre;//插入pre,这个pre为上一次的头节点。因此这个方法叫头插法
            pre = head;//记录头节点，为下一次循环来头插
            head  = cur;//改变下一个节点
        }
        return pre;
    }
}
