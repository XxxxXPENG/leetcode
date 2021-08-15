package tanxin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }

    //3 34 30 排序完应该是 3 34 30 ，但是String排序完却是 34 30 3
    //所以这个代码只A了180个 （总220个）
    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    //3 30  这2个排序问题
    // 330  , 303   因此3应该在前
    public static String largestNumber2(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort((x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        String res = sb.toString();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
