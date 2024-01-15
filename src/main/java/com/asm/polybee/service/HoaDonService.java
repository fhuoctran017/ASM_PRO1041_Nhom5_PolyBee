/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asm.polybee.service;

import com.asm.polybee.model.HoaDon;
import java.util.List;

/**
 *
 * @author phuoc
 */
public interface HoaDonService {
    List<HoaDon> getAllHoaDon();
    
    boolean themHoaDon(HoaDon hoaDon);
}
