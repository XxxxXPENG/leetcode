package tree.postOrder;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Postorder2 {

    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            res.add(node.val);
            if (node.children != null) {
                node.children.forEach(deque::push);
            }
        }
        Collections.reverse(res);
        return res;
    }



    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            root.children.forEach(node -> dfs(node, res));
        }
        res.add(root.val);
    }
}
