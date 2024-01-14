package com.asm.polybee.repository;

import com.asm.polybee.model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ultil.JDBC;

public class KhachHangRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM KhachHang";

    private static final String SQL_INSERT = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";

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
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("SELECT * FROM KhachHang ORDER BY idKhachHang OFFSET ? ROWS FETCH NEXT ? ROWS ONLY")) {
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

    public boolean themKhachHang(KhachHang khachHang) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, khachHang.getMaKhachHang());
            statement.setString(2, khachHang.getTenKhachHang());
            statement.setString(3, khachHang.getSdt());
            statement.setString(4, khachHang.getDiaChi());
            statement.setString(5, khachHang.getGioiTinh());
            statement.setDate(6, new java.sql.Date(khachHang.getNgaySinh().getTime()));

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        KhachHangRepository khachHangRepo = new KhachHangRepository();

        // Tạo một đối tượng KhachHang mới để thêm vào cơ sở dữ liệu
        KhachHang khachHangMoi = new KhachHang();
        khachHangMoi.setMaKhachHang("KH001");
        khachHangMoi.setTenKhachHang("Nguyen Van A");
        khachHangMoi.setSdt("123456789");
        khachHangMoi.setDiaChi("Hanoi");
        khachHangMoi.setGioiTinh("Nam");
        
        LocalDate ngaySinhLocalDate = LocalDate.of(2000, 1, 1);
        Date ngaySinhDate = java.sql.Date.valueOf(ngaySinhLocalDate);
        khachHangMoi.setNgaySinh(ngaySinhDate);

        // Gọi hàm themKhachHang để thêm vào cơ sở dữ liệu
        boolean themThanhCong = khachHangRepo.themKhachHang(khachHangMoi);

        if (themThanhCong) {
            System.out.println("Thêm khách hàng thành công!");
        } else {
            System.out.println("Thêm khách hàng thất bại!");
        }
    }

}
