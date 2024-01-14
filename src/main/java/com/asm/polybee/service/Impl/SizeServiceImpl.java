/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.Size;
import com.asm.polybee.repository.SizeRepository;
import com.asm.polybee.service.SizeService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class SizeServiceImpl implements SizeService {

    private SizeRepository repository = new SizeRepository();

    @Override
    public List<Size> getAll() {

        return repository.getAll();
    }

    @Override
    public Boolean themSize(Size size) {
        if (size != null) {
            repository.themSize(size);
            return true;
        } else {
            return false;
        }
    }

}
