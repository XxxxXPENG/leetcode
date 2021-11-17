package tree.serialization;

import tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(temp));
        return build(deque);
    }


    TreeNode build(Deque<String> deque) {
        String poll = deque.poll();
        if ("#".equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = build(deque);
        root.right = build(deque);
        return root;
    }


    //BFS
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll == null) {
                sb.append("#,");
            } else {
                sb.append(poll.val).append(",");
                deque.offer(poll.left);
                deque.offer(poll.right);
            }
        }
        return sb.toString();
    }


    public TreeNode deserialize2(String data) {
        if ( "".equals(data)) {
            return null;
        }
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left);
            }
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.add(node.right);
            }
        }
        return root;

    }
}
