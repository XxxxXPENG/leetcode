package sf.ListNode;


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.init(3);
        l2.init(3);
//        System.out.println("l1:"+l1.toString() +"\nl2:" + l2.toString());
        System.out.println("res:"+mergeTwoLists(l1,l2));
    }
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        ListNode res = new ListNode(0),next = res;
//        while(l1 != null && l2 != null){
//            if(l1.val <= l2.val){
//                next.next = l1;
//                l1 = l1.next;
//                next = next.next;
//            }else{
//                next.next = l2;
//                l2 = l2.next;
//                next = next.next;
//            }
//        }
//        if(l1 != null){
//            next.next = l1;
//        }
//        if(l2 != null){
//            next.next = l2;
//        }
//        return res.next;
//    }

    //为啥这个就错了？？
    //debug看了发现 p1 1->2->3  p2 2->3进了if条件

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1),res = result;
        while(l1 != null && l2 != null){
            //当l2小，将l2插入res
            if(l1.val >= l2.val){
                res.next = l2;
                l2 = l2.next;
            }else{
                res.next = l1;
                l1 = l1.next;
            }
            res = res.next;
        }
        //跳出上面的循环，l1为空或者l2为空
        res.next = l1 == null ? l2 : l1;
        return result.next.next;
    }
}
