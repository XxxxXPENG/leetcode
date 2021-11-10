package tree;

public class LongestUnivaluePath {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(arrowLeft + arrowRight, ans);
        return Math.max(arrowLeft, arrowRight);
    }
}
