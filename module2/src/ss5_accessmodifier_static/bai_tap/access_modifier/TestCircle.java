package ss5_accessmodifier_static.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("the radius of circle is: "+circle.getRadius());
        System.out.println("The area of circle is: "+circle.getArea());
    }
}
//Thay đổi Access modifier cho 2 phương thức getRadius() và getArea()
//public, protected , default chương trình chạy bình thường do đều cùng 1 package
//private chương trình báo lỗi do không thuộc cùng lớp