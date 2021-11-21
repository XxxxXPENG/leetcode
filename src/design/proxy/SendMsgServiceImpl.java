package design.proxy;

public class SendMsgServiceImpl implements SendMsgService{

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
