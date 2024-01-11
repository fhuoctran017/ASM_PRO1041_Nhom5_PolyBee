package com.asm.polybee.repository;

import com.asm.polybee.model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

public class KhachHangRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM KhachHang";

    public List<KhachHang> getAll() {
        List<KhachHang> khachHangs = new ArrayList<>();
        try ( Connection connection = JDBC.getConnection();  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setIdKhachHang(resultSet.getString("idKhachHang"));
                khachHang.setMaKhachHang(resultSet.getString("maKhachHang"));
                khachHang.setTenKhachHang(resultSet.getString("tenKhachHang"));
                khachHang.setSdt(resultSet.getString("sdt"));
                khachHang.setDiaChi(resultSet.getString("diaChi"));
                khachHang.setGioiTinh(resultSet.getString("gioiTinh"));
                khachHang.setNgaySinh(resultSet.getDate("ngaySinh"));
                khachHang.setTrangThai(resultSet.getString("trangThai"));
                khachHangs.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHangs;
    }

    public List<KhachHang> getKhachHangsByPage(int offset, int limit) {
    List<KhachHang> khachHangs = new ArrayList<>();
    try (Connection connection = JDBC.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM KhachHang ORDER BY idKhachHang OFFSET ? ROWS FETCH NEXT ? ROWS ONLY")) {
        statement.setInt(1, offset);
        statement.setInt(2, limit);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            KhachHang khachHang = new KhachHang();
            khachHang.setIdKhachHang(resultSet.getString("idKhachHang"));
            khachHang.setMaKhachHang(resultSet.getString("maKhachHang"));
            khachHang.setTenKhachHang(resultSet.getString("tenKhachHang"));
            khachHang.setSdt(resultSet.getString("sdt"));
            khachHang.setDiaChi(resultSet.getString("diaChi"));
            khachHang.setGioiTinh(resultSet.getString("gioiTinh"));
            khachHang.setNgaySinh(resultSet.getDate("ngaySinh"));
            khachHang.setTrangThai(resultSet.getString("trangThai"));
            khachHangs.add(khachHang);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return khachHangs;
}


}
