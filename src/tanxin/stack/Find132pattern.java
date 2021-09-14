package tanxin.stack;

import java.util.PriorityQueue;

public class Find132pattern {
    public static void main(String[] args) {
        System.out.println(find132pattern2(new int[]{3,1,4,2}));
    }

    public static boolean find132pattern2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                pq.offer(nums[i+1]);
                int j = i + 1;
                while (j <= nums.length - 1) {
                    if (nums[j] < pq.peek() && nums[j] > nums[i]) {
                        return true;
                    }
                    j++;
                }
            }
        }
        return false;
    }


    //不用连续
    public static boolean find132pattern(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1] && nums[i+1] > nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
