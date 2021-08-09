package sf.ListNode.re;

public class ListNode {
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
