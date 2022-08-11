package ss10_dsa_list.practices.simple_list.controller;

import ss10_dsa_list.practices.simple_list.model.MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(5);
        list.remove(2);
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();
        System.out.println(list.indexOf(5));
    }
}
