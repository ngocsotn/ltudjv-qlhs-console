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
public class SoSanhDiemReverse implements Comparator<CHocSinh> {
    @Override
    public int compare(CHocSinh o1, CHocSinh o2) {
        return o2.getDiem().compareTo(o1.getDiem());
    }
}
