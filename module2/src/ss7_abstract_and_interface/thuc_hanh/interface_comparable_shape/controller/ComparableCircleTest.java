package ss7_abstract_and_interface.thuc_hanh.interface_comparable_shape.controller;


import ss7_abstract_and_interface.thuc_hanh.interface_comparable_shape.model.Circle;
import ss7_abstract_and_interface.thuc_hanh.interface_comparable_shape.model.ComparableCircle;

import java.util.Arrays;


public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Circle circle2 = new ComparableCircle(3);
        Circle circle = new ComparableCircle(3);
        System.out.println(((ComparableCircle) circle).compareTo((ComparableCircle) circle2));

    }
}
