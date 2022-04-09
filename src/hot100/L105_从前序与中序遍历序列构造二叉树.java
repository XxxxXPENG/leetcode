package hot100;

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
        return build(preorder, 0, preLen-1, 0, inLen - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        int pIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1);
        root.right = build(preorder, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight);
        return root;
    }


}
