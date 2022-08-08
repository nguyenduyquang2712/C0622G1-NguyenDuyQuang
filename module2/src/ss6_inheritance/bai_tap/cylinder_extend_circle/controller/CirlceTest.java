package ss6_inheritance.bai_tap.cylinder_extend_circle.controller;

import ss6_inheritance.bai_tap.cylinder_extend_circle.model.Circle;

public class CirlceTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle("Red",4);
        System.out.println(circle);
    }
}
