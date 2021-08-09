package Test.ArrayList_Test;


import java.util.ArrayList;
import java.util.Iterator;

public class Remove_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(5);
        System.out.println("first:"+list); //  [0, 1, 2, 3, 4, 5, 4, 4, 5]
//        System.out.println("after:"+remove(list));//before: [0, 1, 2, 3, 5, 4, 5]
        System.out.println("after:"+remove1(list));
    }

    /**
     * ArrayList用for循环遍历的方式删除,出现删除1个后跳跃1个在检查下一个。
     * eg :  1 2 2 3   --> 1 2 3
     * 因为，在list删除元素时，后面的元素就向前调整，补到了当前删除的位置。然后一次for结束会i++
     * 就相当于i++了2次。
     * 解决办法： 删除的时候 i--
     */
      /*
        使用这种最简单的删除，会出大问题！
        开始:  [0, 1, 2, 3, 4, 5, 4, 4, 5]
        before: [0, 1, 2, 3, 5, 4, 5]
        after: [0, 1, 2, 3, 5, 5]
     */
    public static ArrayList<Integer> remove(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
          //如果list是4就删除
          if(list.get(i) == 4) {
              list.remove(list.get(i));
//              i--;
          }
        }
        return list;
    }

    /**
     * 用iterator 迭代器的方式删除
     */
    public  static ArrayList<Integer> remove1(ArrayList<Integer> list){
            for (Iterator<Integer> ite = list.iterator(); ite.hasNext(); ) {
                if(4 == ite.next())
                    ite.remove();   //为啥这就可以删除干净？
            }
            return list;
    }

}
