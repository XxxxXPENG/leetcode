package tree.bst;

import tree.TreeNode;

public class ConvertBST {
    //反中序遍历 （右 中 左）
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return val;
        }
        root.val += dfs(root.right, val);
        return dfs(root.left, root.val);
    }
}
