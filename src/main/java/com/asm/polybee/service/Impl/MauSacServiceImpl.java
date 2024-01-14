/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.MauSac;
import com.asm.polybee.repository.MauSacRepository;
import com.asm.polybee.service.MauSacService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class MauSacServiceImpl implements MauSacService{

    private MauSacRepository repository = new MauSacRepository();
    @Override
    public List<MauSac> getAll() {
       return repository.getAll();
    }

    @Override
    public boolean themMauSac(MauSac mauSac) {
         if (mauSac != null) {
            repository.themMauSac(mauSac);
            return true;
        } else {
            return false;
        }
    }
    
}
