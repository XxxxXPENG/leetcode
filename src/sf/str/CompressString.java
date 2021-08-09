package sf.str;

public class CompressString {
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(compressString(s));
    }
    public static String compressString(String S) {
        char pre = S.charAt(0);
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < S.length(); i++){
            if(S.charAt(i) == pre){
                count++;
            }else{
                res.append(String.valueOf(pre) + count) ;
                count = 1;
            }
            pre = S.charAt(i);
        }
        return res + String.valueOf(pre) + count;
    }
}
