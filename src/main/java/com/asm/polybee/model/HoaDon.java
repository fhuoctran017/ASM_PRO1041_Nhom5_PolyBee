package com.asm.polybee.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDon {

    private String idHoaDon;

    private String maHoaDon;

    private Date ngayTao;

    private String ghiChu;

    private String idNhanVien;

    private String idKhachHang;

    private String trangThai;
}
