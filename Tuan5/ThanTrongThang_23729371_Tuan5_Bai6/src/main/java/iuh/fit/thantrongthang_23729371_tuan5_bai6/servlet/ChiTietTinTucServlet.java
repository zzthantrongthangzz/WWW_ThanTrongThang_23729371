package iuh.fit.thantrongthang_23729371_tuan5_bai6.servlet;

import iuh.fit.thantrongthang_23729371_tuan5_bai6.dao.DanhSachTinTucQuanLy;
import iuh.fit.thantrongthang_23729371_tuan5_bai6.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/tintuc/chitiet")
public class ChiTietTinTucServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() {
        dao = new DanhSachTinTucQuanLy(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy mã tin tức từ URL
        int maTT = Integer.parseInt(req.getParameter("id"));

        // Gọi DAO lấy dữ liệu
        TinTuc tt = dao.getTinTucById(maTT);

        // Đẩy dữ liệu sang View
        req.setAttribute("tintuc", tt);
        req.getRequestDispatcher("/ChiTietTinTuc.jsp").forward(req, resp);
    }
}
