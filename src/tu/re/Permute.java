package tu.re;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 */
public class Permute {
    public static void main(String[] args) {
        Permute p = new Permute();
        System.out.println(p.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, vis, path, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] vis, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == vis.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path.add(nums[i]);
                dfs(nums, vis, path, res);
                path.removeLast();
                vis[i] = false;
            }
        }
    }
}
