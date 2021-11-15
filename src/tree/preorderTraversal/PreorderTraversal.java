package tree.preorderTraversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 */
public class PreorderTraversal {

    //迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            res.add(poll.val);
            if (poll.right != null) {
                deque.push(poll.right);
            }
            if (poll.left != null) {
                deque.push(poll.left);
            }
        }
        return res;
    }





    List<Integer> res = new ArrayList<>();

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }



}
