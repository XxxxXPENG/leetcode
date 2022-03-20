package hot100.re;

public class L33_搜索旋转排序数组 {

    public static void main(String[] args) {
        L33_搜索旋转排序数组 a = new L33_搜索旋转排序数组();
        System.out.println(a.search(new int[]{4,5,6,7,0,1,2},0));
    }
  /*  public int search2(int[] nums, int target) {
        int len = nums.length, left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[len - 1] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }*/




    public int search(int[] nums, int target) {
        int len = nums.length, left = 0, right=len-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            //判断mid在哪端
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && nums[mid] > target ){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[len-1] >= target && nums[mid] < target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
