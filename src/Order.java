import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order implements Valuable, Displayable{

    private Customer customer;
    private String maDon;
    //    private Food food;
    private int soLuongMua;
    private double tongTien;
    private LocalDate ngayMua;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Integer> dsSoLuong = new ArrayList<>();
    private ArrayList<FoodManager> dsMon = new ArrayList<>();


    public Order(Customer customer, String maDon, int soLuongMua, double tongTien,LocalDate ngayMua) {
        this.customer = customer;
        this.maDon = maDon;
        this.tongTien = tongTien;
//        this.food = food;
        this.soLuongMua = soLuongMua;
        this.ngayMua = ngayMua;
    }

    public Order() {}

    public String getMaDon(){
        return maDon;
    }
    public int getSoLuongMua(){
        return soLuongMua;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public void setMaDon(String maDon){
        this.maDon = maDon;
    }
    public void setSoLuongMua(int soLuongMua){
        this.soLuongMua = soLuongMua;
    }

    public void taoHoaDon(Scanner sc, ArrayList<FoodManager> dsFoodManager, Customer quanLyKH) {

        Order hd = new Order();

        System.out.println("\n===== TẠO HÓA ĐƠN =====");

        System.out.print("Mã hóa đơn: ");
        hd.maDon = sc.nextLine();

        hd.customer = quanLyKH.chonKhachHangChoHoaDon(sc);
        if (hd.customer == null) {
            System.out.println("Hủy tạo hóa đơn.");
            return;
        }

        hd.ngayMua = LocalDate.now();

        int tiepTuc = 0;

        do {

            System.out.print("Nhập ten món ăn: ");
            String tenMon = sc.nextLine();

            FoodManager selected = null;

            for (FoodManager f : dsFoodManager) {

                if (f.getTenMon().equalsIgnoreCase(tenMon)) {

                    selected = f;
                    break;
                }
            }

            if (selected == null) {

                System.out.println("Không tìm thấy món ăn!");
                continue;
            }

            System.out.println("Tên món: "
                    + selected.getTenMon());

            System.out.println("Giá: "
                    + selected.getGia());

            System.out.print("Số lượng mua: ");
            int soLuong =
                    Integer.parseInt(sc.nextLine());

            double thanhTien =
                    selected.getGia() * soLuong;

            System.out.println(
                    "Thành tiền: "
                            + thanhTien);

            hd.themMon(selected, soLuong);

            System.out.print(
                    "Thêm món khác? (1:Có - 0:Không): ");

            tiepTuc = Integer.parseInt(sc.nextLine());

        } while (tiepTuc == 1);

        hd.tinhTongTien();

        orders.add(hd);

        System.out.println("Tổng tiền: " + hd.getTongTien());
        System.out.println("\nTạo hóa đơn thành công!");
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public double tinhTongTien() {

        double tong = 0;

        for (int i = 0; i < dsMon.size(); i++) {
            tong += dsMon.get(i).getGia() * dsSoLuong.get(i);
        }

        tongTien = tong;
        return tong;

    }

    public double tinhTongTienSauGiam(double tongTien) {

        return tongTien * (1 - customer.getTyLeGiamGia());
    }


    public void themMon(FoodManager mon, int soLuong){
        dsMon.add(mon);
        dsSoLuong.add(soLuong);
    }

    @Override
    public double getValue() {
        return tinhTongTien();
    }

    @Override
    public String hienThiDanhSach() {
        StringBuilder sb = new StringBuilder();

        sb.append("==============================\n");
        sb.append("MÃ HÓA ĐƠN: ").append(maDon).append("\n");
        sb.append("KHÁCH HÀNG: ").append(customer.getHoTen()).append("\n");
        sb.append("SĐT: ").append(customer.getSoDienThoai()).append("\n");
        sb.append("NGÀY MUA: ").append(ngayMua.format(formatter)).append("\n");
        sb.append("------------------------------\n");

        for (int i = 0; i < dsMon.size(); i++) {
            FoodManager mon = dsMon.get(i);
            int sl = dsSoLuong.get(i);
            double thanhTien = mon.getGia() * sl;

            sb.append(mon.getTenMon())
                    .append(" | Số lượng: ").append(sl)
                    .append(" | Giá: ").append(mon.getGia())
                    .append(" | Hạng thành viên: ").append(customer.getLoaiKH())
                    .append(" | Thành tiền : ").append(thanhTien)
                    .append("\n");
        }

        sb.append("------------------------------\n");
        sb.append("TỔNG TIỀN: ").append(tinhTongTienSauGiam(tinhTongTien())).append("\n");
        sb.append("==============================");

        return  toString();
    }


    //Hoàn thiện hoá đơn

    @Override
    public String toString() {
        return "======== HOÁ ĐƠN ======== " + "\n"
                + "MÃ HOÁ ĐƠN" + getMaDon();
    }


}