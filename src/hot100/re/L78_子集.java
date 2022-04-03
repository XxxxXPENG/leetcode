package hot100.re;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L78_子集 {
    public static void main(String[] args) {
        L78_子集 a = new L78_子集();
        System.out.println(a.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        dfs(visited, nums, 0, res, new LinkedList<>());
        return res;
    }

    private void dfs(boolean[] visited, int[] nums, int begin, List<List<Integer>> res, Deque<Integer> deque) {
        res.add(new ArrayList<>(deque));
        for (int i = begin; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                deque.add(nums[i]);
                dfs(visited, nums, i, res, deque);
                deque.removeLast();
                visited[i] = false;
            }
        }
    }
}
