package mid;

public class FirstBadVersion {
    int bad = 4;

    public static void main(String[] args) {
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (isBadVersion(mid)) {
                //在左区间
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
    private boolean isBadVersion(int mid) {
        return mid == bad;
    }
}
