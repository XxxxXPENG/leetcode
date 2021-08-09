package ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class U {
    public static List<List<String>> u(List<List<String>> list) {
        list.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        List<String> pre = list.get(0);
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String endTime = pre.get(1);
            List<String> nowList = list.get(i);
            if (nowList.get(0).compareTo(endTime) < 0) {
//                res.add();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("23:00", "23:50"));
        list.add(Arrays.asList("00:00", "01:00"));
        list.add(Arrays.asList("00:30","01:20"));
        list.add(Arrays.asList("03:00","03:20"));
        list.add(Arrays.asList("03:20","03:40"));
        System.out.println(u(list));

    }
}
