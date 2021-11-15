package tree.preorderTraversal;

import tree.TreeNode;

public class Tree2str {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        if (root.right == null) {
            sb.append(root.val).append("(");
            dfs(root.left);
            sb.append(")");
        } else {

            sb.append(root.val);
            sb.append("(");
            dfs(root.left);
            sb.append(")");

            sb.append("(");
            dfs(root.right);
            sb.append(")");

        }
    }
}


