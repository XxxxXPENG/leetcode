package backTrack;

import java.util.*;

public class FindSubsequences {
    public static void main(String[] args) {
        FindSubsequences fs = new FindSubsequences();
        System.out.println(fs.findSubsequences(new int[]{4,4,3,2}));
    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(-1, res, path, nums);
        return res;
    }

    private void dfs(int begin, List<List<Integer>> res, Deque<Integer> path, int[] nums) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = begin + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (begin == -1 || nums[i] >= path.getLast()) {
                path.add(nums[i]);
                dfs(i, res, path, nums);
                path.removeLast();
            }
        }
    }

}
