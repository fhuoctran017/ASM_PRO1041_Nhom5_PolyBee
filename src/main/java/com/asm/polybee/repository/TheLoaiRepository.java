/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.repository;
import com.asm.polybee.model.TheLoai;
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
public class TheLoaiRepository {
     private static final String SQL_GET_ALL = "SELECT * FROM TheLoai";

  public List<TheLoai> getAll() {
    List<TheLoai> theLoais = new ArrayList<>();
    try (Connection connection = JDBC.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
      while (resultSet.next()) {
        TheLoai theLoai = new TheLoai();
        theLoai.setIdTheloai(resultSet.getString("IdTheLoai"));
        theLoai.setTenTheLoai(resultSet.getString("TenTheLoai"));
        theLoai.setTrangThai(resultSet.getString("TrangThai"));
        theLoais.add(theLoai);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return theLoais;
  }
  
  public boolean themTheLoai(TheLoai theLoai) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("INSERT INTO TheLoai (TenTheLoai) VALUES ( ?)")) {
            statement.setString(1, theLoai.getTenTheLoai());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
