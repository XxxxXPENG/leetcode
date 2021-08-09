package arr.moveArr;

/**
 * 改变一个数，让数组变为非递减
 *
 */
public class CheckPossibility {

    public static void main(String[] args) {

        System.out.println(checkPossibility(new int[]{4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        for(int i = 1; i < nums.length; i++){
            int pre = nums[i-1];
            if(nums[i] < nums[i-1]){
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = pre;
                }
                break;

            }
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
