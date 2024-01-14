package com.asm.polybee.repository;

import com.asm.polybee.model.ChatLieu;
import com.asm.polybee.model.Size;
import com.asm.polybee.model.ThuongHieu;
import com.asm.polybee.service.ChatLieuService;
import com.asm.polybee.service.Impl.ChatLieuServiceImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.JDBC;


public class ChatLieuRepository {
    private static final String SQL_GET_ALL = "SELECT * FROM ChatLieu";

  public List<ChatLieu> getAll() {
      List<ChatLieu> chatLieus = new ArrayList<>();
    try (Connection connection = JDBC.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SQL_GET_ALL)) {
      while (resultSet.next()) {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setIdChatLieu(resultSet.getString("IdChatLieu"));
        chatLieu.setTenChatLieu(resultSet.getString("TenChatLieu"));
        chatLieu.setTrangThai(resultSet.getString("TrangThai"));
        chatLieus.add(chatLieu);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return chatLieus;
  }
  
  public static void main(String[] args) {
        ChatLieuService chatLieuService = new ChatLieuServiceImpl();
        List<ChatLieu> allSizes = chatLieuService.getAll();

        // In ra dữ liệu của Size
        System.out.println("Dữ liệu của Size:");
        for (ChatLieu chatLieu : allSizes) {
            System.out.println("ID: " + chatLieu.getIdChatLieu()+
                    ", Chat Lieu: " + chatLieu.getTenChatLieu()+
                    ", Trang Thai: " + chatLieu.getTrangThai());
        }
    }
  
  public boolean themChatLieu(ChatLieu chatLieu) {
        try ( Connection connection = JDBC.getConnection();  PreparedStatement statement = connection.prepareStatement("INSERT INTO ChatLieu (TenChatLieu) VALUES ( ?)")) {
            statement.setString(1, chatLieu.getTenChatLieu());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
