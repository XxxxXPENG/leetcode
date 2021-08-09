package sf.arr;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 要求： 连续 + 加起来 >= s + 要最小的长度
 * 思路： 如果小于s就先连续的加起来放到一个ArrayList中，就有了长度。
 *         如何判断最小 ?
 *         一、一次记录长度后存入一个temp的整数，后面从i+1的位置重新取长度比较
 *         二、找到最大的数，找到与其相邻大的数  （5 1 1 1 4 3）   ×
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15,arr));
    }


    public static int minSubArrayLen(int s, int[] nums) {
        boolean flag = false;
        int sum = 0, len = 0,min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
           for (int j = i; j < nums.length; j++){
               if(sum >= s){
                   flag = true;
                   min  = Math.min(min,len);
                   System.out.println(min);
                   //初始化
                   len = 0;
                   sum = 0;
               }
               sum += nums[i];
               len++;

//               if(sum < s ){
//                   sum += nums[j];
//                   len++;
//               }else{
//                   flag = true;
//                   min  = Math.min(min,len);
//                   System.out.println(min);
//                   //初始化
//                   len = 0;
//                   sum = 0;
//               }
           }
       }
        return flag ? min : 0;
    }
}
