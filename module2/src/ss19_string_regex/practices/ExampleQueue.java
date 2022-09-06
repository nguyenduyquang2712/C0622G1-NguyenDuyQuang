package ss19_string_regex.practices;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class ExampleQueue {

    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<>();
        Queue<String> stringQueue = new LinkedList<>();
        stringSet.add("Long");
        stringSet.add("Quang");
        stringSet.add("Nam");

        for (String str:stringSet){
            stringQueue.add(str);
        }
        stringSet.remove(stringQueue.poll());
        for(String string:stringSet){
            System.out.println(string);
        }
        for(String str: stringQueue){
            System.out.println(str);
        }
    }

}
