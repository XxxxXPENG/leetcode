package sf.String;

/**
 * 最长子串
 * eg：abcabcdbb   -->  abcd
 *     abc cbbacabcd
 */
public class MaxStr {
    public static void main(String[] args) {
        System.out.println(maxStr("abcabcdbb"));
    }
    public static int maxStr(String str){
        String res = "";
        int max = 0;
        for (int i = 0; i < str.length(); i++){
            if(!res.contains(String.valueOf(str.charAt(i)))){
                res += str.charAt(i);
            }else{
                res = String.valueOf(str.charAt(i));
            }
            max = res.length() > max ? res.length() : max;
        }
        return max;
    }
}
