package mid;

public class GuessNumber {

    public static void main(String[] args) {
        GuessNumber g = new GuessNumber();
        System.out.println(g.guessNumber2(10));
    }

    private int ans = 6;

    public int guessNumber2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }



        public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                //答案在左区间[left..mid]
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    int guess(int num) {
        return Integer.compare(num, ans);
    }
}
