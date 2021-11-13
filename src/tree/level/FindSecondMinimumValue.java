package tree.level;

import tree.TreeNode;

import java.util.*;

/**
 * 二叉树中，第二小的值
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            set.add(node.val);
            if (node.left != null) {
                deque.offer(node.left);
                deque.offer(node.right);
            }
        }
        if (set.size() < 2) {
            return -1;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (Integer num : set) {
            if (num <= first) {
                second = first;
                first = num;
            } else if (num <= second) {
                second = num;
            }
        }
        return second;
    }
}
