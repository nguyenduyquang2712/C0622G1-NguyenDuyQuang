package ss7_abstract_and_interface.bai_tap.interface_colorable_for_shape.controller;
import ss7_abstract_and_interface.bai_tap.interface_colorable_for_shape.model.shape.Circle;
import ss7_abstract_and_interface.bai_tap.interface_colorable_for_shape.model.shape.Rectangle;
import ss7_abstract_and_interface.bai_tap.interface_colorable_for_shape.model.shape.Shape;
import ss7_abstract_and_interface.bai_tap.interface_colorable_for_shape.model.shape.Square;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangle(3, 4);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
                System.out.println();
            }
            System.out.println();
        }

    }
}
