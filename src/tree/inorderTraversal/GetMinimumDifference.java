package tree.inorderTraversal;

import tree.TreeNode;

public class GetMinimumDifference {

    int pre;
    int res;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
