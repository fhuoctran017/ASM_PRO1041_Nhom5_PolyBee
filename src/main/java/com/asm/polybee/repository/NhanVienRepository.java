package com.asm.polybee.repository;

import com.asm.polybee.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

public class NhanVienRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM NhanVien";
    private static final String SQL_GET_LOGIN_INFO = "SELECT * FROM NhanVien WHERE maNhanVien = ? AND matKhau = ?";

    public List<NhanVien> getAll() {
        List<NhanVien> nhanViens = new ArrayList<>();
        try ( Connection connection = JDBC.getConnection();  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)){
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
        nhanVien.setNgaySinh(resultSet.getString("ngaySinh"));
        nhanVien.setGioiTinh(resultSet.getString("gioiTinh"));
        nhanVien.setMatKhau(resultSet.getString("matKhau"));
        nhanVien.setIdchucVu(resultSet.getString("IdchucVu"));
        nhanVien.setTrangThai(resultSet.getString("trangThai"));
        return nhanVien;
    }
}
