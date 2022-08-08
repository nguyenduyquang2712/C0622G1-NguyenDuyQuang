package ss6_inheritance.bai_tap.cylinder_extend_circle.model;

import ss6_inheritance.bai_tap.cylinder_extend_circle.model.Circle;

public class Cylinder extends Circle {
    private double height = 1;

    public Cylinder() {

    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + this.getHeight() +
                " Volume=" + this.getVolume()+
                '}'+", which is a subclass of "+
                super.toString();
    }
}
