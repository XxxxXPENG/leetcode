package sf.ms.chen;

public class Zj {
    /**
     * a [1,1,2,3]
     * b [1,1,0,1]
     * a [2,3] - 2    --> b
     * @param a
     * @param b
     * @return
     */
    public static boolean a(int[] a,int[] b){
        int d = 0 , time = 0,temp = 0; //两数之差
        for (int i = 0; i < a.length  ;i++){
           if(a[i] != b[i] && time == 0){
                 temp = a[i] - b[i] ;
                for (int k = i; k < a.length;k++){
                    if(temp != a[k] - b[k]){
                        break;
                    }
                    i = k;
                }
                time = 1;
            }
           if(temp != a[i] - b[i])
               return false;
        }
        return true;

    }

    public static void main(String[] args) {
//        int[] a = {1,1,1,4,5};
//        int[] b = {1,1,0,3,4};

        int[] a = {3,7,1,4,1,2};
        int[] b = {3,7,3,6,3,2};
        System.out.println(a(a,b));
    }
}
