package tu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        System.out.println(p.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(used, path, res, nums);
        return res;
    }

    private void dfs(boolean[] used, Deque<Integer> path, List<List<Integer>> res, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(used, path, res, nums);
                path.removeLast();
                used[i]=false;
            }
        }
    }
}