package tree;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    /**
     * 将二叉树转为链表
     * @param root
     */
    void flatten(TreeNode root){
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;
        TreeNode left = root.left;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
