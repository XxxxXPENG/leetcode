package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 * 根据前序遍历和中序遍历，恢复二叉树
 */
public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int preRoot = preLeft;
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = map.get(preorder[preRoot]);
        int leftSubTreeSize = inRoot - inLeft;

        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftSubTreeSize, inLeft, inRoot - 1);
        root.right = build(preorder, inorder, preLeft + leftSubTreeSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }
}
