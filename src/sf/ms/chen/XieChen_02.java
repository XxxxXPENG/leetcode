package sf.ms.chen;

import java.util.Arrays;

public class XieChen_02 {
    /**
     * 给定一个字符串"1 2 11 8 9 "，是否有2个数相加第三个数？
     */
    public static void main(String[] args) {
        System.out.println(hasEquals("1 2 11 8 9"));
//        System.out.println(hasEquals("1 3 5 7 9"));
    }

    public static boolean hasEquals(String s){
        String[] arr = s.split(" ");
        int[] nums  = new int[arr.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        for(int k = 2; k < nums.length; k++){
            for(int i = 0,j = 1; i < k - 1; i++){
                int sum = nums[i] + nums[j];
                if(sum == nums[k]){
                    return true;
                }else if(sum < nums[k]){
                    j++;
                    if(j >= k ){
                        j = 0;
                    }else{
                        i--;
                    }
                }
            }

        }
        return false;
    }

//    public static boolean isRemain(String s){
//        String[] arr = s.split(" ");
//        int[] nums = new int[arr.length];
//        for(int i = 0; i < arr.length; i++){
//            nums[i] = Integer.parseInt(arr[i]);
//        }
//        Arrays.sort(nums);// 1 2 8 9 11
//        int len = nums.length;
//        if(len < 2) return false;
//        /* *
//         * 1. i j k 有可能重复
//         * 2. i j 相加 < k ，那么又不能左移，直接false
//         */
//        for(int i = 0, j = 1, k = 2; i < len;i++){
//            int sum = nums[i] + nums[j];
//            if(sum == nums[k]){
//                return true;
//            }else if(sum > nums[k] && i > 0){// k->
//                    k++;
//                    i--;
//            }else if(sum < nums[k] && i > 0) {// j->  , ij 都是最小的数时还小
//                j++;
//                i--;
//            }
//        }
//        return false;
//    }
}
