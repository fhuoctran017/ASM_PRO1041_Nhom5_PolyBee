package com.asm.polybee.service.Impl;

import com.asm.polybee.model.ChucVu;
import com.asm.polybee.model.NhanVien;
import com.asm.polybee.repository.NhanVienRepository;
import com.asm.polybee.service.NhanVienService;
import java.util.List;
import java.util.Map;

public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public NhanVien getLoginInfo(String maNhanVien, String matKhau) {
        return nhanVienRepository.getLoginInfo(maNhanVien, matKhau);
    }

    @Override
    public boolean themNhanVien(NhanVien nhanVien) {
        if(nhanVien != null){
            nhanVienRepository.themNhanVien(nhanVien);
            return true;
        }else{
            return false;
        }
    }

   

}
