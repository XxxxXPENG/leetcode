package token;

import java.util.Arrays;

public class OptimalDivision {

    public static void main(String[] args) {
        String[] arr = {"23:00", "22:00", "22:30", "22:28", "22:58"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] / nums[1] + "";
        }
        StringBuilder sb = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}
