package hot100;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }


    public int bfsMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()) {
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.push(poll.left);
                }
                if (poll.right != null) {
                    deque.push(poll.right);
                }
            }
        }
        return res;
    }

}
