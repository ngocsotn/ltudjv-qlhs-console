/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424056;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NGOC
 */
public class CQuanLy {
    private ArrayList<CHocSinh> ls = new ArrayList();
    
    public void themMotHocSinh()
    {
        while(true){
            CHocSinh _temp = null;
            _temp = new CHocSinh();
            _temp.nhapHocSinh();
            Boolean _checkMa = kiemTraMaOK(_temp.getMHS());
            if(_checkMa == false){
                System.out.println(" Ma Hoc Sinh Da ton tai, hay nhap ma khac!");
                continue;
            }
            ls.add(_temp);
            System.out.println(" Them thanh cong!");
            break;
        }
        
    }
    
    private Boolean kiemTraMaOK(String maHSKiemTra)
    {
        CHocSinh _checking = timHocSinh(maHSKiemTra);
        if(_checking != null){
            return false;
        }
        return true;
    }
    
    private void xuatDanhSach()
    {
        System.out.println(" Xuat danh sach hoc sinh: ");
        int n = ls.size();
        if(n == 0) {
            System.out.println(" - Danh sach rong!");
            return;
        }
        
        Scanner scanGuy = new Scanner(System.in);
        Boolean isASC = true;
        String inASC = "T";
        String sortBy = "Diem";
        
        System.out.print("Chon Muon sap xem theo gi (Diem/MHS): ");
        sortBy = scanGuy.nextLine();
        System.out.print("Muon sap tang hay giam?(T/G): ");
        inASC = scanGuy.nextLine();
        
        if(inASC.equals("G"))
        {
            isASC = false;
        }
        
        sort(sortBy, isASC);
        
        for(int i = 0 ; i < n ; i++)
        {
//            System.out.println(" Hoc Sinh thu "+(i+1));
            System.out.println("STT " + (i+1));
            ls.get(i).xuatHocSinh();
        }
    }
    
    public CHocSinh timHocSinh(String maHSCanTim)
    {
//        Scanner scanGuy = new Scanner(System.in);
//        System.out.print("Nhap Ma Hoc Sinh De tim kiem:");
//        String maHSCanTim = scanGuy.nextLine();
        CHocSinh target = null;
        int n = ls.size();
        for(int i = 0 ; i < n ; i++)
        {
            CHocSinh finder = ls.get(i).timKiemHocSinh(maHSCanTim);
            if(finder != null){
                target = finder;
                break;
            }
        }
        return target;
    }
    
    public Boolean xoaHocSinh() 
    {
        Scanner scanGuy = new Scanner(System.in);
        System.out.print("Nhap Ma Hoc Sinh De He thong tim va Xoa: ");
        String maHSCanTim = scanGuy.nextLine();
        CHocSinh target = timHocSinh(maHSCanTim);
        if(target == null) {
            System.out.println("Khong tim thay Hoc sinh de xoa!");
            return false;
        }
        ls.remove(target);
        System.out.println("Xoa thanh cong!");
        return true;
    }
    
    public Boolean capNhatHocSinh()
    {
        Scanner scanGuy = new Scanner(System.in);
        System.out.print("Nhap Ma Hoc Sinh De He thong tim va Cap nhat: ");
        String maHSCanTim = scanGuy.nextLine();
        CHocSinh target = timHocSinh(maHSCanTim);
        if(target == null) {
            System.out.println("Khong tim thay Hoc sinh!");
            return false;
        }
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Ten Hoc sinh: ");
        target.setTenHS(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Diem: ");
        target.setDiem(scanGuy.nextDouble());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Hinh Anh: ");
        target.setHinhAnh(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Dia Chi: ");
        target.setDiaChi(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Ghi Chu: ");
        target.setGhiChu(scanGuy.nextLine());
        
        System.out.println("Da Cap Nhat Hoc sinh!");
        return true;
    }
    
    public void xuatTheoYeuCau()
    {
        xuatDanhSach();
    }
    
    private void sort(String sortBy, Boolean isASC) //asc or desc
    {
        if("Diem".equals(sortBy))
        {
            if(isASC == true)
            {
                Collections.sort(ls, new SoSanhDiem());
            }
            else
            {
                Collections.sort(ls, new SoSanhDiemReverse());
            }
        }
        else
        {
            if(isASC == true)
            {
                Collections.sort(ls, new SoSanhMHS());
            }
            else
            {
                Collections.sort(ls, new SoSanhMHSReverse());
            }
        }
    }
    
    private void ghiFile(String path, String noiDung) throws FileNotFoundException, IOException
    {
        FileOutputStream fout;
        fout = new FileOutputStream(path);
        try 
        {
            byte myBytes[] = noiDung.getBytes();
            fout.write(myBytes);
//            fout.write(0);
        } 
        catch(IOException exc) 
        {
            System.out.println("Co loi trong qua trinh ghi file!");
        }
        fout.flush();
        fout.close();
        System.out.println("Luu file <" + path + "> thanh cong!");
    }
    
    private void docFile(String path) throws IOException
    {
        Scanner scan = null;
        try
        {
            scan = new Scanner(new File(path));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Khong tim thay <" + path + "> de doc file!");
            return;
        }
        
        ls.clear();
        while(scan.hasNextLine()){
            CHocSinh tmp = null;
            
            String line = scan.nextLine();
            String[] dtArr = line.split("---", -1);
            
            tmp = new CHocSinh();
            tmp.setMHS(dtArr[0]);
            tmp.setTenHS(dtArr[1]);
            tmp.setDiem(Double.valueOf(dtArr[2]));
            tmp.setHinhAnh(dtArr[3]);
            tmp.setDiaChi(dtArr[4]);
            tmp.setGhiChu(dtArr[5]);
            
            ls.add(tmp);
        }
        System.out.println("Doc file danh sach HS thanh cong!");
    }
    
    public void load(String path) throws FileNotFoundException, IOException
    {
        docFile(path);
    }
    
    public void save(String path) throws IOException
    {
        String content = "";
        int n = ls.size();
        for(int i = 0 ; i < n ; i++)
        {
            content += ls.get(i).getMHS() + "---";
            content += ls.get(i).getTenHS() + "---";
            content += ls.get(i).getDiem() + "---";
            content += ls.get(i).getHinhAnh() + "---";
            content += ls.get(i).getDiaChi() + "---";
            content += ls.get(i).getGhiChu();
            content += "\n";
        }
        ghiFile(path, content);
    }
    
    public void importCSV(String pathCSV) throws FileNotFoundException
    {
        Scanner scan = null;
        try
        {
            scan = new Scanner(new File(pathCSV));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Khong tim thay <" + pathCSV + "> de import CSV file!");
            return;
        }
        
        try
        {
            ls.clear();
            Boolean isFirstLine = false;
            Boolean isFormatOK = true;

            while(scan.hasNextLine()){
                CHocSinh tmp = null;

                String line = scan.nextLine();

                String[] dtArr = line.split(",", -1);
                if(isFirstLine == false)
                {
                    isFirstLine = true;
                    if(!dtArr[0].equals("MHS"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    if(!dtArr[1].equals("TenHS"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    if(!dtArr[2].equals("Diem"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    if(!dtArr[3].equals("Hinh Anh"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    if(!dtArr[4].equals("Dia Chi"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    if(!dtArr[5].equals("Ghi Chu"))
                    {
                        isFormatOK = false;
                        break;
                    }
                    continue;
                }
                
                if(dtArr.length != 6)
                {
                    isFormatOK = false;
                    break;
                }
//                dtArr[0] = dtArr[0].replaceAll("\"", "");
//                dtArr[5] = dtArr[5].replaceAll("\"", "");

                tmp = new CHocSinh();
                tmp.setMHS(dtArr[0]);
                tmp.setTenHS(dtArr[1]);
                tmp.setDiem(Double.valueOf(dtArr[2]));
                tmp.setHinhAnh(dtArr[3]);
                tmp.setDiaChi(dtArr[4]);
                tmp.setGhiChu(dtArr[5]);
                
                ls.add(tmp);
            }
            if(isFormatOK == true)
            {
                System.out.println("Import <" + pathCSV +"> thanh cong!");
            }
            else
            {
                System.out.println("Import <" + pathCSV +"> that bai, file sai dinh dang hoac thieu du lieu!");
            }
        }
        catch(Exception e)
        {
            System.out.println("Import <" + pathCSV +"> that bai, file sai dinh dang hoac thieu du lieu!");
        }
        
    }
    
    public void exportCSV(String pathCSV) throws IOException
    {
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(pathCSV);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Khong the tao <" + pathCSV + "> file!");
            return;
        }
//        writer.append('"');
        writer.append("MHS");
//        writer.append('"');
        
        writer.append(",");
//        vì dấu " dat biet, muốn nối chuỗi phải dùng \ kèm theo
        writer.append("TenHS");
        
        writer.append(",");
//        writer.append('"');
        writer.append("Diem");
//        writer.append('"');
        
        writer.append(",");
//        writer.append('"');
        writer.append("Hinh Anh");
//        writer.append('"');
        
        writer.append(",");
//        writer.append('"');
        writer.append("Dia Chi");
//        writer.append('"');
        
        writer.append(",");
//        writer.append('"');
        writer.append("Ghi Chu");
//        writer.append('"');
        
        writer.append('\n');
        
        int n = ls.size();
        for(int i = 0; i < n; i ++)
        {
//            writer.append('"');
            writer.append(ls.get(i).getMHS());
//            writer.append('"');

            writer.append(",");
            writer.append(ls.get(i).getTenHS());

            writer.append(",");
//            writer.append('"');
            writer.append(ls.get(i).getDiem()+"");
//            writer.append('"');

            writer.append(",");
//            writer.append('"');
            writer.append(ls.get(i).getHinhAnh());
//            writer.append('"');

            writer.append(",");
//            writer.append('"');
            writer.append(ls.get(i).getDiaChi());
//            writer.append('"');

            writer.append(",");
//            writer.append('"');
            writer.append(ls.get(i).getGhiChu());
//            writer.append('"');

            writer.append('\n');
        }
        
        writer.flush();
        writer.close();
        
        System.out.println("Export thanh cong file <" + pathCSV + "> !");
    }
}