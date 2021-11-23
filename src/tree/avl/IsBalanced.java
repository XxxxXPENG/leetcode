package tree.avl;

import tree.TreeNode;

/**
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }


    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
