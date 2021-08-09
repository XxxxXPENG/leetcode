package listNode;



class Node{
    public int val;
    public Node pre;
    public Node next;
    public Node child;

    public Node(int val, Node pre, Node next, Node child) {
        this.val = val;
        this.pre = pre;
        this.next = next;
        this.child = child;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}

public class Flatten {

    private Node pre = null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if(head == null) return;
        Node next = head.next;
        if (pre != null) {
            pre.next = head;
            head.pre = pre;
        }
        pre = head;
        dfs(head.child);
        head.child = null;
        dfs(next);


    }

}
