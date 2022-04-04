package hot100;

import tree.TreeNode;

import java.util.*;

public class L98_验证二叉搜索树 {

    public static void main(String[] args) {
        L98_验证二叉搜索树 a = new L98_验证二叉搜索树();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(a.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> list = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            TreeNode poll = deque.poll();
            if (!list.isEmpty() && list.getLast() >= poll.val) {
                return false;
            }
            list.add(poll.val);
            root = poll.right;
        }
        return true;
    }
}
