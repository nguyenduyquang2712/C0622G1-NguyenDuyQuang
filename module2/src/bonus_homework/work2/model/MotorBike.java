package bonus_homework.work2.model;

public class MotorBike extends Vehicle {
    private double congSuat;
    public MotorBike(){

    }

    public MotorBike(double congSuat) {
        this.congSuat = congSuat;
    }

    public MotorBike(String bienKiemSoat, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu, double congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "congSuat=" + congSuat +
                super.toString()+
                '}';
    }
}
