package tu.re;

import java.util.*;

/**
 * 允许重复情况下，组合为target
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, res, path, candidates, target);
        return res;
    }

    private void dfs(int begin, List<List<Integer>> res, Deque<Integer> path, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(i, res, path, candidates, target - candidates[i]);
            path.removeLast();
        }

    }
}
