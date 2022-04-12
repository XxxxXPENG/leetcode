package hot100.re4;

import tree.TreeNode;

public class L101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right)
                && check(left.right, right.left);
    }

}
