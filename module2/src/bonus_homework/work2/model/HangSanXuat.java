package bonus_homework.work2.model;

public class HangSanXuat {
    private String maHangSanXuat;
    private String tenHangSanXuat;
    private String quocGia;

    public HangSanXuat(){

}
    public HangSanXuat(String maHangSanXuat, String tenHangSanXuat, String quocGia) {
        this.maHangSanXuat = maHangSanXuat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.quocGia = quocGia;
    }

    public String getMaHangSanXuat() {
        return maHangSanXuat;
    }

    public void setMaHangSanXuat(String maHangSanXuat) {
        this.maHangSanXuat = maHangSanXuat;
    }

    public String gettenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void settenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "HangSanXuat{" +
                "maHangSanXuat='" + maHangSanXuat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", quocGia='" + quocGia + '\'' +
                '}';
    }
}
