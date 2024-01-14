/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.TheLoai;
import com.asm.polybee.repository.TheLoaiRepository;
import com.asm.polybee.service.TheLoaiService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class TheLoaiServiceImpl implements TheLoaiService{

    private TheLoaiRepository repository = new TheLoaiRepository();
    
    @Override
    public List<TheLoai> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean themTheLoai(TheLoai theLoai) {
        if (theLoai != null) {
            repository.themTheLoai(theLoai);
            return true;
        } else {
            return false;
        }
    }
    
}
