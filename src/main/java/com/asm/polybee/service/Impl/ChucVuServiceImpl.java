/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.service.Impl;

import com.asm.polybee.model.ChucVu;
import com.asm.polybee.repository.ChucVuRepository;
import com.asm.polybee.service.ChucVuService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class ChucVuServiceImpl implements ChucVuService{

    private ChucVuRepository ChucVuRepository = new ChucVuRepository();
    
    @Override
    public List<ChucVu> getAll() {
        return ChucVuRepository.getAll();
    }
    
}
