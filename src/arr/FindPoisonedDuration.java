package arr;

public class FindPoisonedDuration {
    // 1 3 ,2  =4
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0){
            return 0;
        }
        int sum = timeSeries[timeSeries.length - 1];
        for (int i = timeSeries.length - 1 ; i > 0; i--) {
            if(timeSeries[i] - duration < timeSeries[i+1]){
                sum += timeSeries[i+1] - timeSeries[i];
            }else{
                sum += duration;
            }
        }
        return sum;
    }


}
