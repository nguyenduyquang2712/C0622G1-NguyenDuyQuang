package ss6_inheritance.bai_tap.cylinder_extend_circle.model;

public class Circle {
    private String color = "green";
    private double radius = 1;

    public Circle() {
    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color= " + this.getColor() + " , " +
                "radius=" + this.radius + " and Area= "+this.getArea()+
                '}';
    }
}
