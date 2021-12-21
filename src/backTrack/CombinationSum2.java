package backTrack;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        System.out.println(c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(res, candidates, path, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, Deque<Integer> path, int begin, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(res, candidates, path, i + 1, target - candidates[i]);
            path.removeLast();
        }
    }
}
