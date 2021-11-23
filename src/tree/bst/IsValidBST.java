package tree.bst;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
//        double pre = -Double.MAX_VALUE;
//        while (!deque.isEmpty() || root != null) {
//            while (root != null) {
//                deque.push(root);
//                root = root.left;
//            }
//            root = deque.poll();
//            if (pre >= root.val) {
//                return false;
//            }
//            pre = root.val;
//            root = root.right;
//
//        }
//        return true;







        Deque<TreeNode> stack = new LinkedList<>();
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if (pre >= root.val) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }



}
