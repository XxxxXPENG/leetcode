package tree;

public class FindTilt {
    int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return res;
    }

    public int traverse(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
