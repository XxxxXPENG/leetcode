package stack;

import java.util.ArrayList;
import java.util.List;

public class CalPoints {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    public static int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (String str : ops) {
            int index = list.size() - 1;
            switch (str) {
                case "C":
                    list.remove(index);
                    break;
                case "D":
                    list.add(list.get(index) * 2);
                    break;
                case "+":
                    list.add(list.get(index) + list.get(index - 1));
                    break;
                default:
                    list.add(Integer.parseInt(str));
                    break;
            }
        }
        return list.stream().mapToInt(num -> num).sum();
    }


}
