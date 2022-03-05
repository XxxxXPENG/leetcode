package hot100;

public class L4_寻找两个正序数组的中位数 {

    // O(n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int aStart = 0, bStart = 0;
        int pre = 0, cur = 0;
        for (int i = 0; i <= len / 2; i++) {
            pre = cur;
            // bStart >= m ，b数组越界 a还没越界时，a向后移
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                cur = nums1[aStart++];
            } else {
                cur = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (pre + cur) / 2.0;
        }
        return cur;
    }
}
