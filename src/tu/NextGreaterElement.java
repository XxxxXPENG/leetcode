package tu;


public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        System.out.println(n.nextGreaterElement(12));
    }


    public int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }
        char[] nums = (n + "").toCharArray();
        int len = nums.length;
        int left = len - 1;
        //找到第一个升序数
        while (left > 0 && nums[left - 1] >= nums[left]) {
            left--;
        }
        if (left == 0) {
            return -1;
        }

        int right = left;
        char tmp = nums[left - 1];
        while (right < len-1 && nums[right+1] >= tmp) {
            right++;
        }
        nums[left-1] = nums[right];
        nums[right] = tmp;
        right = len-1;
        while (left < right) {
            tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
        try {
            return Integer.valueOf(new String(nums));
        } catch (Exception e) {
            return -1;
        }
    }
}
