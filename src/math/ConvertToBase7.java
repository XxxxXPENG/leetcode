package math;

public class ConvertToBase7 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(7));
        System.out.println(convertToBase7(-7));
    }

    public static String convertToBase7(int num) {
        boolean flag = num > 0;
        StringBuilder res = new StringBuilder();
        num = Math.abs(num);
        while (num >= 7) {
            res.append(num % 7);
            num /= 7;
        }
        res.append(num);
        return flag ? res.reverse().toString() : "-" + res.reverse().toString();
    }
}
