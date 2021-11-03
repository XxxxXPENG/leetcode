package tree;

public class ConnectNode {

    public Node connect(Node root) {
        if (root == null ) {
            return null;
        }
        connectTwoNode(root.left, root.right);

        return root;
    }

    /**
     * 链接2个节点, 力扣116
     *
     * @param node1
     * @param node2
     */
    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }
}



class Node{
    int val;
    Node left;
    Node right;
    Node next;
}