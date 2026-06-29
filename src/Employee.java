//import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Employee extends Person implements Valuable, Displayable {

    private String maNV;
    private String chucVu;
    private long luong;

    private ArrayList<Employee> employees = new ArrayList<>();

    public Employee(){}

    public Employee(String maNV, String hoTen, String soDienThoai, String chucVu, long luong) {

        super(hoTen, soDienThoai);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getMaNV(){
        return maNV;
    }
    public String getChucVu(){
        return chucVu;
    }
    public double getLuong(){
        return luong;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public void setChucVu(String chucVu){
        this.chucVu = chucVu;
    }
    public void setLuong(long luong){
        this.luong = luong;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void nhapThongTin(Scanner sc){

        int yes;
        do {

            Employee nv = new Employee();

            System.out.print("Mã nhân viên: ");
            nv.setMaNV(sc.nextLine());

            System.out.print("Họ tên: ");
            nv.setHoTen(sc.nextLine());

            System.out.print("Số điện thoại: ");
            nv.setSoDienThoai(sc.nextLine());

            System.out.print("Chức vụ: ");
            nv.setChucVu(sc.nextLine());

            System.out.print("Lương: ");
            nv.setLuong(sc.nextLong());

            sc.nextLine();

//        employees.add(new Employee(maNV, hoTen, soDienThoai, chucVu, luong));
            employees.add(nv);
            System.out.println("Đã thêm nhân viên thành công!");
            System.out.print("Bạn có nhập tiếp không? (1: Tiếp, 0: Thoát): ");
            yes = Integer.parseInt(sc.nextLine());
        }while(yes == 1);
    }

    @Override
    public void hienThiThongTin() {
        Utils.danhSachThongTin(employees);
    }

    @Override
    public String hienThiDanhSach() {
        return toString();
    }

    @Override
    public double getValue() {
        return luong;
    }

    @Override
    public String toString() {
        return maNV + " - " + getHoTen() +  " - " + getSoDienThoai() +" - " + chucVu + " - " + luong;
    }

    public void sapXepLuongGiamDan() {

        employees.sort((e1, e2) ->
                Double.compare(e2.getLuong(), e1.getLuong()));

        System.out.println("Đã sắp xếp lương giảm dần!");
    }

    public void nhanVienLuongCaoNhat() {


        Employee max = Utils.timLonNhat(employees);

        if (max != null) {
            System.out.println("Nhân viên lương cao nhất: ");
            System.out.println(max);
        }

    }
}
