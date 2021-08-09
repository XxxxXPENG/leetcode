package sf.arr;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }
    public int[] getLeatNumbers2(int[] arr,int k){
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        //默认为小根堆  变为大根堆要改下
        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2 - v1);
        for(int num : arr){
            if(pq.size() < k){
                pq.offer(num);
            }else if(num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int index = 0;
        for (int num : pq) {
            res[index++] = num;
        }
        return res;
    }
}
