package week.wk5;

import java.util.Arrays;

public class L6010_完成旅途的最少时间 {

    public static void main(String[] args) {
        L6010_完成旅途的最少时间 a = new L6010_完成旅途的最少时间();
        System.out.println(a.minimumTime(new int[]{1,2,3},5));
    }

    public long minimumTime2(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 0, right = (long) time[0] * totalTrips;
        while (left < right) {
            //总共花费的时间
            long mid = left + (right - left) / 2;
            long trip = 0;
            for (int t : time) {
                if (mid < t) {
                    break;
                }
                //计算跑完的轮次
                trip += mid / t;
            }
            if (trip >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }




        public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long minTime = 1;
        while (totalTrips > 0) {
            totalTrips = getSum(time, minTime, totalTrips);
            minTime++;
        }
        return minTime-1;
    }

    public int getSum(int[] time, long i,int res) {
        for (int t : time) {
            if (i % t == 0 && i / t > 0) {
                res --;
            }
        }
        return res;
    }
}
