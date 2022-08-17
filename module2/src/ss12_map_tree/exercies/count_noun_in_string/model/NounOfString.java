package ss12_map_tree.exercies.count_noun_in_string.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NounOfString {
    private static Map<String, Integer> map = new LinkedHashMap<>();

    public static String formString(String str) {
        String newString = str.trim();
        newString = newString.replaceAll("\\s+", " ");
        String[] temp = newString.split(" ");
        newString = "";
        for (int i = 0; i < temp.length; i++) {
            newString += temp[i].charAt(0) + temp[i].substring(1);
            if (i < temp.length - 1)
                newString += " ";
        }
        return newString;
    }

    public static void checkNounOfString(String string) {
        string = formString(string);
        String[] arrayString = string.toLowerCase().split(" ");
        for (String key : arrayString) {
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        System.out.println(map);

        Set<String> stringSet = map.keySet();
        System.out.println("\nDanh sách từ :");
        for (String key : stringSet) {
            System.out.printf("\nTừ '%s' xuất hiện: %d lần", key, map.get(key));
        }
    }
}
