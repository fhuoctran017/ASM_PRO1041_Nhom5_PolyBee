package com.asm.polybee.service.Impl;

import com.asm.polybee.model.KhachHang;
import com.asm.polybee.repository.KhachHangRepository;
import com.asm.polybee.service.KhachHangService;
import java.util.List;

/**
 *
 * @author phuoc
 */
public class KhachHangServiceImpl implements KhachHangService{

    private KhachHangRepository KhachHangRepository = new KhachHangRepository();
    @Override
    public List<KhachHang> getAll() {
        return KhachHangRepository.getAll();
    }
    
}
