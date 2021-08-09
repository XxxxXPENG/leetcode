package math;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        if (x < 0) return false;
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }
}
