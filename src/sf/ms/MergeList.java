package sf.ms;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode (int val){
        this.val = val;
    }
}

public class MergeList {
    /**
     * 时间复杂度 N² ，空间复杂度N
     *
     * list[1->1->3,
     *      1->2,
     *       2->2->3]
     *      1->1->1->2->2->2->3->3
     */

    public static ListNode mergeList(List<ListNode> list){
        ListNode res = new ListNode(-1);
        res.next = list.get(0);
        ListNode cur = res.next;
        for (int i = 1; i < list.size(); i++ ) {
            ListNode temp = list.get(i);
            cur = merge(temp,cur);
        }
        return res;
    }


    //将两个链表归并
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode cur = res.next;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }

}
