/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asm.polybee.service;

import com.asm.polybee.model.TheLoai;
import java.util.List;

/**
 *
 * @author phuoc
 */
public interface TheLoaiService {

    List<TheLoai> getAll();

    boolean themTheLoai(TheLoai theLoai);
}
