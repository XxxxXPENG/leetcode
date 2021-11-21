package design.proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        SendMsgService smsService = (SendMsgService) JdkProxyFactory.getProxy(new SendMsgServiceImpl());
        smsService.send("java");

    }
}
