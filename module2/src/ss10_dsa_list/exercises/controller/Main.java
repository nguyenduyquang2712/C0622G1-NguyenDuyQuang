package ss10_dsa_list.exercises.controller;

import ss10_dsa_list.exercises.model.Mylist;


public class Main {
    public static void main(String[] args) {
        Mylist<Integer> list = new Mylist<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(5);
        list.remove(2);
        for (int i = 0; i < list.getSize() ; i++) {
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();
        System.out.println(list.indexOf(5));

    }
}
