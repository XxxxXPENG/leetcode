package backTrack;

import java.util.*;

public class SubsetsWithDup {

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if ( index != i && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.removeLast();
        }
    }
}
