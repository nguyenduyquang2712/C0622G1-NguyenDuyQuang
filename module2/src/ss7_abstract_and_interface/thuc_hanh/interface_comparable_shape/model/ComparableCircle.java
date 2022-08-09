package ss7_abstract_and_interface.thuc_hanh.interface_comparable_shape.model;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (super.getRadius() > o.getRadius()) return 1;
        else if (super.getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
