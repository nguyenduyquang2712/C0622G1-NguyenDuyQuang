package ss4_class_and_object.bai_tap.fan_class;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setON(true);
        fan1.setColor("yellow");
        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setON(false);
        fan2.setColor("blue");
        System.out.println("Fan1 "+fan1.toString());
        System.out.println("Fan2 "+fan2.toString());

    }
}
