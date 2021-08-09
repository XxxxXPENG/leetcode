package math;

public class ReverseBits {
    public static void main(String[] args) {

        int n = 3;
        System.out.println(n & 1);
    }

    public static int reverseBits(int n) {
        long res = 0; // 这里用long或者unsigned int均可，建议对数据溢出留个心眼
        for (int i = 0; i < 32; i++) { // 这一步和LC7——整数翻转的思路相同
            // 这里使用for循环而不是while，原因是本题要求32位整数，位数是固定的！
            res = res * 2 + n % 2; // 10进制乘上10，模10；二进制改成2即可
            n = n / 2; // 从十进制的10改成2即可
        }
        return (int) res; // 返回结果

    }
}
