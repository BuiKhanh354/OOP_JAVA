import java.util.ArrayList;
import java.util.Scanner;

public class FoodManager implements Searchable, Valuable, Displayable{
    private String maMon;
    private String tenMon;
    private double gia;
    private String loaiMon;
    private int soLuong;

    private ArrayList<FoodManager> foodManagers = new ArrayList<>();


    public FoodManager(String maMon, String tenMon, double gia, String loaiMon, int soLuong) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.gia = gia;
        this.loaiMon = loaiMon;
        this.soLuong = soLuong;
    }

    public FoodManager() {}

    public double getGia() {
        return gia;
    }
    public String getMaMon() {
        return maMon;
    }
    public String getTenMon() {
        return tenMon;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public String getLoaiMon() {return loaiMon;}
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ArrayList<FoodManager> getFoodManagers() {
        return foodManagers;
    }

    public void nhapmonan(Scanner sc) {
        int yes;

        do {
            FoodManager f = new FoodManager();

            System.out.print("Mã món: ");
            f.setMaMon(sc.nextLine());

            System.out.print("Tên món: ");
            f.setTenMon(sc.nextLine());

            System.out.print("Giá: ");
            f.setGia(Double.parseDouble(sc.nextLine()));

            System.out.print("Loại món: ");
            f.setLoaiMon(sc.nextLine());

            System.out.print("Nhập số lượng: ");
            f.setSoLuong(Integer.parseInt(sc.nextLine()));

            foodManagers.add(f);

            System.out.println("✔ Đã thêm món ăn thành công!");

            System.out.print("Bạn có nhập tiếp món ăn? (1: Tiếp, 0: Thoát): ");
            yes = Integer.parseInt(sc.nextLine());

        } while (yes == 1);
    }

    public void timKiem(Scanner sc) {

        System.out.print("Nhập từ khóa: ");
        String key = sc.nextLine();

        ArrayList<FoodManager> ketQua =
                Utils.timKiem(foodManagers, key);

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            for (FoodManager ma : ketQua) {
                System.out.println(ma);
            }
        }
    }




    @Override
    public String toString() {
        return maMon + " - " + tenMon + " - " + gia + " - " + loaiMon;
    }

    public double thanhTien() {
        return gia * soLuong;
    }

    // Interface
    @Override
    public String hienThiDanhSach() {
        return toString();
    }

    @Override
    public double getValue() {
        return gia;
    }

    @Override
    public String getSearchKey() {
        return maMon + " " + tenMon + " " + gia + " " + soLuong;
    }

}