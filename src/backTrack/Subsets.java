package backTrack;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(0, res, path, nums);
        return res;
    }


    private void dfs2(int index, List<List<Integer>> res, Deque<Integer> path, int[] nums) {
        res.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            dfs2(i + 1, res, path, nums);
            path.removeLast();
        }
    }



        private void dfs(int index, List<List<Integer>> res, Deque<Integer> path, int[] nums) {
        if (index == nums.length ) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(index + 1, res, path, nums);
        path.removeLast();
        dfs(index + 1, res, path, nums);
    }
}
