package com.asm.polybee.repository;

import com.asm.polybee.model.SanPhamChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

/**
 *
 * @author phuoc
 */
public class SanPhamChiTietRepository {

    private static final String SQL_GET_ALL = "SELECT spct.*, mau.TenMauSac, cl.TenChatLieu, size.Size "
            + "FROM SanPhamChiTiet spct "
            + "JOIN MauSac mau ON spct.IdMauSac = mau.IdMauSac "
            + "JOIN ChatLieu cl ON spct.IdChatLieu = cl.IdChatLieu "
            + "JOIN Size size ON spct.IdSize = size.IdSize";

    private static final String SQL_INSERT = "INSERT INTO SanPhamChiTiet ( IdSanPham, IdChatLieu, IdMauSac, IdSize, Gia, SoLuong) VALUES ( ?, ?, ?, ?, ?, ?)";

    public List<SanPhamChiTiet> getAllSanPhamChiTiet() {
        List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<>();

        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
                sanPhamChiTiet.setIdSanPhamChiTiet(resultSet.getString("IdSanPhamChiTiet"));
                sanPhamChiTiet.setIdSanPham(resultSet.getString("IdSanPham"));
                sanPhamChiTiet.setIdChatLieu(resultSet.getString("IdChatLieu"));
                sanPhamChiTiet.setIdMauSac(resultSet.getString("IdMauSac"));
                sanPhamChiTiet.setIdSize(resultSet.getString("IdSize"));
                sanPhamChiTiet.setGia(resultSet.getLong("Gia"));
                sanPhamChiTiet.setSoLuong(resultSet.getInt("SoLuong"));
                sanPhamChiTiet.setTrangThai(resultSet.getString("TrangThai"));
                sanPhamChiTiets.add(sanPhamChiTiet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamChiTiets;
    }
    
    public boolean themSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, sanPhamChiTiet.getIdSanPham());
            statement.setString(2, sanPhamChiTiet.getIdChatLieu());
            statement.setString(3, sanPhamChiTiet.getIdMauSac());
            statement.setString(4, sanPhamChiTiet.getIdSize());
            statement.setLong(5, sanPhamChiTiet.getGia());
            statement.setInt(6, sanPhamChiTiet.getSoLuong());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        SanPhamChiTietRepository repo = new SanPhamChiTietRepository();

        // Tạo đối tượng SanPhamChiTiet với dữ liệu mẫu
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setIdSanPham("38185CEA-4792-4792-A09E-225691B47AA7");
        sanPhamChiTiet.setIdChatLieu("0297E4D5-E99B-463F-AB55-472467418EAA");
        sanPhamChiTiet.setIdMauSac("6742B3A3-FE4B-47FF-9B2F-833A0CCFB48A");
        sanPhamChiTiet.setIdSize("6C0B231F-6234-47C1-950D-13575E6667C5");
        sanPhamChiTiet.setGia(Long.valueOf("200000"));
        sanPhamChiTiet.setSoLuong(5);

        // Thực hiện thêm sản phẩm chi tiết
        boolean isThemThanhCong = repo.themSanPhamChiTiet(sanPhamChiTiet);

        // Kiểm tra và in kết quả
        if (isThemThanhCong) {
            System.out.println("Thêm sản phẩm chi tiết thành công!");
        } else {
            System.out.println("Thêm sản phẩm chi tiết thất bại!");
        }
    }

}
