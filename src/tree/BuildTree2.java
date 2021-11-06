package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        postIndex = n -1;
        return build(inorder, postorder, 0, n - 1);

    }

    TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = map.get(postorder[postIndex]);
        postIndex--;
        root.right = build(inorder, postorder, index + 1, inRight);
        root.left = build(inorder, postorder, inLeft, index - 1);
        return root;
    }
}
