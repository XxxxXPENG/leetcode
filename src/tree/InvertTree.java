package tree;

import java.util.LinkedList;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return null;
        }

        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            /**
             * 交换左右节点
             */
            TreeNode temp = linkedList.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            if (temp.left != null) {
                linkedList.add(temp.left);
            }
            if (temp.right != null) {
                linkedList.add(temp.right);
            }
        }
        return root;
    }
}