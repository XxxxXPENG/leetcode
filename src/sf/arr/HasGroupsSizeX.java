package sf.arr;

public class HasGroupsSizeX {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,4,3,2,1};
//        System.out.println(hasGroupsSizeX(arr));
    }

    public  boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length < 2){
            return false;
        }
        int[] count = new int[10000];
        for (int num : deck) {
            count[num]++;
        }
        int x = 0;
        for (int num : count){
            if(num > 0){
                x = gcd(x,num);
            }
            if(x==1){
                return false;
            }
        }
        return x >= 2;
    }

    private int gcd(int a,int b){
        return b == 0 ? a: gcd(b,a % b);
    }
}

