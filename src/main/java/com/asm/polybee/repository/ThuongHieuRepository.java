/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.repository;
import com.asm.polybee.model.TheLoai;
import com.asm.polybee.model.ThuongHieu;
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
public class ThuongHieuRepository {
     private static final String SQL_GET_ALL = "SELECT * FROM ThuongHieu";

  public List<ThuongHieu> getAll() {
    List<ThuongHieu> thuongHieus = new ArrayList<>();
    try (Connection connection = JDBC.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
      while (resultSet.next()) {
        ThuongHieu thuongHieu = new ThuongHieu();
        thuongHieu.setIdThuongHieu(resultSet.getString("IdThuongHieu"));
        thuongHieu.setTenThuongHieu(resultSet.getString("TenThuongHieu"));
        thuongHieu.setTrangThai(resultSet.getString("TrangThai"));
        thuongHieus.add(thuongHieu);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return thuongHieus;
  }
  
  public boolean themThuongHieu(ThuongHieu thuongHieu) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("INSERT INTO ThuongHieu (TenThuongHieu) VALUES ( ?)")) {
            statement.setString(1, thuongHieu.getTenThuongHieu());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
