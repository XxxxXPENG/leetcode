package tu.re;

import java.util.*;

/**
 * 每个数字只能使用一次，且组合不能重复
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        System.out.println(c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        // 1 1 2 5 6 7 10
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, path, res);
        return res;
    }

    private void dfs(int begin, int[] candidates, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
