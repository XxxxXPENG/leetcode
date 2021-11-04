package tree;

/**
 * 构造最大二叉树
 */
public class ConstructMaximumBinaryTree {

    TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, l, index - 1);
        root.right = build(nums, index + 1, r);
        return root;
    }


}
