package token;

public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s != null){
            String[] arr = s.split(" ");
            for (String str : arr) {
                sb.append(new StringBuffer(str).reverse()).append(" ");
            }
        }
        return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
