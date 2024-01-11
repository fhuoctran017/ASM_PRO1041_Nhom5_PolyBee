package com.asm.polybee.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class KhachHang {
    

    private String idKhachHang;


    private String maKhachHang;


    private String tenKhachHang;


    private String sdt;


    private String diaChi;


    private String gioiTinh;


    private Date ngaySinh;


    private String trangThai;

}
