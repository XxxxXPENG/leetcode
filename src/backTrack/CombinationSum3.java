package backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        System.out.println(c.combinationSum3(3, 7));
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, 1, k, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int begin, int k, int sum) {
        if (k == path.size() && 0 == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= 9; i++) {
            if (sum - i < 0) {
                return;
            }
            path.add(i);
            dfs(res, path, i+1, k, sum-i);
            path.removeLast();
        }
    }
}
