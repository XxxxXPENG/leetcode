package hot100;

public class L75_颜色分类 {
    public void sortColors(int[] nums) {
        int p2 = nums.length-1,p0=0;
        for(int i = 0; i <= p2; i++){
            while(p2 >= i && nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2--] = tmp;
            }
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0++] = tmp;
            }
        }
    }
}
