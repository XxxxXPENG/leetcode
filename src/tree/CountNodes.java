package tree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root != null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }


    /**
     * 迭代解法
     * @param root
     * @return
     */
        public int countNodes2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int level = 0;
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
                level++;
            }

            int low = 1 << level, high = (1 << (level + 1)) - 1;
            while (low < high) {
                int mid = low + ((high - low + 1) >> 1);
                if (exists(root, level, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        /**
         * 判断K节点是否在完全二叉树中
         *
         * @param node
         * @param level
         * @param k
         * @return
         */
        public boolean exists(TreeNode node, int level, int k) {
            int bits = 1 << (level - 1);
            while (node != null && bits > 0) {
                if ((bits & k) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                bits >>= 1;
            }
            return node != null;
        }

}
