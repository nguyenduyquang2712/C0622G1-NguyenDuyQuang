package ss19_string_regex.practices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ExampleTime {
    private static LocalDate dateNow = LocalDate.now();
    public void leak(int a){

    }
    public static String leak(){
        return "";
    }
    public static void main(String[] args) {
        Map<String,Integer> stringIntegerMap = new LinkedHashMap<>();
        System.out.println(stringIntegerMap.keySet());
//        stringIntegerMap.put("Quang",2);
//        stringIntegerMap.put("Long",2);
//        stringIntegerMap.put("Quang",stringIntegerMap.get("Quang")+2);
//        Set<String> strings = stringIntegerMap.keySet();
//        for(String string:strings){
//            System.out.println(string+" "+stringIntegerMap.get(string));
//        }
//        LocalDate date ;
//        date = LocalDate.parse("11/09/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        System.out.println(dateNow.getMonth().equals(date.getMonth()));
        StringBuffer str = new StringBuffer();
        String str2 = "er";
        str2.toLowerCase();
        str.append("   Huy ngu vl              ");
        str.reverse();
        str.trimToSize();
        System.out.println(str);
        System.out.println(str2);
    }
}
