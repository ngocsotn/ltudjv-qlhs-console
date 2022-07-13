/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424056;

import java.util.Comparator;

/**
 *
 * @author NGOC
 */
public class SoSanhDiem implements Comparator<CHocSinh> {
    @Override
    public int compare(CHocSinh o1, CHocSinh o2) {
        return o1.getDiem().compareTo(o2.getDiem());
    }
    
}
