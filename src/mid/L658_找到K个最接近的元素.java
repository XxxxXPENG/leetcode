package mid;

import java.util.ArrayList;
import java.util.List;

public class L658_找到K个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int left = 0, right = n - k;
        while (left < right) {
            int mid = (left + right) >> 1;
            //左边元素更大
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;

    }
}
