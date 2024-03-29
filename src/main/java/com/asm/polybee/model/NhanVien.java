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

public class NhanVien {

    String idnhanVien;

    String maNhanVien;

    String tenNhanVien;

    String sdt;

    String diaChi;

    Date ngaySinh;

    String gioiTinh;

    String matKhau;

    String IdchucVu;

    String trangThai;

}
