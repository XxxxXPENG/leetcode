package hot100.re2;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L98_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        double pre = -Double.MAX_VALUE;
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            TreeNode poll = deque.poll();
            if (pre >= poll.val) {
                return false;
            }
            pre = poll.val;
            root = poll.right;
        }
        return true;
    }

}
