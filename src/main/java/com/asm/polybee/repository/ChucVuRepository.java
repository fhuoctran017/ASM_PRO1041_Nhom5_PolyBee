package com.asm.polybee.repository;

import com.asm.polybee.model.ChucVu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;

public class ChucVuRepository {

    private static final String SQL_GET_ALL = "SELECT * FROM ChucVu";

    public List<ChucVu> getAll() {
        List<ChucVu> chucVus = new ArrayList<>();
        try (Connection connection = JDBC.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
            while (resultSet.next()) {
                ChucVu chucVu = mapChucVu(resultSet);
                chucVus.add(chucVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chucVus;
    }

    private ChucVu mapChucVu(ResultSet resultSet) throws SQLException {
        ChucVu chucVu = new ChucVu();
        chucVu.setIdChucVu(resultSet.getString("idChucVu"));
        chucVu.setMaChucVu(resultSet.getString("maChucVu"));
        chucVu.setTenChucVu(resultSet.getString("tenChucVu"));
        return chucVu;
    }
}

