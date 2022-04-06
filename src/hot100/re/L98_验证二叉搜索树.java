package hot100.re;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class L98_验证二叉搜索树 {
    public static void main(String[] args) {
        L98_验证二叉搜索树 a = new L98_验证二叉搜索树();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(a.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        //题目要求 -2(31) <= Node.val <= 2(31) - 1  ,所以val要用double类型
        double pre = -Double.MAX_VALUE;
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            TreeNode poll = deque.poll();
            if (pre >= poll.val) {
                return false;
            }
            pre = poll.val;
            root=poll.right;
        }
        return true;
    }

}
