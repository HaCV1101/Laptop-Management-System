import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.*;
import java.util.GregorianCalendar;

public class initDB {
    static String[] firstPhoneNumber = {"086", "096", "097", "098", "032", "033", "034", "035", "036", "037","038", "039",
                            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037","038", "039",
                            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037","038", "039",
                            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037","038", "039",
                            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037","038", "039",
                            "088", "091", "094", "083", "084", "085", "081", "082", "089", "090", "093", "070",
                            "079", "077", "076", "078", "092", "056", "058"};
    static String[] ho = {"Nguyen", "Nguyen", "Nguyen", "Nguyen", "Nguyen", "Nguyen", "Tran", "Tran", "Tran", 
                "Tran", "Le", "Le", "Le", "Pham", "Pham", "Pham", "Hoang", "Huynh", "Phan", "Vu", "Vo", 
                "Dang", "Bui", "Do", "Ho", "Ngo", "Duong", "Ly", "Trinh", "Dinh"};
    static String[] tenNam = {"Dung", "Minh", "Kien", "Thanh", "Khoa", "Thang", "Tai", "Trung", "Huy", "Dang", 
                    "Hoang", "Dat", "Cuong", "Phi", "Viet", "Van", "Phuoc", "Vi", "Hung", "Quang", "Quan",
                    "Son", "Duy", "Cong", "Tung", "Manh", "Khanh", "Hung", "Trung", "Khai", "Khoi", "An",
                    "Tuan", "Nam", "Bao", "Giang", "Nhan", "Phuc", "Vinh", "Hieu", "Toan", "Truong", "Duc",
                    "Thien", "Thai", "Quoc", "Trong", "Khiem", "Hau"};
    static String[] demNam = {"Viet", "Tuan", "Truong", "Trung", "Anh", "Chi", "Dang", "Huu", "Hung", "Hoang", 
                    "Manh", "Huu", "Duc", "Minh", "Toan", "Thanh", "Thai", "Gia", "Quoc", "The", "Hong", 
                    "Trong", "Thien", "Duc", "Tai", "Phi", "Van", "Quang", "Duy", "Cong"};
    static String[] tenNu = {"Vy", "Tuong", "Han", "An", "Ngoc", "Ngan", "Chi", "Khue", "Ha", "Thuy", "Ngoc", 
                    "Chau", "Ngan", "Nhung", "Nhi", "Khanh", "Diep", "Anh", "Nhien", "Linh", "Thuong", 
                    "Binh", "Thao", "Diem", "Trang", "Tam", "Thuy", "Trinh", "Phuong", "Mai", "Chi", "Dung",
                    "Huong", "Le", "Tien", "Thu", "Tu", "Quyen", "Lien", "Chau", "My", "Kieu", "Thanh",
                    "Oanh", "Quynh", "Duyen", "Bich", "Hoa", "Diep", "Mai", "Tram", "Minh", "Anh", "Chi",
                    "Huong", "Nhi", "Linh", "Nguyet", "Van", "Trang", "Nhu", "Nga", "Uyen", "Lan", "Tuyet"};
    static String[] demNu = {"Thi", "Thi Ngoc", "Thi Phuong", "Thi Huong", "Thi Quynh", "Thanh", "Thu", "Diem",
                    "Ngoc", "Thuy", "Diem", "Quynh", "Diep", "Kieu", "Khanh", "Huong", "Bich", "Lien", "Kim", 
                    "Tuyet"};


    static final int NUMBER_OF_CUSTOMERS = 1100302;
    static final int NUMBER_OF_STORES = 503;
    static final int NUMBER_OF_LAPTOPS_DETAIL = NUMBER_OF_CUSTOMERS * 3/2;
    static final int NUMBER_OF_IMPORT_BILLS = NUMBER_OF_LAPTOPS_DETAIL/400;
    static final int NUMBER_OF_IMPORT_BILLS_DETAIL = NUMBER_OF_LAPTOPS_DETAIL;
    static final int NUMBER_OF_EXPORT_BILLS = NUMBER_OF_CUSTOMERS * 2/3;
    static final int NUMBER_OF_EMPLOYEES = NUMBER_OF_STORES * 4;
    static final int NUMBER_OF_SUPPLIER = 20;
    static final int NUMBER_OF_CARTS = NUMBER_OF_CUSTOMERS / 100;
    static final int NUMBER_OF_CARTS_DETAIL = NUMBER_OF_CARTS * 2;
    static int NUMBER_OF_LAPTOPS = 0;

    static String[] laptopBranchs = {"Lenovo", "MacBook", "ASUS", "HP", "ACER", "DELL", "MSI", "LG", "GIGABYTE",
                    "Intel", "Itel", "Surface", "Chuwi", "Avita", "Fujitsu"};
    static String[] laptopSeries = {"A", "Ultra", "S", "X", "VM", "Pro", "Ultimate"};
    static String[] laptopColor = {"Bac", "Den", "Vang", "Xanh"};
    static int[] laptopStorage = {256, 512, 1024, 2048};
    static int[] laptopPrice = new int[NUMBER_OF_LAPTOPS_DETAIL + 10];
    static int[] price = new int[NUMBER_OF_LAPTOPS_DETAIL + 10];
    static int[] laptopStatus = new int[NUMBER_OF_LAPTOPS_DETAIL + 10];

    static String[] importDate = new String[NUMBER_OF_IMPORT_BILLS + 10];
    static String[] exportDate = new String[NUMBER_OF_EXPORT_BILLS + 10];

    static String[] diaChi = new String[11000];
    static String[] tinh = new String[11000];
    static String[] huyen = new String[11000];
    static String[] xa = new String[11000];
    static int cntDiaChi = 0;




    static long seed = 1003, modules = ((long) 1<<31) - 1, mul = 48271, inc = 0;
    static int rand(int base) {
        seed = (seed * mul + inc) % modules;
        return (int) (seed % base);
    }
    static int randBetween(int l, int r) {
        return l + rand(r - l + 1);
    }

    static Connection conn = null;
    static String url = "jdbc:mysql://localhost:3306/DatabaseLab";
    static String user = "root";
    static String password = "";


    static String randomDate(int l, int r) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(l, r);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return (gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
    }
    







    
    static void dropAllTables() {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS CHI_TIET_HOA_DON_NHAP");
            st.executeUpdate("DROP TABLE IF EXISTS HOA_DON_NHAP");
            st.executeUpdate("DROP TABLE IF EXISTS CHI_TIET_HOA_DON_XUAT");
            st.executeUpdate("DROP TABLE IF EXISTS HOA_DON_XUAT");
            st.executeUpdate("DROP TABLE IF EXISTS CHI_TIET_GIO_HANG");
            st.executeUpdate("DROP TABLE IF EXISTS GIO_HANG");
            st.executeUpdate("DROP table IF EXISTS CHI_TIET_LAPTOP");
            st.executeUpdate("DROP table IF EXISTS LAPTOP");
            st.executeUpdate("DROP TABLE IF EXISTS NHAN_VIEN");
            st.executeUpdate("DROP TABLE IF EXISTS CUA_HANG");
            st.executeUpdate("DROP TABLE IF EXISTS KHACH_HANG");
            st.executeUpdate("DROP TABLE IF EXISTS NHA_CUNG_CAP");
            st.executeUpdate("DROP TABLE IF EXISTS NHA_SAN_XUAT");
            System.out.println("Dropped all tables");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    









    static void createKhachHang() {
        String name[] = new String[NUMBER_OF_CUSTOMERS + 10];
        String email[] = new String[NUMBER_OF_CUSTOMERS + 10];
        String phone[] = new String[NUMBER_OF_CUSTOMERS + 10];
        String IdKhachHang[] = new String[NUMBER_OF_CUSTOMERS + 10];
        String diaChiKH[] = new String[NUMBER_OF_CUSTOMERS + 10];


        System.out.println("Creating table KHACH_HANG");
        for (int i=0; i<NUMBER_OF_CUSTOMERS; i++) {
            int bool = rand(5), bool2 = rand(2);
            String firstName = "", middleName = "", lastName = "", second = "";
            if (bool < 3) {
                do {
                    firstName = ho[rand(ho.length)];
                    middleName = demNam[rand(demNam.length)];
                    lastName = tenNam[rand(tenNam.length)];
                } while (firstName == middleName || middleName == lastName);
                name[i] = firstName + ' ' + middleName + ' ' + lastName;
            } 
            else {
                do {
                    firstName = ho[rand(ho.length)];
                    middleName = demNu[rand(demNu.length)];
                    if ( !middleName.contains(" ") && rand(4) == 0 ) {
                        second = " " + ho[rand(ho.length)] + " ";
                    } else second = " ";
                    lastName = tenNu[rand(tenNu.length)];
                } while (firstName == middleName || firstName == second || middleName == lastName);
                name[i] = firstName + second + middleName + ' ' + lastName;
            }
            

            switch (bool2) {
                case 0: 
                    email[i] = lastName.toLowerCase() + (rand(2) == 0 ? "." : "" ) + 
                    (rand(2) == 0 ? firstName.toLowerCase() : firstName.toLowerCase().charAt(0) ) +
                    (rand(2) == 0 ? middleName.replaceAll("\\s+","").toLowerCase() : middleName.toLowerCase().charAt(0) ) + 
                    (rand(4) == 0 ? "." : "" ) + 
                    rand(1000000) +
                    (rand(10) < 9 ? "@gmail.com" : "@outlook.com");
                    break;
                case 1:
                    email[i] = "" + (rand(2) == 0 ? firstName.toLowerCase() : firstName.toLowerCase().charAt(0) ) +
                    (rand(2) == 0 ? middleName.toLowerCase().replaceAll("\\s+","") : middleName.toLowerCase().charAt(0) ) + 
                    lastName.toLowerCase() +
                    (rand(4) == 0 ? "." : "" ) + 
                    rand(1000000) +
                    (rand(10) < 9 ? "@gmail.com" : "@outlook.com");
                    break;
            }

            phone[i] = firstPhoneNumber[rand(firstPhoneNumber.length)] + (rand(9000000) + 1000000);
            IdKhachHang[i] = String.format("KH%07d", i);
            diaChiKH[i] = diaChi[i % cntDiaChi];
        }

        // Tạo mới bảng khách hàng
        
        String sql = "CREATE TABLE KHACH_HANG(" +
                "ID_KH CHAR(10), " +
                "TEN_KH VARCHAR(100), " +
                "DIA_CHI_KH VARCHAR(100), " +
                "EMAIL_KH VARCHAR(50), " +
                "SDT CHAR(15), " +
                "CONSTRAINT PK_KH PRIMARY KEY (ID_KH));";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // insert dữ liệu vào bảng
        sql = "INSERT INTO KHACH_HANG VALUES";
        for (int i=0; i<NUMBER_OF_CUSTOMERS; i++) {
            sql+= "('" + IdKhachHang[i] + "','"+ name[i] + "','" + diaChiKH[i] + "','" + email[i] + "','" + phone[i] + "')";
            if (i % 10000 == 9999 || i == NUMBER_OF_CUSTOMERS-1) 
            {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_CUSTOMERS * 100, 2);
                } catch (Exception e) {
                    System.out.println("-----" + i);
                    e.printStackTrace();
                }
                sql = "INSERT INTO KHACH_HANG VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }














    

    static void createNhaCungCap() {
        System.out.println("Creating table NHA_CUNG_CAP");
        String sql = "CREATE TABLE NHA_CUNG_CAP( " +
            "ID_NCC CHAR(10)," + 
            "TEN_NCC VARCHAR(100)," +
            "DIA_CHI VARCHAR(100)," +
            "PRIMARY KEY (ID_NCC))";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO NHA_CUNG_CAP VALUES" +
            "('NCC00', 'Cong Ty TNHH Thuong Mai Dich Vu Du Lich Va Xuat Nhap Khau Quoc Uy', 'Phuoc Long B, Quan 9, Thanh pho Ho Chi Minh')," +
            "('NCC01', 'Cong ty co phan The Gioi So', 'Phuong 04, Quan 3, Thanh pho Ho Chi Minh')," +
            "('NCC02', 'Cong ty TNHH Thuong Mai Trang Vang', 'Phuong Bach Khoa, Quan Hai Ba Trung, Ha Noi')," +
            "('NCC03', 'Cong ty TNHH An Phat', 'Phuong Mai Dich, Cau Giay, Ha Noi, Viet Nam')," +
            "('NCC04', 'Cong ty Co phan Xuat Nhap Khau va Thuong Mai Thuy Anh', 'Phuong Khuong Dinh, Quan Thanh Xuan')," +
            "('NCC05', 'Cong ty Co phan Thiet bi vien thong Tho Phat', 'Duong Vu Trong Phung, Quan Thanh Xuan, Ha Noi')," +
            "('NCC06', 'Thanh Dung Trading And Export Import Co., Ltd', 'Duong Nguyen Duc Quy, Quan Thanh Xuan, Ha Noi')," +
            "('NCC07', 'Cong ty TNHH Xuat Nhap Khau va Thuong Mai Van Thang', 'Thon Trang, Thanh Liet, Thanh Tri, Ha Noi')," +
            "('NCC08', 'Cong Ty TNHH Xuat Nhap Khau Va Dau Tu Cong Nghe Tri Anh', '1.D, Nguyen Van Cu, Gia Thuy, Long Bien, Ha Noi')," +
            "('NCC09', 'Cong Ty Co Phan Xuat Nhap Khau Va Phat Trien Cong Nghe SDC', 'Phuong Dich Vong, Quan Cau Giay, Ha Noi')," +
            "('NCC10', 'Cong ty TNHH Xuat Nhap Khau Va Cong nghe Anh Minh', 'P.Van Quan, Ha Dong, Ha Noi')," +
            "('NCC11', 'Cong Ty TNHH Thuong Mai Va Xuat Nhap Khau Tada', 'Tang 2, 35, Ngo 322/95/29, Phuong My Dinh 2, Tu Liem, Ha Noi')," +
            "('NCC12', 'Cong Ty Co Phan Xuat Nhap Khau Va Ung Dung Cong Nghe Moi', 'Thuong Tin, Huyen Thuong Tin, Ha Noi')," +
            "('NCC13', 'Cong Ty Tnhh Thuong Mai Va Xuat Nhap Khau Adt', 'Ton Duc Thang, Quoc Tu Giam, Hoan Kiem, Ha Noi')," +
            "('NCC14', 'Cong Ty Tnhh Xuat Nhap Khau May Tinh Viet Nam', 'Phuong 8, Quan 11, Thanh pho Ho Chi Minh')," +
            "('NCC15', 'Cong Ty TNHH Thuong Mai Dich Vu Xuat Nhap Khau Vi Tinh Tan Thuan', '514 To Ky, Tan Chanh Hiep, Quan 12, Thanh pho Ho Chi Minh')," +
            "('NCC16', 'Thanh Tin Laptop Import Export Co., Ltd', '376 Duong 32, Phuong 12, Quan 10, Thanh pho Ho Chi Minh')," +
            "('NCC17', 'Cong Ty Tnhh Xuat Nhap Khau May Tinh Xach Tay Nhat My', '179 Tan Huong, Tan Quy, Tan Phu, Thanh pho Ho Chi Minh')," +
            "('NCC18', 'Cong Ty Tnhh Xuat Nhap Khau May Tinh Xach Tay Thanh Tin', '93 Bui Thi Xuan, Phuong Pham Ngu Lao, Quan 1, Thanh pho Ho Chi Minh')," +
            "('NCC19', 'Cong Ty TNHH MTV Dich Vu Xuat Nhap Khau Van Sang', 'Phuoc Long B, Quan 9, Thanh pho Ho Chi Minh');";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }











    

    static void createNhaSanXuat() {
        System.out.println("Creating table NHA_SAN_XUAT");
        String sql = "CREATE TABLE NHA_SAN_XUAT( " +
            "ID_NSX CHAR(10)," + 
            "TEN_NSX VARCHAR(100)," +
            "PRIMARY KEY (ID_NSX))";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO NHA_SAN_XUAT VALUES";
        for (int i=0; i<laptopBranchs.length; i++) {
            sql+= String.format("(\'NSX%02d\', \'%s\')%s", i, laptopBranchs[i], i < laptopBranchs.length-1 ? "," : ";");
        }
           
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










    
    static void createCuaHang() {
        System.out.println("Creating table CUA_HANG");
        String sql = "CREATE TABLE CUA_HANG(" +
                    "ID_CH CHAR(10)," + 
                    "TINH VARCHAR(30)," +
                    "HUYEN VARCHAR(30)," +
                    "DIA_CHI_CU_THE VARCHAR(100)," +
                    "CONSTRAINT PK_CH PRIMARY KEY (ID_CH));";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO CUA_HANG VALUES";
        for (int i=0; i<NUMBER_OF_STORES; i++) {
            int t = rand(cntDiaChi);
            sql+= String.format("(\'CH%06d\', \'%s\', \'%s\', \'%s\')", i, tinh[t], huyen[t], xa[t] + ", " + huyen[t] + ", " + tinh[t]);
            if (i % 10000 == 9999 || i == NUMBER_OF_STORES - 1) 
            {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_STORES * 100, 2);
                } catch (Exception e) {
                    System.out.println("-----" + i);
                    e.printStackTrace();
                }
                sql = "INSERT INTO CUA_HANG VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }











    static void createLaptop() {
        System.out.println("Creating table LAPTOP");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE LAPTOP(" +
                "ID_LOAI CHAR(10)," +
                "TEN_LOAI CHAR(50)," +
                "ID_NSX CHAR(10)," +
                "MAU_SAC CHAR(50)," +
                "BO_NHO INT," +
                "GIA INT," +
                "PRIMARY KEY (ID_LOAI), " +
                "FOREIGN KEY (ID_NSX) REFERENCES NHA_SAN_XUAT (ID_NSX) ON DELETE CASCADE ON UPDATE CASCADE" +
            ");";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement st = conn.createStatement();
            String sql = "INSERT INTO LAPTOP VALUES";
            for (int i=0; i<laptopBranchs.length; i++) 
            for (int j=0; j<laptopSeries.length; j++) 
            for (int t=0; t<laptopStorage.length; t++) {
                price[NUMBER_OF_LAPTOPS] = rand((int) 2e4) * 1000 + (int) 1e7;
                sql+= String.format("(\'LOAI%04d\', \'%s %s %d\', \'NSX%02d\', \'%s\', %d, %d)%s", 
                                    NUMBER_OF_LAPTOPS , laptopBranchs[i], laptopSeries[j], t + 5, i, 
                                    laptopColor[rand(4)], laptopStorage[t], price[NUMBER_OF_LAPTOPS], 
                                    (i == laptopBranchs.length-1 && j == laptopSeries.length-1 && t==laptopStorage.length-1) ? ";" : ",");
                NUMBER_OF_LAPTOPS++;
            }
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










    static void createChiTietLaptop() {
        System.out.println("Creating table CHI_TIET_LAPTOP");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE CHI_TIET_LAPTOP(" +
                            "ID_MAY CHAR(10)," +
                            "ID_NCC CHAR(10)," +
                            "ID_LOAI CHAR(10)," +
                            "ID_CH CHAR(10)," +
                            "STATUS int," +
                            "PRIMARY KEY (ID_MAY)," +
                            "FOREIGN KEY (ID_NCC) REFERENCES NHA_CUNG_CAP (ID_NCC) ON DELETE CASCADE ON UPDATE CASCADE," +
                            "FOREIGN KEY (ID_LOAI) REFERENCES LAPTOP (ID_LOAI) ON DELETE CASCADE ON UPDATE CASCADE," +
                            "FOREIGN KEY (ID_CH) REFERENCES CUA_HANG (ID_CH) ON DELETE CASCADE ON UPDATE CASCADE" +
                        ");";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Statement st = conn.createStatement();
            String sql = "INSERT INTO CHI_TIET_LAPTOP VALUES";
            for (int i=0; i<NUMBER_OF_LAPTOPS_DETAIL; i++) {
                int type = rand(11) < 10 ? 1 : 2;
                laptopPrice[i] = price[i % NUMBER_OF_LAPTOPS];
                laptopStatus[i] = type;
                sql+= String.format("(\'LP%07d\', \'NCC%02d\', \'LOAI%04d\', \'CH%06d\', %d)%s", 
                                    i, i % NUMBER_OF_IMPORT_BILLS % NUMBER_OF_SUPPLIER, rand(NUMBER_OF_LAPTOPS), rand(NUMBER_OF_STORES), type, (i < NUMBER_OF_LAPTOPS_DETAIL-1 && i % 10000 != 9999) ? "," : ";");
                if (i % 10000 == 9999 || i == NUMBER_OF_LAPTOPS_DETAIL-1) {
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_LAPTOPS_DETAIL * 100, 2);
                    sql = "INSERT INTO CHI_TIET_LAPTOP VALUES";
                }                                    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }










    static void createNhanVien() {
        String name[] = new String[NUMBER_OF_EMPLOYEES + 10];
        String phone[] = new String[NUMBER_OF_EMPLOYEES + 10];
        String IdNhanVien[] = new String[NUMBER_OF_EMPLOYEES + 10];
        String CH[] = new String[NUMBER_OF_EMPLOYEES + 10];


        System.out.println("Creating table NHAN_VIEN");
        for (int i=0; i<NUMBER_OF_EMPLOYEES; i++) {
            int bool = rand(5);
            String firstName = "", middleName = "", lastName = "", second = "";
            if (bool < 3) {
                do {
                    firstName = ho[rand(ho.length)];
                    middleName = demNam[rand(demNam.length)];
                    lastName = tenNam[rand(tenNam.length)];
                } while (firstName == middleName || middleName == lastName);
                name[i] = firstName + ' ' + middleName + ' ' + lastName;
            } 
            else {
                do {
                    firstName = ho[rand(ho.length)];
                    middleName = demNu[rand(demNu.length)];
                    if ( !middleName.contains(" ") && rand(4) == 0 ) {
                        second = " " + ho[rand(ho.length)] + " ";
                    } else second = " ";
                    lastName = tenNu[rand(tenNu.length)];
                } while (firstName == middleName || firstName == second || middleName == lastName);
                name[i] = firstName + second + middleName + ' ' + lastName;
            }
            


            phone[i] = firstPhoneNumber[rand(firstPhoneNumber.length)] + (rand(9000000) + 1000000);
            IdNhanVien[i] = String.format("NV%05d", i);
            CH[i] = String.format("CH%06d", rand(NUMBER_OF_STORES));
        }

        
        String sql = "CREATE TABLE NHAN_VIEN(" +
                "ID_NV CHAR(10)," +
                "TEN_NV VARCHAR(100)," +
                "ID_CH CHAR(10)," +
                "SDT CHAR(15)," +
                "CONSTRAINT PK_NV PRIMARY KEY (ID_NV));";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // insert dữ liệu vào bảng
        sql = "INSERT INTO NHAN_VIEN VALUES";
        for (int i=0; i<NUMBER_OF_EMPLOYEES; i++) {
            sql+= "('" + IdNhanVien[i] + "','"+ name[i] + "','" + CH[i] + "','" + phone[i] + "')";
            if (i % 10000 == 9999 || i == NUMBER_OF_EMPLOYEES-1) 
            {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO NHAN_VIEN VALUES";
            } else {
                sql+= ',';
            }
        }
    }










    static void createHoaDonNhap() {
        System.out.println("Creating table HOA_DON_NHAP");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE HOA_DON_NHAP(" +
                        "ID_HDN CHAR(10)," +
                        "NGAY_NHAP DATE," +
                        "ID_NCC CHAR(10)," +
                        "ID_NV CHAR(10)," +
                        "PRIMARY KEY(ID_HDN)," +
                        "FOREIGN KEY (ID_NCC) REFERENCES NHA_CUNG_CAP (ID_NCC)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE," +
                        "FOREIGN KEY (ID_NV) REFERENCES NHAN_VIEN (ID_NV)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO HOA_DON_NHAP VALUES";
        for (int i=0; i<NUMBER_OF_IMPORT_BILLS; i++) {
            importDate[i] = randomDate(2017, 2021);
            sql+= String.format("(\'HDN%06d\', \'%s\', \'NCC%02d\', \'NV%05d\')", 
                                i, importDate[i], i % NUMBER_OF_SUPPLIER, i % NUMBER_OF_EMPLOYEES);
            if (i % 10000 == 9999 || i == NUMBER_OF_IMPORT_BILLS - 1) {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_IMPORT_BILLS * 100, 2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO HOA_DON_NHAP VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }











    static void createChiTietHoaDonNhap() {
        System.out.println("Creating table CHI_TIET_HOA_DON_NHAP");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE CHI_TIET_HOA_DON_NHAP(" +
                "ID_HDN CHAR(10)," +
                "ID_MAY CHAR(10)," +
                "GIA_NHAP INT," +
                "PRIMARY KEY (ID_HDN,ID_MAY)," +
                "FOREIGN KEY (ID_MAY) REFERENCES CHI_TIET_LAPTOP (ID_MAY)" +
                    "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO CHI_TIET_HOA_DON_NHAP VALUES";
        for (int i=0; i<NUMBER_OF_IMPORT_BILLS_DETAIL; i++) {
            sql+= String.format("(\'HDN%06d\', \'LP%07d\', %d)", i % NUMBER_OF_IMPORT_BILLS, i, laptopPrice[i] - randBetween(500, 3000) * 1000);
            if (i % 10000 == 9999 || i == NUMBER_OF_IMPORT_BILLS_DETAIL - 1) {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_IMPORT_BILLS_DETAIL * 100, 2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO CHI_TIET_HOA_DON_NHAP VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }







    static void createHoaDonXuat() {
        System.out.println("Creating table HOA_DON_XUAT");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE HOA_DON_XUAT(" +
                        "ID_HDX CHAR(10)," +
                        "NGAY_XUAT DATE," +
                        "ID_KH CHAR(10)," +
                        "ID_NV CHAR(10)," +
                        "PRIMARY KEY(ID_HDX)," +
                        "FOREIGN KEY (ID_KH) REFERENCES KHACH_HANG (ID_KH)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE," +
                        "FOREIGN KEY (ID_NV) REFERENCES NHAN_VIEN (ID_NV)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO HOA_DON_XUAT VALUES";
        for (int i=0; i<NUMBER_OF_EXPORT_BILLS; i++) {
            exportDate[i] = randomDate(2017, 2021);
            sql+= String.format("(\'HDX%06d\', \'%s\', \'KH%07d\', \'NV%05d\')", 
                                i, exportDate[i], rand(NUMBER_OF_CUSTOMERS), rand(NUMBER_OF_EMPLOYEES) );
            if (i % 10000 == 9999 || i == NUMBER_OF_EXPORT_BILLS - 1) {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_EXPORT_BILLS * 100, 2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO HOA_DON_XUAT VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }












    static void createChiTietHoaDonXuat() {
        System.out.println("Creating table CHI_TIET_HOA_DON_XUAT");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE CHI_TIET_HOA_DON_XUAT(" +
                        "ID_HDX CHAR(10)," +
                        "ID_MAY CHAR(10)," +
                        "GIA_XUAT INT," +
                        "PRIMARY KEY (ID_HDX,ID_MAY)," +
                        "FOREIGN KEY (ID_MAY) REFERENCES CHI_TIET_LAPTOP (ID_MAY)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO CHI_TIET_HOA_DON_XUAT VALUES";
        for (int i=0; i<NUMBER_OF_LAPTOPS_DETAIL; i++) {
            if (laptopStatus[i] == 2) continue;
            int ex, im = i % NUMBER_OF_IMPORT_BILLS;
            do {
                ex = rand(NUMBER_OF_EXPORT_BILLS);
            } while (exportDate[ex].compareTo(importDate[im]) < 0);
            sql+= String.format("(\'HDX%06d\', \'LP%07d\', %d)", ex, i, laptopPrice[i] + randBetween(-700, 3000) * 1000);
            if (i % 10000 == 9999 || i == NUMBER_OF_LAPTOPS_DETAIL - 1) {
                sql+= ';';
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_LAPTOPS_DETAIL * 100, 2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO CHI_TIET_HOA_DON_XUAT VALUES";
            } else {
                sql+= ',';
            }
        }
        System.out.println();
    }











    static void createGioHang() {
        System.out.println("Creating table GIO_HANG");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE GIO_HANG(" +
                        "ID_GH CHAR(10)," + 
                        "ID_KH CHAR(10)," +
                        "THOI_GIAN_CHINH_SUA_CUOI DATE," +
                        "PRIMARY KEY (ID_GH)," +
                        "FOREIGN KEY (ID_KH) REFERENCES KHACH_HANG (ID_KH)" +
                            "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO GIO_HANG VALUES";
        for (int i=0; i< NUMBER_OF_CARTS; i++) {
            sql+= String.format("(\'GH%04d\', \'KH%07d\', \'%s\')%s", 
                                i, rand(NUMBER_OF_CUSTOMERS), randomDate(2020, 2021), i == NUMBER_OF_CARTS-1 || i % 10000 == 9999 ? ";": ",");
            
            if (i % 10000 == 9999 || i == NUMBER_OF_CARTS - 1) {
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_CARTS * 100, 2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sql = "INSERT INTO GIO_HANG VALUES";
            }
        }
        System.out.println();
    }







    static void createChiTietGioHang() {
        System.out.println("Creating table CHI_TIET_GIO_HANG");
        try {
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE CHI_TIET_GIO_HANG(" +
                        "ID_GH CHAR(10), "+
                        "ID_LOAI CHAR(10), "+
                        "SO_LUONG INT, "+
                        "PRIMARY KEY (ID_GH,ID_LOAI), "+
                        "FOREIGN KEY(ID_GH) REFERENCES GIO_HANG(ID_GH) "+
                            "ON DELETE CASCADE ON UPDATE CASCADE, "+
                        "FOREIGN KEY (ID_LOAI) REFERENCES LAPTOP (ID_LOAI) "+
                            "ON DELETE CASCADE ON UPDATE CASCADE);";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO CHI_TIET_GIO_HANG VALUES";
        for (int i=0; i<NUMBER_OF_CARTS_DETAIL; i++) {
            sql+= String.format("(\'GH%04d\', \'LOAI%04d\', %d)%s", rand(NUMBER_OF_CARTS), rand(NUMBER_OF_LAPTOPS), randBetween(1, 3), 
                                i == NUMBER_OF_CARTS_DETAIL - 1 || i % 1000 == 999 ? ";" : ",");
            if (i % 10000 == 9999 || i == NUMBER_OF_CARTS_DETAIL - 1) {
                try {
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    System.out.printf("___________________%.2f %%\r", (double) (i + 1)/NUMBER_OF_CARTS_DETAIL * 100, 2);
                } catch (SQLException e) {
                    i-= i % 1000 + 1;
                    // e.printStackTrace();
                }
                sql = "INSERT INTO CHI_TIET_GIO_HANG VALUES";
            }
        }
        System.out.println();
    }






    public static void main(String[] args) 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        };

        try {
            File file = new File("TinhHuyenXa2021.txt");
            BufferedReader br
                = new BufferedReader(new FileReader(file));
            String text;
            String[] str = new String[7];
            while ((text = br.readLine()) != null) {
                str = text.split("\\t", -2);
                tinh[cntDiaChi] = str[5].replaceAll("\'", "");
                huyen[cntDiaChi] = str[4].replaceAll("\'", "");
                xa[cntDiaChi] = str[3].replaceAll("\'", "");
                diaChi[cntDiaChi] = xa[cntDiaChi] + ", " + huyen[cntDiaChi] + ", " + tinh[cntDiaChi];
                cntDiaChi++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dropAllTables();
        
        createNhanVien();
        createKhachHang();
        createNhaCungCap();
        createNhaSanXuat();
        createCuaHang();
        createLaptop();
        createChiTietLaptop();
        createHoaDonNhap();
        createChiTietHoaDonNhap();
        createHoaDonXuat();
        createChiTietHoaDonXuat();
        createGioHang();
        createChiTietGioHang();
    }
}
