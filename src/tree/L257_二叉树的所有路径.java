package tree;

import java.util.ArrayList;
import java.util.List;

public class L257_二叉树的所有路径 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }

        sb.append(root.val);
        StringBuilder leftSb = new StringBuilder(sb);
        StringBuilder rightSb = new StringBuilder(sb);
        if (root.left != null) {
            leftSb.append("->");
            dfs(root.left, leftSb);
        }
        if (root.right != null) {
            rightSb.append("->");
            dfs(root.right, rightSb);
        }
    }
}
