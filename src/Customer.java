import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person implements Searchable, Valuable {
    private String maKH;
    private CustomerType loaiKH;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer(String maKH, String hoTen, String soDienThoai, CustomerType loaiKH) {

        super(hoTen, soDienThoai);
        this.maKH = maKH;
        this.loaiKH = loaiKH;
    }

    public Customer() {}

    public CustomerType getLoaiKH(){
        return loaiKH;
    }

    public String getMaKH() {
        return maKH;
    }


    public void setMaKH(String maKH){
        this.maKH = maKH;
    }

    public void setLoaiKH(CustomerType loaiKH){
        this.loaiKH = loaiKH;
    }

    @Override
    public void nhapThongTin(Scanner sc) {

        int yes;
        do {

            System.out.print("Mã khách hàng: ");
            String maKH = sc.nextLine();

            System.out.print("Ten khach hang: ");
            String hoTen = sc.nextLine();

            System.out.print("Số điện thoại:");
            String soDienThoai = sc.nextLine();

            System.out.println("Loai khach hang");
            CustomerType loaiKH = CustomerType.valueOf(sc.nextLine());

            System.out.print("Đã thêm khách hàng");
            customers.add(new Customer(maKH, hoTen, soDienThoai, loaiKH));

            System.out.print("Bạn có nhập tiếp không? (1: Tiếp - 0: Thoát): ");
            yes = Integer.parseInt(sc.nextLine());

        } while(yes == 1);
    }

//    public void hienThiThongTin() {
//        Utils.danhSachThongTin(customers);
//    }

    public Customer chonKhachHangChoHoaDon(Scanner sc) {

        if (customers.isEmpty()) {
            System.out.println("Chưa có khách hàng!");
            return null;
        }

        System.out.print("Nhập mã khách hàng: ");
        String ma = sc.nextLine();

        for (Customer kh : customers) {
            if (kh.getMaKH().equalsIgnoreCase(ma)) {
                return kh;
            }
        }

        System.out.println("Không tìm thấy khách hàng!");
        return null;
    }
    public double getTyLeGiamGia() {
        return loaiKH.getDiscount();
    }

    @Override
    public double getValue() {
        return loaiKH.getDiscount();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("============ DANH SÁCH KHÁCH HÀNG ============");
        if (customers == null || customers.isEmpty()) {
            System.out.println("Chưa có khach hang!!!");
            return;
        }
        for (Customer list : customers) {
            System.out.println(list);
        }
        System.out.println("==========================================");

    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void timKiem(Scanner sc){

        System.out.print("Nhập từ khóa: ");
        String key = sc.nextLine();

        ArrayList<Customer> ketQua =
                Utils.timKiem(customers, key);

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            for (Customer kh : ketQua) {
                System.out.println(kh);
            }
        }
    }

    @Override
    public String getSearchKey() {
        return getMaKH() + " " + getHoTen() + " " + getSoDienThoai()+ " " + getLoaiKH();
    }

    @Override
    public String toString() {
        return getMaKH() + " - " + getHoTen() + " - " + getSoDienThoai() + " - " + getLoaiKH();
    }
}