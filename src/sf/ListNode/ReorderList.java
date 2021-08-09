package sf.ListNode;

/**
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 */

/**
 * 思路：
 * 一、分2段链表，1-2-3 ， 4-5
 * 二、反转右边链表
 * 三、合并
 */
public class ReorderList {

    public void recorderList(ListNode head){
        if(head == null) return;
        ListNode middle = middle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        right = reverse(right);
        merge(left,right);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.init(5);


    }

//    public void reorderList(ListNode head) {
//        if(head == null) return;
//        ListNode midle = devide(head);
//        ListNode left = head;
//        ListNode right = midle.next;
//        midle.next = null; //为啥left 就变为 1 - 2 - 3 - null了？ head 和mid什么关系
//    }

    public static ListNode middle(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null, cur = pre;
        while (head != null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
    //明天重写一次
    // 1-2-3   5-4   , 1 5 2 4 3.  规则： 左一个右一个
    public static void merge(ListNode l1, ListNode l2){
        ListNode leftTemp ;
        ListNode rightTemp;
        while (l1.next != null && l2 != null){ //为啥是l1.next != null
            leftTemp = l1.next;
            rightTemp = l2.next;
            l1.next = l2;//将l1的后继插入l2
            l2.next = leftTemp;//在l2插入下个左节点
            l2 = rightTemp;
            l1 = leftTemp;
        }
    }
}
