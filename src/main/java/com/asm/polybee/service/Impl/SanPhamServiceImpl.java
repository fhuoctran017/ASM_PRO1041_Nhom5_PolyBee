package com.asm.polybee.service.Impl;

import com.asm.polybee.model.SanPham;
import com.asm.polybee.repository.SanPhamRepository;
import com.asm.polybee.service.SanPhamService;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository repository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public List<SanPham> getSanPhamsByPage(int offset, int limit) {
        return repository.getAllByPages(offset, limit);
    }

    @Override
    public Boolean themSanPham(SanPham sanPham) {
        try {
            repository.themSanPham(sanPham);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
