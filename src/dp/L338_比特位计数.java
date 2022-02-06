package dp;

import java.util.Arrays;

public class L338_比特位计数 {
    public static void main(String[] args) {
        L338_比特位计数 a = new L338_比特位计数();
        System.out.println(Arrays.toString(a.countBits(2)));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
