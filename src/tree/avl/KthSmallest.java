package tree.avl;

import tree.TreeNode;

public class KthSmallest {

    int kth, res;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null || kth <= 0) {
            return;
        }
        if (root.left != null) {
            kthSmallest(root.left, kth);
        }
        if (--kth == 0) {
            res = root.val;
            return;
        }
        if (root.right != null) {
            kthSmallest(root.right, kth);
        }
    }
}
