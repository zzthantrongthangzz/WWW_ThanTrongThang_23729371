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

@WebServlet({"/tintuc", "/"})
public class DanhSachTinTucServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() { dao = new DanhSachTinTucQuanLy(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDMParam = req.getParameter("madm");
        int maDM = (maDMParam != null && !maDMParam.isEmpty()) ? Integer.parseInt(maDMParam) : 0;

        req.setAttribute("danhmucs", dao.getAllDanhMuc());
        req.setAttribute("tintucs", dao.getTinTucByDanhMuc(maDM));
        req.setAttribute("currentMaDM", maDM);

        req.getRequestDispatcher("/DanhSachTinTuc.jsp").forward(req, resp);
    }
}
