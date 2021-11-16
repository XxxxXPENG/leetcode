package tree.serialization;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    int t = 1;
    Map<String, Integer> trees = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        lookUp(root);
        return res;
    }

    public int lookUp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        String serial = root.val + "," + lookUp(root.left) + "," + lookUp(root.right);
        int id = trees.computeIfAbsent(serial, x -> t++);
        count.put(id, count.getOrDefault(id, 0) + 1);
        if (count.get(id) == 2) {
            res.add(root);
        }
        return id;
    }
}
