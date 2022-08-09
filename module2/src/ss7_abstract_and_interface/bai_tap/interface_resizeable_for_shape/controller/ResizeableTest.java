package ss7_abstract_and_interface.bai_tap.interface_resizeable_for_shape.controller;

import ss7_abstract_and_interface.bai_tap.interface_resizeable_for_shape.model.shape.Circle;
import ss7_abstract_and_interface.bai_tap.interface_resizeable_for_shape.model.shape.Rectangle;
import ss7_abstract_and_interface.bai_tap.interface_resizeable_for_shape.model.shape.Shape;
import ss7_abstract_and_interface.bai_tap.interface_resizeable_for_shape.model.shape.Square;


public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(10);
        for (Shape shape : shapes) {
            shape.resize(50);
        }
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println();
        }
    }
}
