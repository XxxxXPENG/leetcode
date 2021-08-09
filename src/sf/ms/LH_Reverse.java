package sf.ms;

public class LH_Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("Lodnon bridge is falling down"));
    }
    public static String reverse(String str){
        String res = "" , temp = "";
        for (int i = 0; i < str.length(); i++){
            temp += String.valueOf(str.charAt(i));
            if(String.valueOf(str.charAt(i)) == " "){
                res = temp + res;
            }
        }
        return res;
    }
}
