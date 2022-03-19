package hot100.re;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L39_组合总和 {

    public static void main(String[] args) {
       L39_组合总和 a = new L39_组合总和();
        System.out.println(a.combinationSum(new int[]{2,3,6,7},7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,res, target, 0, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, int target, int index, ArrayDeque<Integer> deque) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            deque.addLast(candidates[i]);
            dfs(candidates, res, target - candidates[i], i, deque);
            deque.removeLast();
        }
    }


}
