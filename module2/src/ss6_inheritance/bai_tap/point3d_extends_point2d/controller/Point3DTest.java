package ss6_inheritance.bai_tap.point3d_extends_point2d.controller;

import ss6_inheritance.bai_tap.point3d_extends_point2d.model.Point3D;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        point3D.setZ(4);
        System.out.println(point3D);
        point3D = new Point3D(2,3,4);
        System.out.println(point3D);
    }
}
