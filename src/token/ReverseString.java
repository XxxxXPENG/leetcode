package token;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0,j = len - 1; i < j;){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] c = {'h','e','l','l','o'};
        reverseString(c);
        System.out.println(Arrays.toString(c));
    }
}
