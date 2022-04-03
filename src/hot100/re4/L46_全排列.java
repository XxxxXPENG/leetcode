package hot100.re4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        dfs(0,res, nums, new LinkedList<>(), new boolean[len]);
        return res;
    }

    private void dfs(int begin,List<List<Integer>> res, int[] nums, Deque<Integer> deque, boolean[] visited) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            deque.add(nums[i]);
            visited[i] = true;
            dfs(i, res, nums, deque, visited);
            deque.removeLast();
            visited[i] = false;
        }
    }
}
