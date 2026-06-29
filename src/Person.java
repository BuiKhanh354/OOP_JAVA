import java.util.Scanner;

public abstract class Person {

    private String hoTen;
    private String soDienThoai;


    public Person() {

    }

    public Person(String hoTen, String soDienThoai) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public abstract void nhapThongTin(Scanner sc);

    public abstract void hienThiThongTin();

    public String getHoTen() {return hoTen;}

    public String getSoDienThoai() {return soDienThoai;}

    public void setHoTen(String hoTen) {this.hoTen = hoTen;}

    public void setSoDienThoai(String soDienThoai) {this.soDienThoai = soDienThoai;}

}
