package sf.ListNode;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val){
        this.val = val;
    }

    public ListNode(ListNode head, int val) {
        next = new ListNode(val);
        next.next = head;
    }

    public ListNode init(int n){
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
