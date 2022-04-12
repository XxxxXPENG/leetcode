package hot100.re2;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            root.right = new TreeNode(list.get(i));
            root.left = null;
            root = root.right;
        }
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }


}
