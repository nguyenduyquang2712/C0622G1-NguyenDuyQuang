package ss5_accessmodifier_static.bai_tap.onlywrite;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alex");
        student.setClassName("CO6");
    }
}
//Thay đổi Access modifier cho 2 phương thức setName() và setClassName()
//public, protected , default chương trình chạy bình thường do đều cùng 1 package
//private chương trình báo lỗi do không thuộc cùng lớp