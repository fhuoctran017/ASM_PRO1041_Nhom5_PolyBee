package com.asm.polybee.service.Impl;

import com.asm.polybee.model.KhachHang;
import com.asm.polybee.repository.KhachHangRepository;
import com.asm.polybee.service.KhachHangService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAllKhachHangs() {
        return khachHangRepository.getAll();
    }

    @Override
    public List<KhachHang> getKhachHangsByPage(int offset, int limit) {
        return khachHangRepository.getKhachHangsByPage(offset, limit);
    }

}
