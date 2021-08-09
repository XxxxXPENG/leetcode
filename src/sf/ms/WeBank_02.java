package sf.ms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 需要给一个数组排序，每移动一个表示需要的代价。
 * 问最少，需要多少代价才能排好序
 */
public class WeBank_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in  );
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(least(arr));
        }
    }
    public   static int least(int[] arr){
        int res = 0;
        PriorityQueue<Integer> minPq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }) ;
        for (int i = 0; i < arr.length; i++) {
            minPq.add(arr[i]);
        }
        while(!minPq.isEmpty()){
            int cur = minPq.poll();
            int cur1 = minPq.poll();
            res += cur + cur1;
            minPq.add(cur+cur1);
        }
        return res;
    }
}
