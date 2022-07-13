/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424056;

import java.util.Scanner;

/**
 *
 * @author NGOC
 */
public class CHocSinh {

    /**
     * @return the _MHS
     */
    public String getMHS() {
        return _MHS;
    }

    /**
     * @param _MHS the _MHS to set
     */
    public void setMHS(String _MHS) {
        this._MHS = _MHS;
    }

    /**
     * @return the _tenHS
     */
    public String getTenHS() {
        return _tenHS;
    }

    /**
     * @param _tenHS the _tenHS to set
     */
    public void setTenHS(String _tenHS) {
        this._tenHS = _tenHS;
    }

    /**
     * @return the _diem
     */
    public Double getDiem() {
        return _diem;
    }

    /**
     * @param _diem the _diem to set
     */
    public void setDiem(Double _diem) {
        this._diem = _diem;
    }

    /**
     * @return the _hinhAnh
     */
    public String getHinhAnh() {
        return _hinhAnh;
    }

    /**
     * @param _hinhAnh the _hinhAnh to set
     */
    public void setHinhAnh(String _hinhAnh) {
        this._hinhAnh = _hinhAnh;
    }

    /**
     * @return the _diaChi
     */
    public String getDiaChi() {
        return _diaChi;
    }

    /**
     * @param _diaChi the _diaChi to set
     */
    public void setDiaChi(String _diaChi) {
        this._diaChi = _diaChi;
    }

    /**
     * @return the _ghiChu
     */
    public String getGhiChu() {
        return _ghiChu;
    }

    /**
     * @param _ghiChu the _ghiChu to set
     */
    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }
    private String _MHS;
    private String _tenHS;
    private Double _diem;
    private String _hinhAnh; //URL or path
    private String _diaChi;
    private String _ghiChu;
    
    public void nhapHocSinh(){
        Scanner scanGuy = new Scanner(System.in);
        System.out.print(" - Ma Hoc Sinh: ");
        setMHS(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Ten Hoc sinh: ");
        setTenHS(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Diem: ");
        setDiem(scanGuy.nextDouble());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Hinh Anh: ");
        setHinhAnh(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Dia Chi: ");
        setDiaChi(scanGuy.nextLine());
        
        scanGuy = new Scanner(System.in);
        System.out.print(" - Ghi Chu: ");
        setGhiChu(scanGuy.nextLine());
    }
    
    public void xuatHocSinh() {
        System.out.println(" - Ma Hoc Sinh: " + getMHS());
        System.out.println(" - Ten Hoc Sinh: " + getTenHS());
        System.out.println(" - Diem: " + getDiem());
        System.out.println(" - Hinh Anh: " + getHinhAnh());
        System.out.println(" - Dia Chi: " + getDiaChi());
        System.out.println(" - Ghi Chu: " + getGhiChu());
    }
    
    public CHocSinh timKiemHocSinh(String _ma) {
        if(this.getMHS().equals(_ma)) {
            return this;
        }
        return null;
    }
//    
//    public CHocSinh capNhatHocSinh(String _ma, String maMoi, String tenMoi, Double diemMoi, String hinhAnhMoi, String diaChiMoi, String ghiChuMoi) {
//        CHocSinh target = timKiemHocSinh(_ma);
//        if(target == null){
//            return null;
//        }
//        target.setMHS(maMoi);
//        target.setTenHS(tenMoi);
//        target.setDiem(diemMoi);
//        target.setHinhAnh(hinhAnhMoi);
//        target.setDiaChi(diaChiMoi);
//        target.setGhiChu(ghiChuMoi);
//        
//        return target;
//    }
}
