package hot100;

import java.util.*;

public class L46_全排列 {

    public static void main(String[] args) {
        L46_全排列 a = new L46_全排列();
        System.out.println(a.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,nums, new ArrayDeque<>());
        return res;
    }


    public void dfs(List<List<Integer>> res, int[] nums, ArrayDeque<Integer> deque){
        int len = nums.length;
        if(deque.size() == len){
            res.add(new ArrayList<>(deque));
            return;
        }
        Set<Integer> set = new HashSet<>(deque);
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            deque.addLast(num);
            dfs(res, nums, deque);
            deque.removeLast();
        }
    }
}
