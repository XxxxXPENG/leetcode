package sf.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 0; i < 3 ; i++){
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            if(next.val == cur.val){
                cur.next = cur.next.next;//重复了就删除后面的节点
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
