package sf.ListNode.re;

public class Test {
    public static void main(String[] args) {
        new Test().setValue("1");
    }

    public void setValue(String aa){
        for (int i = 0; i < aa.length(); i++){
            if( !Character.isDigit(aa.charAt(i)))
                return;
        }
            int a = Integer.parseInt(aa);
            if(check(a)) {
                String s = "asdada" + a;
                System.out.println(s);
                bb(s);
            }
    }

    private void bb(String s) {
    }

    private boolean check(int a) {
        return a>0;
    }
}
