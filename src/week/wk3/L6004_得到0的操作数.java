package week.wk3;

public class L6004_得到0的操作数 {
    public static void main(String[] args) {
        L6004_得到0的操作数 a = new L6004_得到0的操作数();
        System.out.println(a.countOperations(20,20));
    }

    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            res++;
        }
        return res;
    }
}
