package ss10_dsa_list.practices.simple_list.model;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(3);
        Object list2;
        list2 = list.clone();
        System.out.println(list2);
    }
}
