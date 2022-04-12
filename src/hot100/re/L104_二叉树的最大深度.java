package hot100.re;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }


    public int maxDepth2(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res++;
        }
        return res;
    }
}
