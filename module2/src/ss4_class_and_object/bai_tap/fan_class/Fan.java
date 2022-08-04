package ss4_class_and_object.bai_tap.fan_class;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean isON = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getIsON() {
        return this.isON;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setON(boolean ON) {
        isON = ON;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isON) {
            return "Fan{" +
                    " speed=" + this.getSpeed() +
                    ", radius=" + this.getRadius() +
                    ", color='" + this.color + '\'' +
                    ",fan is on" +
                    '}';
        }
        return "Fan{" +
                " radius=" + this.getRadius() +
                ", color='" + this.getColor()+ '\'' +
                ",fan is off" +
                '}';
    }
}
