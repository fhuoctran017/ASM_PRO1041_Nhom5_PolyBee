package com.asm.polybee.repository;

import com.asm.polybee.model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

public class HoaDonRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM HoaDon";

    private static final String SQL_INSERT_HOADON = "INSERT INTO HoaDon ( MaHoaDon, NgayTao, GhiChu, IdNhanVien, IdKhachHang, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";

    public List<HoaDon> getAll() {
        List<HoaDon> hoaDons = new ArrayList<>();
        try ( Connection connection = JDBC.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL);  ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(resultSet.getString("IdHoaDon"));
                hoaDon.setMaHoaDon(resultSet.getString("MaHoaDon"));
                hoaDon.setNgayTao(resultSet.getDate("NgayTao"));
                hoaDon.setGhiChu(resultSet.getString("GhiChu"));
                hoaDon.setIdNhanVien(resultSet.getString("IdNhanVien"));
                hoaDon.setIdKhachHang(resultSet.getString("IdKhachHang"));
                hoaDon.setTrangThai(resultSet.getString("TrangThai"));
                hoaDons.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDons;
    }

    public void themHoaDon(HoaDon hoaDon) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_HOADON)) {

            preparedStatement.setString(1, hoaDon.getMaHoaDon());
            preparedStatement.setDate(2, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            preparedStatement.setString(3, hoaDon.getGhiChu());
            preparedStatement.setString(4, hoaDon.getIdNhanVien());
            preparedStatement.setString(5, hoaDon.getIdKhachHang());
            preparedStatement.setString(6, hoaDon.getTrangThai());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
