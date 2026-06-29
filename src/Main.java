import java.util.Scanner;
import java.util.Arrays;
//import BAITAPLON.GUI.MainFrame;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodManager foods = new FoodManager();

        //test
        foods.getFoodManagers().addAll(Arrays.asList(
                new FoodManager("MON1", "Cơm chiên", 30000, "Cơm", 20),
                new FoodManager("MON2", "Hủ tiếu", 20000, "Hủ tiếu", 60),
                new FoodManager("MON3", "Bún", 40000, "Bún", 10)
        ));
        //

        Customer customers = new Customer();
        //test
        customers.getCustomers().addAll(Arrays.asList(
                new Customer("KH001", "Bui Viet Khánh", "123", CustomerType.GOLD),
                new Customer("KH002", "Bui Viet Khanh 2", "012345672", CustomerType.SILVER),
                new Customer("KH003", "Bui Viet Khanh 3", "012345676", CustomerType.NORMAL)
        ));
        //
        Order orders = new Order();
        Employee employees = new Employee();

        //test
        employees.getEmployees().addAll(Arrays.asList(
                new Employee("NV001", "TestNV", "012345678", "Quản Lí", 100000),
                new Employee("NV002", "Nhan Vien 2", "012345716", "Nhan Vien Ban Hang", 10000)
        ));
        //

        int choice;

//        javax.swing.SwingUtilities.invokeLater(() -> {
//            MainFrame frame = new MainFrame();
//            frame.setVisible(true);
//        });

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Thêm món ăn");
            System.out.println("2. Danh sách món ăn");
            System.out.println("3. Tìm món ăn");

            System.out.println("4. Thêm khách hàng");
            System.out.println("5. Danh sách khách hàng");
            System.out.println("6. Tìm khách hàng");

            System.out.println("7. Thêm nhân viên");
            System.out.println("8. Danh sách nhân viên");
            System.out.println("9. Tìm nhân viên");

            System.out.println("10. Tạo hóa đơn");
            System.out.println("11. Danh sách hóa đơn");

            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    foods.nhapmonan(sc);
                    break;

                case 2:

                    Utils.danhSachThongTin(foods.getFoodManagers());

                    break;

                case 3:
                    foods.timKiem(sc);
                    break;

                case 4:
                    customers.nhapThongTin(sc);
                    break;

                case 5:
                    customers.hienThiThongTin();
                    break;

                case 6:
                    customers.timKiem(sc);
                    break;

                case 7:
                    employees.nhapThongTin(sc);
                    break;

                case 8:
                    employees.hienThiThongTin();
                    break;
                case 9:
                    employees.sapXepLuongGiamDan();
                    Utils.danhSachThongTin(employees.getEmployees());
                    break;

                case 10:
                    orders.taoHoaDon(sc, foods.getFoodManagers(), customers);
//                    Utils.danhSachThongTin(orders.getOrders());
                    break;

                case 11:
                    Utils.danhSachThongTin(orders.getOrders());
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}