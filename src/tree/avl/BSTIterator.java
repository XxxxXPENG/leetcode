package tree.avl;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    private int idx;
    private List<Integer> list = new ArrayList<>();


    public BSTIterator(TreeNode root) {
        init(root);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    public void init(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            list.add(root.val);
            root = root.right;
        }
    }


}
