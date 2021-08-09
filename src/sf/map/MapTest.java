package sf.map;

import java.util.HashMap;
import java.util.Map;

/**
 * hashmap 集合遍历
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("xx",1);
        map.put("lily",2);
        map.put("lxp",3);
       for(Map.Entry<String,Integer> entry : map.entrySet()){
           System.out.println(entry.getKey() + "," + entry.getValue());
       }
    }
}
