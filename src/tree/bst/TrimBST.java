package tree.bst;

import tree.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;
        //剪掉大于最大值的右侧
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        //剪掉小于最小值的左侧
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
