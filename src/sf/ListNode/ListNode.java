package sf.ListNode;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int val){
        this.val = val;
    }


    public static void main(String[] args) {
        System.out.println(ListNode.init(new int[]{1,2,3,4}));
    }

    public static ListNode init(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = new ListNode(arr[0]);
        dummy.next = cur;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummy.next;
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
