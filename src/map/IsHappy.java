package map;

public class IsHappy {
    public boolean isHappy(int n) {
        int slow = n, fast = square(n);
        while (slow != fast) {
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow == 1;
    }

    public int square(int num) {
        int sum = 0;
        while (num > 0) {
            int a = num % 10;
            sum += a * a;
            num /= 10;
        }
        return sum;
    }

}
