package tree;

public class DiameterOfBinaryTree {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }
}
