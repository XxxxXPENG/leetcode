package mid;

public class L4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        L4_寻找两个正序数组的中位数 a = new L4_寻找两个正序数组的中位数();
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(a.findMedianSortedArrays(arr1,arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1 + len2];
        for (int i = 0,j=0,k=0; i < res.length; i++) {
            if (j == len1) {
                res[i] = nums2[k++];
            }else if (k == len2) {
                res[i] = nums1[j++];
            } else if (nums1[j] < nums2[k]) {
                res[i] = nums1[j++];
            } else {
                res[i] = nums2[k++];
            }
        }
        int len = res.length;
        return len % 2== 1 ? res[len/2] : (res[len / 2] + res[len / 2 - 1]) / 2.0;
    }
}
