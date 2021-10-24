package twoPointer;

public class CircularArrayLoop {
    public static void main(String[] args) {
        System.out.println(circularArrayLoop2(new int[]{2,-1,1,2,2}));
    }
    public static boolean circularArrayLoop2(int[] nums) {
        int offset = 100010;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= offset) continue;
            int cur = i, tag = offset + i, last = -1;
            boolean flag = nums[i] > 0;
            while (true) {
                int next = ((nums[cur] + cur) % n + n) % n;
                last = nums[cur];
                nums[cur] = tag;
                cur = next;

                if (cur == i) {
                    break;
                }
                if (nums[cur] >= offset) {
                    break;
                }
                if (flag && nums[cur] < 0) {
                    break;
                }
                if (!flag && nums[cur] > 0) {
                    break;
                }
            }
            if (last % n != 0 && nums[cur] == tag) {
                return true;
            }
        }
        return false;
    }



}
