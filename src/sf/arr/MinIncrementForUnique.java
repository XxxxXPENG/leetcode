package sf.arr;

public class MinIncrementForUnique {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        minIncrementForUnique(arr);
    }

    public static int minIncrementForUnique(int[] A) {
        int[] count = new int[8000];
        for (int x : A) {
            count[x]++;
        }
        int ans = 0, taken = 0;
        for (int x = 0 ; x < 8000; x++){
            if(count[x] >=2 ){
                taken += (count[x] - 1);
                ans -= x*(count[x] - 1);
            }else if(taken >= 0 && count[x] == 0){
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}
