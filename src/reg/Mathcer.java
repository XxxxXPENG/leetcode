package reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mathcer {
    public static void main(String[] args) {
        System.out.println(f("ApplePay"));
//        System.out.println(f("employee"));
//        System.out.println(f("APPLEHHH"));
//        System.out.println();
    }
    public static String f(String name){
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(name);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,"_"+m.group());//匹配到之前的字符append
            System.out.println(m.group() + ","+sb.toString());//输出匹配到的值
        }
        return m.appendTail(sb).toString().toLowerCase();
    }
}
