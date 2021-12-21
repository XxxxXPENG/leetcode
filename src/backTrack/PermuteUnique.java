package backTrack;

import java.util.*;

public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique p = new PermuteUnique();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] vis = new boolean[nums.length];
        dfs(res, path, nums,vis);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, boolean[] vis) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //重复元素不能在同一层
            if (i > 0 && nums[i - 1] == nums[i] && !vis[i-1]) {
                continue;
            }
            if (!vis[i]) {
                vis[i] = true;
                path.add(nums[i]);
                dfs(res, path, nums, vis);
                path.removeLast();
                vis[i] = false;
            }
        }
    }
}
