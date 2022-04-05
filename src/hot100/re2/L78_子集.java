package hot100.re2;

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
        Deque<Integer> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, deque, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> deque, int begin) {
        res.add(new ArrayList<>(deque));
        for (int i = begin; i < nums.length; i++) {
            deque.add(nums[i]);
            dfs(res, nums, deque, i + 1);
            deque.removeLast();
        }
    }


}
