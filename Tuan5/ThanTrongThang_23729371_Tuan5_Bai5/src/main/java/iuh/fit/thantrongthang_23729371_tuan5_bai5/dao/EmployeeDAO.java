package iuh.fit.thantrongthang_23729371_tuan5_bai5.dao;

import iuh.fit.thantrongthang_23729371_tuan5_bai5.model.Employee;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private DBUtil dbutil;

    public EmployeeDAO(DataSource dataSource) {
        dbutil = new DBUtil(dataSource);
    }

    public Employee getById(int id) {
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE ID=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("ID"),
                            rs.getString("name"),
                            rs.getString("role"),
                            rs.getDouble("salary"),
                            rs.getInt("department_id"),
                            rs.getInt("position_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllByDepartment(int deptId) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department_id=?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Employee(
                            rs.getInt("ID"),
                            rs.getString("name"),
                            rs.getString("role"),
                            rs.getDouble("salary"),
                            rs.getInt("department_id"),
                            rs.getInt("position_id")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    public void save(Employee emp) {
        String sql = "INSERT INTO employees (name, role, salary, department_id, position_id) VALUES (?,?,?,?,?)";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getRole());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getDepartmentId());
            ps.setInt(5, emp.getPositionId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Employee emp) {
        String sql = "UPDATE employees SET name=?, role=?, salary=?, department_id=?, position_id=? WHERE ID=?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getRole());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getDepartmentId());
            ps.setInt(5, emp.getPositionId());
            ps.setInt(6, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE ID=?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}