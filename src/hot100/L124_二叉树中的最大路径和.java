package hot100;

import tree.TreeNode;

public class L124_二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(0,maxGain(root.left));
        int rightGain = Math.max(0, maxGain(root.right));
        int curMax = leftGain + rightGain + root.val;
        max = Math.max(leftGain, curMax);
        return root.val + Math.max(leftGain, rightGain);
    }
}
