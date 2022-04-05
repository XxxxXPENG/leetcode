package hot100.re7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L46_全排列 {

    public static void main(String[] args) {
        L46_全排列 a = new L46_全排列();
        System.out.println(a.permute(new int[]{1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, nums, deque,visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> deque, boolean[] visited) {
        if (deque.size() == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            deque.add(nums[i]);
            dfs(res, nums, deque, visited);
            deque.removeLast();
            visited[i]= false;
        }
    }
}
