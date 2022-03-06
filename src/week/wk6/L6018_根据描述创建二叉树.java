package week.wk6;

import tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L6018_根据描述创建二叉树 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> pMap = new HashMap<>();
        Set<TreeNode> childSet = new HashSet<>();
        for (int[] description : descriptions) {
            int pVal = description[0];
            int cVal = description[1];
            boolean left = description[2] == 1;
            TreeNode p = pMap.get(pVal);
            if (p == null) {
                p = new TreeNode(pVal);
                pMap.put(pVal, p);
            }
            TreeNode c = pMap.get(cVal);
            if (c == null) {
                c = new TreeNode(cVal);
                pMap.put(c.val, c);
            }

            if (left) {
                p.left = c;
            } else {
                p.right = c;
            }
            childSet.add(c);
        }

        //找根节点
        TreeNode root = null;
        for (TreeNode value : pMap.values()) {
            if (!childSet.contains(value)) {
                root = value;
            }
        }
        return root;
    }
}
