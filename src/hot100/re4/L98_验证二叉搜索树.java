package hot100.re4;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        double pre = -Double.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode poll = stack.poll();
            if (pre >= poll.val) {
                return false;
            }
            pre = poll.val;
            root = poll.right;
        }
        return true;
    }
}
