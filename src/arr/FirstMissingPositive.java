package arr;


public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1,i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums,int index1,int index2){
        if(nums == null){
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }
}
