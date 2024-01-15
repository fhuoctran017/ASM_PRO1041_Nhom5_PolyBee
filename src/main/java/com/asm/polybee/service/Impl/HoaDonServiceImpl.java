package com.asm.polybee.service.Impl;

import com.asm.polybee.model.HoaDon;
import com.asm.polybee.repository.HoaDonRepository;
import com.asm.polybee.service.HoaDonService;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository repository = new HoaDonRepository();

    @Override
    public List<HoaDon> getAllHoaDon() {
        return repository.getAll();
    }

    @Override
    public boolean themHoaDon(HoaDon hoaDon) {
        if(hoaDon != null){
            repository.themHoaDon(hoaDon);
            return true;
        }else{
            return false;
        }
    }

}
