package sf.arr;

public class Test_DG {
    public static void main(String[] args) {
        System.out.println(sum(3));
    }

    public static int sum(int n){
        if(n == 1) return 1;
        else{
            return n * sum(n-1);
        }
    }
}
