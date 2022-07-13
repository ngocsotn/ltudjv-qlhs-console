/*
Họ và tên Sinh viên: Nguyễn Thế Ngọc
Lớp: 20HCB1 - Hệ liên thông ĐH (ĐH Hoàn Chỉnh)
MSSV: 20424056
Trường ĐH KHTN
*/

package pkg20424056;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author NGOC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static String path = "20424056.txt";
    private static String pathCSV = "20424056.csv";
    private static String menu = "\n\n======= MENU ======\n"
            + "1. Them 1 Hoc sinh moi.\n"
            + "2. Cap nhat 1 Hoc sinh (dua vao ma HS).\n"
            + "3. Xoa 1 Hoc Sinh (dua vao ma HS).\n"
            + "4. Xem Danh Sach hoc sinh (theo Diem/MaHS, sap tang/giam).\n"
            + "5. Reload lai danh sach HS tu file nhi phan.\n"
            + "6. Luu/Cap nhat danh sach HS ra file nhi phan.\n"
            + "7. Import danh sach tu file .csv\n"
            + "8. Export danh sach ra file .csv\n"
            + "Nhap bat ki khac 1~8 de thoat.\n"
            + "=======================\n";
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String luaChon = "1";
        Scanner scanGuy = new Scanner(System.in);
        CQuanLy clr = new CQuanLy();
        clr.load(path);
        while(true) {
            System.out.print(menu);
            System.out.print(" -> Nhap vao lua chon: ");
            luaChon = scanGuy.nextLine();
            if(luaChon.equals("1")) {
                clr.themMotHocSinh();
            }
            else if(luaChon.equals("2")) {
                clr.capNhatHocSinh();
            }
            else if(luaChon.equals("3")) {
                clr.xoaHocSinh();
            }
            else if(luaChon.equals("4")) {
                clr.xuatTheoYeuCau();
            }
            else if(luaChon.equals("5")) {
                clr.load(path);
            }
            else if(luaChon.equals("6")) {
                clr.save(path);
            }
            else if(luaChon.equals("7")) {
                clr.importCSV(pathCSV);
            }
            else if(luaChon.equals("8")) {
                clr.exportCSV(pathCSV);
            }
            else {
                System.out.print("Da Thoat chuong trinh!\n");
                break;
            }
        }
    }
    
}
