package com.asm.polybee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham {

    private String idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private String idTheLoai;
    private String idThuongHieu;
    private String trangThai;
}
