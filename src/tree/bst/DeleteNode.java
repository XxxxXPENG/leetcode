package tree.bst;

import tree.TreeNode;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            //当前节点为key
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
