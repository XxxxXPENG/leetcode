package sf.ListNode.re;
/**
 * merge：1 2 3， 7 8 9  ->  1 7 2 8 3 9
 * merge2: 1 2 3  1 2 3 ->  1 1 2 2 3 3
 */
public class Merge {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1),l2 = new ListNode(-1);
        l1.init(3);
        l2.init(3);
//        System.out.println(l1.toString()+"\n"+l2.toString());
        System.out.println(merge2(l1.next,l2.next));
    }



    //顺序插入 新建链表
    public static ListNode merge2(ListNode l1,ListNode l2){
        ListNode res = new ListNode(-1),temp = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return res.next;//为什么别人是res.next.next? 还是改回res.next了

    }



    //左插1右插1
    public static void merge(ListNode left,ListNode right){
        ListNode leftTemp  = null, rightTemp = null;
        while(left != null && right != null){
            leftTemp = left.next;
            rightTemp = right.next;
            left.next = right;//左边插入右链表
            right.next = leftTemp;//右链表的下一个节点变为左链表，让链表连续
            left = leftTemp;
            right = rightTemp;
        }
    }
}
