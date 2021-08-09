package sf.ListNode;

public class ListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.init(5);  //初始化的时候是从2开始的啊？！ 怎么还是1   ----因为next默认就是null
//        System.out.println(head.toString());
        ListNode cur = head;  // -1 1 2 3 4 5
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println(head.toString());  //为什么这种就从1开始
    }
    public ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
    ListNode init(int n){
        if(next == null){
            next = new ListNode(1);
        }
        ListNode cur = next;
        for(int i = 2; i <= n; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return next;
    }

    @Override
    public String toString() {
        String res = this.val+"->";
        ListNode cur = next;
        while(cur != null ){
            res += cur.val + "->";
            cur = cur.next;
        }
        return res;
    }
}
