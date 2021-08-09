package TestFIle;

import java.io.*;

public class FirstLine {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\LinXiaobo\\Desktop\\关于RabbitMQ的一些概念.md");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            String temp = null;
//            while((temp = reader.readLine()) != null){
//                System.out.println(temp);
//            }
            System.out.println(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
