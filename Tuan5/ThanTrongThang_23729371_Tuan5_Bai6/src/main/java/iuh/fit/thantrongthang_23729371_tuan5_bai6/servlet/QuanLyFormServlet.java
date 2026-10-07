package iuh.fit.thantrongthang_23729371_tuan5_bai6.servlet;

import iuh.fit.thantrongthang_23729371_tuan5_bai6.dao.DanhSachTinTucQuanLy;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/tintuc/quanly")
public class QuanLyFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() { dao = new DanhSachTinTucQuanLy(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int maTT = Integer.parseInt(req.getParameter("id"));
            dao.deleteTinTuc(maTT);
            resp.sendRedirect(req.getContextPath() + "/tintuc/quanly");
            return;
        }

        req.setAttribute("tintucs", dao.getTinTucByDanhMuc(0));
        req.getRequestDispatcher("/QuanLyForm.jsp").forward(req, resp);
    }
}
