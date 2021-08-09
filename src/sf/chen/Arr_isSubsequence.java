package sf.chen;

public class Arr_isSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t ="aghbsc";
//        System.out.println(s.length());
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        //如果一开始就在
        if(s.length() == 0) return true;
        int p1 = 0 , p2 = p1;
        while(p1 < s.length() && p2 < t.length()){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
            }else{
                p2++;
            }
    //正真结束的时候p1应该在s.length
            if(p1 == s.length()  ) {
                System.out.println(p1 +","+s.length());
                return true;
            }
        }
        return false;
    }
}
