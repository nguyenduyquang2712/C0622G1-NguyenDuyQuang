package bonus_homework.work2.model;

public class Truck extends Vehicle {
    private double trongTai;

    public Truck() {

    }

    public Truck(double trongTai) {
        this.trongTai = trongTai;
    }

    public Truck(String bienKiemSoat, HangSanXuat hangSanXuat, String namSanXuat, String chuSoHuu, double trongTai) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "trongTai=" + trongTai +
                super.toString()+
                '}';
    }
}
