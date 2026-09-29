package iuh.fit.thantrongthang_23729371_tuan4_bai4.dao;


import iuh.fit.thantrongthang_23729371_tuan4_bai4.beans.Book;
import iuh.fit.thantrongthang_23729371_tuan4_bai4.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private DBUtil dbUtil;
    public BookDAO(DataSource dataSource) { dbUtil = new DBUtil(dataSource); }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"), rs.getString("tittle"),
                        rs.getString("author"), rs.getDouble("price"), rs.getString("imgbook")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Book(
                        rs.getInt("id"), rs.getString("tittle"),
                        rs.getString("author"), rs.getDouble("price"), rs.getString("imgbook")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
