package tree.preorderTraversal;


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
public class Preorder {


    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty() ) {
            Node pop = stack.pollLast();
            res.add(pop.val);
            Collections.reverse(pop.children);
            stack.addAll(pop.children);
        }
        return res;
    }




    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        root.children.forEach(this::dfs);
    }
}
