package hot100.re;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L105_从前序与中序遍历序列构造二叉树 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int preLen = preorder.length, inLen = inorder.length;
        return build(preorder, 0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int p = map.get(preorder[preLeft]);
        root.left = build(preorder, preLeft + 1, p + preLeft - inLeft, inLeft, p - 1);
        root.right = build(preorder, p + preLeft - inLeft + 1, preRight, p + 1, inRight);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int preLen = preorder.length, inLen = inorder.length;
        return buildTree(preorder, 0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int p = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, p - inLeft + preLeft, inLeft, p - 1);
        root.right = buildTree(preorder, p - inLeft + preLeft + 1, preRight, p + 1, inRight);
        return root;
    }
}
