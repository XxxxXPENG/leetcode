package hot100;

import java.util.*;

public class L78_子集 {

    public static void main(String[] args) {
        L78_子集 a = new L78_子集();
        System.out.println(a.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums,0,new ArrayDeque<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, Deque<Integer> deque) {
        res.add(new ArrayList<>(deque));
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            deque.add(nums[i]);
            dfs(res, nums, i+1, deque);
            deque.removeLast();
        }
    }
}
