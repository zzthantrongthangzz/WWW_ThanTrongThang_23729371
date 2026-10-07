package iuh.fit.thantrongthang_23729371_tuan5_bai5.dao;

import iuh.fit.thantrongthang_23729371_tuan5_bai5.model.Department;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private DBUtil dbutil;
    public DepartmentDAO(DataSource dataSource) { dbutil = new DBUtil(dataSource); }

    public List<Department> getAll() {
        List<Department> list = new ArrayList<>();
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM departments");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Department(rs.getInt("id"), rs.getString("name")));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Department> searchByName(String keyword) {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM departments WHERE name LIKE ?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(new Department(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public Department getById(int id) {
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM departments WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Department(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public void save(Department d) {
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO departments (name) VALUES (?)")) {
            ps.setString(1, d.getName());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void update(Department d) {
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE departments SET name=? WHERE id=?")) {
            ps.setString(1, d.getName());
            ps.setInt(2, d.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM departments WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
