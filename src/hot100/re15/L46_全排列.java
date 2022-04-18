package hot100.re15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L46_全排列 {
    public static void main(String[] args) {
        L46_全排列 a = new L46_全排列();
        System.out.println(a.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, visited, new ArrayDeque<Integer>(), nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] visited, Deque<Integer> deque, int[] nums, int index) {
        if (nums.length == deque.size()) {
            res.add(new ArrayList<>(deque));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                deque.add(nums[i]);
                visited[i] = true;
                dfs(res, visited, deque, nums, index + 1);
                deque.removeLast();
                visited[i]=false;
            }
        }
    }
}
