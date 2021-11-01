package tree;

import java.util.*;

public class FindFrequentTreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        posOrder(root);
        List<Integer> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == max) {
                list.add(k);
            }
        });
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int posOrder(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = posOrder(root.left);
        int right = posOrder(root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }

}
