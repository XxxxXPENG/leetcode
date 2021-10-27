package tree;

import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root.left);
        linkedList.add(root.right);
        while (linkedList.size() > 0) {
            TreeNode left = linkedList.removeFirst();
            TreeNode right = linkedList.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            linkedList.add(left.left);
            linkedList.add(right.right);
            linkedList.add(left.right);
            linkedList.add(right.left);
        }
        return true;
    }

}
