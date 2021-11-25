package tree.buildTree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序和中序，重构二叉树
 */
public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, len - 1, 0);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        int inRootIndex = map.get(rootVal);
        int leftNum = inRootIndex - inLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preLeft+1, preLeft+leftNum, inLeft);
        root.right = build(preorder, preLeft+leftNum+1, preRight, inRootIndex + 1);
        return root;
    }
}
