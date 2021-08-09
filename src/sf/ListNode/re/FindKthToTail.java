package sf.ListNode.re;

public class FindKthToTail {
    /**输出链表的倒数第K个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k){
        ListNode p1 = head,p2 = head;
        //看看链表有没有K个数
        while(p1 != null && k-- > 0){
            p1 = p1.next;
        }
        if(k > 0) return null; //说明链表太短，根本没有倒数第K个数
        while(p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
