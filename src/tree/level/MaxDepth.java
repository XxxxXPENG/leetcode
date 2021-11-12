package tree.level;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public int maxDepth2(Node root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res++;
        }
        return res;
    }

}
