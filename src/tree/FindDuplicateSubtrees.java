package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    int t;
    Map<String,Integer> trees;
    Map<Integer,Integer> count;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        res = new ArrayList<>();
        lookup(root);
        return res;
    }

    public int lookup(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String serial = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int id = trees.computeIfAbsent(serial, x -> t++);
        count.put(id, count.getOrDefault(id, 0) + 1);
        if (count.get(id) == 2) {
            res.add(root);
        }
        return id;
    }
}
