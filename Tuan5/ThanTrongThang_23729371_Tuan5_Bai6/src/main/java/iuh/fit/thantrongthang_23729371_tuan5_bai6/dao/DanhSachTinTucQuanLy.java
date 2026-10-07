package iuh.fit.thantrongthang_23729371_tuan5_bai6.dao;

import iuh.fit.thantrongthang_23729371_tuan5_bai6.model.DanhMuc;
import iuh.fit.thantrongthang_23729371_tuan5_bai6.model.TinTuc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLy {
    private DataSource dataSource;

    public DanhSachTinTucQuanLy(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<DanhMuc> getAllDanhMuc(){
        List<DanhMuc> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM danhmuc");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt("MADM"), rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"), rs.getString("GHICHU")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<TinTuc> getTinTucByDanhMuc(int maDM) {
        List<TinTuc> list = new ArrayList<>();
        String sql = (maDM <= 0) ? "SELECT * FROM tintuc" : "SELECT * FROM tintuc WHERE MADM=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (maDM > 0) ps.setInt(1, maDM);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new TinTuc(rs.getInt("MATT"), rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"), rs.getString("LIENKET"), rs.getInt("MADM")));
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void addTinTuc(TinTuc tt) {
        String sql = "INSERT INTO tintuc (TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tt.getTieuDe());
            ps.setString(2, tt.getNoiDungTT());
            ps.setString(3, tt.getLienKet());
            ps.setInt(4, tt.getMaDM());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteTinTuc(int maTT) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM tintuc WHERE MATT=?")) {
            ps.setInt(1, maTT);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public TinTuc getTinTucById(int maTT) {
        String sql = "SELECT * FROM tintuc WHERE MATT=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maTT);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new TinTuc(
                            rs.getInt("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getInt("MADM")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
