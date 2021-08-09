package k;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {

        System.out.println(findKthLargest3(new int[]{3,2,1,5,6,4},2));
    }

    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums.length - k;
    }
    public static int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

    public static int findKthLargest3(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize/2; i >= 0 ; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /**
     * 堆结构化
     *
     * @param nums 维护的数组
     * @param i 非叶子节点下标
     * @param heapSize 数组长度
     */
    private static void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, largest, i);
            //递归维护之前构造的大根堆
            maxHeapify(nums, largest, heapSize);
        }
    }



}
