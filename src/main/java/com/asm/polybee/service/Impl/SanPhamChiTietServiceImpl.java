package com.asm.polybee.service.Impl;

import com.asm.polybee.model.SanPhamChiTiet;
import com.asm.polybee.repository.SanPhamChiTietRepository;
import java.util.List;

public class SanPhamChiTietServiceImpl implements com.asm.polybee.service.SanPhamChiTietService {

    private SanPhamChiTietRepository repository = new SanPhamChiTietRepository();

    @Override
    public List<SanPhamChiTiet> getAll() {
        return repository.getAllSanPhamChiTiet();
    }

    @Override
    public Boolean themSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        try {
            repository.themSanPhamChiTiet(sanPhamChiTiet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
