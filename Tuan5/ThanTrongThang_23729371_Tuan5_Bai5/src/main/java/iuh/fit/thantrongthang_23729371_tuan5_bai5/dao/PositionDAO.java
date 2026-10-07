package iuh.fit.thantrongthang_23729371_tuan5_bai5.dao;

import iuh.fit.thantrongthang_23729371_tuan5_bai5.model.Position;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    private DBUtil dbutil;
    public PositionDAO(DataSource dataSource) { dbutil = new DBUtil(dataSource); }

    public List<Position> getAll() {
        List<Position> list = new ArrayList<>();
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM positions");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Position(rs.getInt("id"), rs.getString("title")));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
