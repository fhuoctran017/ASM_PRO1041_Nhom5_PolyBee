package com.asm.polybee.service;

import com.asm.polybee.model.SanPham;
import java.util.List;


public interface SanPhamService {
    List<SanPham> getAll();
    
     List<SanPham> getSanPhamsByPage(int offset, int limit);
     
     Boolean themSanPham(SanPham sanPham);
}
