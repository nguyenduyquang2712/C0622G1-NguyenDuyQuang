package ss6_inheritance.bai_tap.cylinder_extend_circle.controller;

import ss6_inheritance.bai_tap.cylinder_extend_circle.model.Cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(7);
        System.out.println(cylinder);
        cylinder = new Cylinder("Red",4,7);
        System.out.println(cylinder);
    }
}
