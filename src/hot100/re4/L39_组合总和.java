package hot100.re4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L39_组合总和 {

    public static void main(String[] args) {
        L39_组合总和 a = new L39_组合总和();
        System.out.println(a.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, target, new ArrayDeque<>(),0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, Deque<Integer> deque,int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            dfs(res, candidates, target - candidates[i], deque,i);
            deque.removeLast();
        }
    }
}
