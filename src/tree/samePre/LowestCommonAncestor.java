package tree.samePre;

import tree.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //p,q为根节点则直接返回
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;


    }

    private boolean find(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return find(root.left, p) || find(root.right, p);
    }
}
