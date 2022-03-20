package hot100.re;

import java.util.*;

public class L46_全排列 {
    public static void main(String[] args) {
        L46_全排列 a = new L46_全排列();
        System.out.println(a.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayDeque<Integer> deque) {
        int len = nums.length;
        if (deque.size() == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        Set<Integer> set = new HashSet<>(deque);
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            deque.addLast(num);
            dfs(nums, res, deque);
            deque.removeLast();
        }
    }


}
