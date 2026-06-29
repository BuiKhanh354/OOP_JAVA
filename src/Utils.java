import java.util.ArrayList;

public class Utils {

//        public static <T extends Listable> void danhSach(ArrayList<T> ds)

    public static <T extends Searchable> ArrayList<T> timKiem(ArrayList<T> ds, String key) {

        ArrayList<T> ketQua = new ArrayList<>();

        for (T item : ds) {
            if(item.getSearchKey().toLowerCase().contains(key.toLowerCase())){
                ketQua.add(item);
            }
        }
        return ketQua;
    }

    public static <T extends Valuable> T timLonNhat(ArrayList<T> ds) {
        if(ds.isEmpty()) {
            return null;
        }
        T max = ds.get(0);

        for(T items : ds) {

            if(items.getValue() > max.getValue()) {
                max = items;
            }
        }
        return max;
    }

    public static <T extends Displayable> void danhSachThongTin(ArrayList<T> ds) {

//        ArrayList<T> ketQuaDanhSach = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        System.out.println("============ DANH SÁCH ============\n");
        if(ds == null || ds.isEmpty()) {
            System.out.println("Danh sách trống!!!!");
            return;

        }

        for (T items : ds) {
            sb.append(items.hienThiDanhSach()).append("\n");
        }

        System.out.println(sb);

        System.out.println("==================================");
    }
}