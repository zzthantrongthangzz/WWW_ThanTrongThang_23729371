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

@WebServlet("/tintuc/form")
public class TinTucFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() { dao = new DanhSachTinTucQuanLy(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhmucs", dao.getAllDanhMuc());
        req.getRequestDispatcher("/TinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String tieuDe = req.getParameter("tieuDe");
        String noiDungTT = req.getParameter("noiDungTT");
        String lienKet = req.getParameter("lienKet");
        int maDM = Integer.parseInt(req.getParameter("maDM"));

        TinTuc tt = new TinTuc(0, tieuDe, noiDungTT, lienKet, maDM);
        dao.addTinTuc(tt);

        resp.sendRedirect(req.getContextPath() + "/tintuc");
    }
}
