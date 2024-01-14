package com.asm.polybee.repository;

import com.asm.polybee.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

public class SanPhamRepository {

    private static final String SQL_GET_ALL = "SELECT sp.idSanPham, sp.maSanPham, sp.tenSanPham, tl.tenTheLoai, th.tenThuongHieu, sp.trangThai "
            + "FROM SanPham sp "
            + "JOIN TheLoai tl ON sp.idTheLoai = tl.idTheLoai "
            + "JOIN ThuongHieu th ON sp.idThuongHieu = th.idThuongHieu";

    private static final String SQL_GET_ALL_BY_PAGES = "SELECT sp.idSanPham, sp.maSanPham, sp.tenSanPham, tl.tenTheLoai, th.tenThuongHieu, sp.trangThai "
        + "FROM SanPham sp "
        + "JOIN TheLoai tl ON sp.idTheLoai = tl.idTheLoai "
        + "JOIN ThuongHieu th ON sp.idThuongHieu = th.idThuongHieu "
        + "ORDER BY sp.idSanPham "
        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";


    public List<SanPham> getAll() {
        List<SanPham> sanPhams = new ArrayList<>();

        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getString("idSanPham"));
                sanPham.setMaSanPham(resultSet.getString("maSanPham"));
                sanPham.setTenSanPham(resultSet.getString("tenSanPham"));
                sanPham.setIdTheLoai(resultSet.getString("tenTheLoai"));
                sanPham.setIdThuongHieu(resultSet.getString("tenThuongHieu"));
                sanPham.setTrangThai(resultSet.getString("trangThai"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public List<SanPham> getAllByPages(int offset, int limit) {
        List<SanPham> sanPhams = new ArrayList<>();

        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_BY_PAGES)) {
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getString("idSanPham"));
                sanPham.setMaSanPham(resultSet.getString("maSanPham"));
                sanPham.setTenSanPham(resultSet.getString("tenSanPham"));
                sanPham.setIdTheLoai(resultSet.getString("tenTheLoai"));
                sanPham.setIdThuongHieu(resultSet.getString("tenThuongHieu"));
                sanPham.setTrangThai(resultSet.getString("trangThai"));
                sanPhams.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
    
    public void themSanPham(SanPham sanPham) {
    String sql = "INSERT INTO SanPham (maSanPham, tenSanPham, idTheLoai, idThuongHieu) VALUES (?, ?, ?, ?)";

    try (Connection connection = JDBC.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, sanPham.getMaSanPham());
        statement.setString(2, sanPham.getTenSanPham());
        statement.setString(3, sanPham.getIdTheLoai());
        statement.setString(4, sanPham.getIdThuongHieu());
        
        

        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Thêm sản phẩm thất bại!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
