/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.ThuongHieu;
import com.asm.polybee.repository.ThuongHieuRepository;
import com.asm.polybee.service.ThuongHieuService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class ThuongHieuServiceImpl implements ThuongHieuService{

    private ThuongHieuRepository thuongHieuRepository = new ThuongHieuRepository();
    
    @Override
    public List<ThuongHieu> getAll() {
       return thuongHieuRepository.getAll();
    }

    @Override
    public boolean themThuongHieu(ThuongHieu thuongHieu) {
        if (thuongHieu != null) {
            thuongHieuRepository.themThuongHieu(thuongHieu);
            return true;
        } else {
            return false;
        }
    }
    
}
