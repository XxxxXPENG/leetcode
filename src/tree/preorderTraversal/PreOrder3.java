package tree.preorderTraversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder3 {
    /**
     * 迭代做法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (root != null || !stack.isEmpty()) {
            TreeNode poll = stack.poll();
            res.add(poll.val);
            if (poll.left != null) {
                stack.push(root.left);
            }
            if (poll.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
