/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.repository;
import com.asm.polybee.model.ChatLieu;
import com.asm.polybee.model.MauSac;
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
public class MauSacRepository {
    private static final String SQL_GET_ALL = "SELECT * FROM MauSac";

  public List<MauSac> getAll() {
    List<MauSac> mauSacs = new ArrayList<>();
    try (Connection connection = JDBC.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
      while (resultSet.next()) {
        MauSac mauSac = new MauSac();
        mauSac.setIdMauSac(resultSet.getString("IdMauSac"));
        mauSac.setTenMauSac(resultSet.getString("TenMauSac"));
        mauSac.setTrangThai(resultSet.getString("TrangThai"));
        mauSacs.add(mauSac);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mauSacs;
  }
  
  public boolean themMauSac(MauSac mauSac) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("INSERT INTO MauSac (TenMauSac) VALUES ( ?)")) {
            statement.setString(1, mauSac.getTenMauSac());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
