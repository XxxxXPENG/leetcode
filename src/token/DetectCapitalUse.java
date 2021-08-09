package token;

public class DetectCapitalUse {
    public static boolean detectCapitalUse(String word) {
        int A = 'A';
        int Z = 'Z';
        int a = 'a';
        int z = 'z';
        boolean flag1 = true, flag2 = true, flag3 = true;
        char[] arr = word.toCharArray();
        //全小写
        for (char c : arr) {
            if(c >= A && c <= Z){
                flag1 = false;
            }
        }
        for (char c : arr) {
            if(c >= a && c <= z){
                flag2 = false;
            }
        }
        if (arr[0] >= A && arr[0] <= Z ) {
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] >= A && arr[i] <= Z){
                    flag3 = false;
                }
            }
        }


        return flag1 || flag2 || flag3;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));
    }
}
