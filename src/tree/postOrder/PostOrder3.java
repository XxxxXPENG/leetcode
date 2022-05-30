package tree.postOrder;

import tree.TreeNode;

import java.util.*;

/**
 * 后序遍历
 */
public class PostOrder3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.poll();
            res.add(poll.val);

            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
