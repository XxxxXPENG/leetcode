package sf.arr;

public class MaxSubArray {
    /**
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public static void main(String[] args) {
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4,-3,5,1,2};
        System.out.println(maxSubArray(arr));
    }
 /*   public static int maxSubArray(int[] nums) {
        int res = 0, firstHead = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > 0 && nums[i] + nums[i+1] > 0 && firstHead < nums[i]){ //从哪里开始
               firstHead = nums[i];
            }else if( nums[i] + nums[i+1] > 0){
                res += nums[i];
            }else{
                res = 0;
            }
        }
        return res + firstHead;
    }*/
 public static int maxSubArray(int[] nums) {
    int sum = 0;
    int res = nums[0];
    for (int num: nums) {
         if(sum > 0){
             sum += num;
         }else{
             sum = num;
         }
         res = Math.max(sum,res);
    }
    return res;
 }
}
