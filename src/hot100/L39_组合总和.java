package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L39_组合总和 {
    public static void main(String[] args) {
        L39_组合总和 a = new L39_组合总和();
        System.out.println(a.combinationSum(new int[]{2,3,6,7},7));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void dfs2(int[] candidates, int target, Deque<Integer> deque, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int candidate : candidates) {
            deque.addLast(candidate);
            dfs2(candidates, target - candidate, deque, res);
            deque.removeLast();
        }
    }




    public void dfs(int[] candidates, int target, int index, Deque<Integer> deque, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i=index; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, deque, res);
            deque.removeLast();
        }
    }
}
