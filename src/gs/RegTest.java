package gs;

public class RegTest {
    /**
     * 正则表达式:    .*X.*可以将X前后的值进行处理
     * @param args
     */
    public static void main(String[] args) {
        String message = "message \n OOOX \nlxp";
        message = message.replaceAll(".*X.*"," ")
                .replaceAll("[br]{0,}","")
                .replaceAll("(?m)^\\s*$(\\n|\\r\\n)"," ");
//        System.out.println(message.replaceAll());
        System.out.println(message);
//        JSONOject
    }

}
