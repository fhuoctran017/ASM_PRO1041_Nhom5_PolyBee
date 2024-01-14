/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asm.polybee.repository;

import com.asm.polybee.model.SanPhamChiTiet;
import com.asm.polybee.model.Size;
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
public class SizeRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM Size";

    private static final String SQL_INSERT = "INSERT INTO Size (Size) VALUES ( ?)";

    public List<Size> getAll() {
        List<Size> sizes = new ArrayList<>();
        try ( Connection connection = JDBC.getConnection();  Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
            while (resultSet.next()) {
                Size size = new Size();
                size.setIdSize(resultSet.getString("IdSize"));
                size.setSize(resultSet.getString("Size"));
                size.setTrangThai(resultSet.getString("TrangThai"));
                sizes.add(size);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizes;
    }

    public boolean themSize(Size size) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("INSERT INTO Size (Size) VALUES ( ?)")) {
            statement.setString(1, size.getSize());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
