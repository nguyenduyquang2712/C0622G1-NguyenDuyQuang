package ss19_string_regex.practices;

import java.util.LinkedHashMap;
import java.util.Map;

public class Iterator {
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        java.util.Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<String, Integer> entry =  itr.next();
            System.out.println(entry.getKey()+" , "+entry.getValue());
        }
    }
}
