package com.asm.polybee.repository;

import com.asm.polybee.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ultil.JDBC;

public class NhanVienRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM NhanVien";
    private static final String SQL_GET_LOGIN_INFO = "SELECT * FROM NhanVien WHERE maNhanVien = ? AND matKhau = ?";
    private static final String SQL_INSERT = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, Sdt, DiaChi, NgaySinh, GioiTinh, MatKhau, IdChucVu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public List<NhanVien> getAll() {
        List<NhanVien> nhanViens = new ArrayList<>();
        try ( Connection connection = JDBC.getConnection();  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
            while (resultSet.next()) {
                NhanVien nhanVien = mapNhanVien(resultSet);

                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    public NhanVien getLoginInfo(String maNhanVien, String matKhau) {
        NhanVien nhanVien = null;
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_GET_LOGIN_INFO)) {
            statement.setString(1, maNhanVien);
            statement.setString(2, matKhau);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nhanVien = mapNhanVien(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    private NhanVien mapNhanVien(ResultSet resultSet) throws SQLException {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setIdnhanVien(resultSet.getString("idnhanVien"));
        nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
        nhanVien.setTenNhanVien(resultSet.getString("tenNhanVien"));
        nhanVien.setSdt(resultSet.getString("sdt"));
        nhanVien.setDiaChi(resultSet.getString("diaChi"));
        nhanVien.setNgaySinh(resultSet.getDate("ngaySinh"));
        nhanVien.setGioiTinh(resultSet.getString("gioiTinh"));
        nhanVien.setMatKhau(resultSet.getString("matKhau"));
        nhanVien.setIdchucVu(resultSet.getString("IdchucVu"));
        nhanVien.setTrangThai(resultSet.getString("trangThai"));
        return nhanVien;
    }

    public boolean themNhanVien(NhanVien nhanVien) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, nhanVien.getMaNhanVien());
            statement.setString(2, nhanVien.getTenNhanVien());
            statement.setString(3, nhanVien.getSdt());
            statement.setString(4, nhanVien.getDiaChi());
            statement.setDate(5, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            statement.setString(6, nhanVien.getGioiTinh());
            statement.setString(7, nhanVien.getMatKhau());
            statement.setString(8, nhanVien.getIdchucVu());
           

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        NhanVienRepository nhanVienRepo = new NhanVienRepository();

        // Tạo một đối tượng NhanVien mới để thêm vào cơ sở dữ liệu
        NhanVien nhanVienMoi = new NhanVien();
        nhanVienMoi.setMaNhanVien("NV001");
        nhanVienMoi.setTenNhanVien("Nom");
        nhanVienMoi.setSdt("123456789");
        nhanVienMoi.setDiaChi("Hanoi");
        
        LocalDate ngaySinhLocalDate = LocalDate.of(2000, 1, 1);
        Date ngaySinhDate = java.sql.Date.valueOf(ngaySinhLocalDate);
        nhanVienMoi.setNgaySinh(ngaySinhDate);
        
        nhanVienMoi.setGioiTinh("Nam");
        nhanVienMoi.setMatKhau("password123");
        nhanVienMoi.setIdchucVu("485017B3-921D-43F5-87C0-464F7C7F3DDA");

        // Gọi hàm themNhanVien để thêm vào cơ sở dữ liệu
        boolean themThanhCong = nhanVienRepo.themNhanVien(nhanVienMoi);

        // Hiển thị kết quả
        if (themThanhCong) {
            System.out.println("Thêm nhân viên thành công!");
        } else {
            System.out.println("Thêm nhân viên thất bại!");
        }
    }

}
