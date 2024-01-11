package com.asm.polybee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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


@Entity
@Table(name = "NhanVien")
public class NhanVien {
    
    @Id
    @Column(name = "IdNhanVien")
    String idnhanVien;
    
    @Column(name = "MaNhanVien")
    String maNhanVien;
    
    @Column(name = "TenNhanVien")
    String tenNhanVien;
    
    @Column(name = "Sdt")
    String sdt;
    
    @Column(name = "DiaChi")
    String diaChi;
    
    @Column(name = "NgaySinh")
    String ngaySinh;
    
    @Column(name = "GioiTinh")
    String gioiTinh;
    
    @Column(name = "MatKhau")
    String matKhau;
    
    @ManyToOne
    @JoinColumn(name = "idChucVu")
    ChucVu chucVu;
    
    @Column(name = "TrangThai")
    String trangThai;
    
}
