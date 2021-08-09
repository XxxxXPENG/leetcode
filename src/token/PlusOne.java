package token;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

//    public static int[] plusOne(int[] digits) {
//        for (int i = digits.length - 1; i >= 0; i--) {
//            if (i == 0 && digits[i] + 1 > 9) {
//                digits = new int[digits.length + 1];
//                digits[0] = 1;
//                return digits;
//            } else if (digits[i] + 1 < 10) {
//                digits[i] = digits[i] + 1;
//                return digits;
//            } else {
//                digits[i] = 0;
//            }
//        }
//        return digits;
//    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if(digits[i] < 10){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
