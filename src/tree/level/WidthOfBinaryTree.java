package tree.level;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大宽带（最大层的长度）
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<HelpedNode> queue = new LinkedList<>();
        queue.offer(new HelpedNode(root, 0, 0));
        int curDep = 0, left = 0, res = 0;
        while (!queue.isEmpty()) {
            HelpedNode a = queue.poll();
            if (a.node != null) {
                queue.offer(new HelpedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.offer(new HelpedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDep != a.depth) {
                    curDep = a.depth;
                    left = a.pos;
                }
                res = Math.max(res, a.pos - left + 1);
            }
        }
        return res;
    }


    class HelpedNode{
        TreeNode node;
        int depth;
        int pos;

        public HelpedNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
