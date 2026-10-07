package iuh.fit.thantrongthang_23729371_tuan5_bai5.servlet;

import iuh.fit.thantrongthang_23729371_tuan5_bai5.dao.DepartmentDAO;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.model.Department;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/departments"})
public class DepartmentServlet extends HttpServlet {
    @Resource(name = "jdbc/employee_db")
    private DataSource dataSource;
    private DepartmentDAO deptDao;

    @Override
    public void init() { deptDao = new DepartmentDAO(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                req.getRequestDispatcher("/department-form.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("department", deptDao.getById(id));
                req.getRequestDispatcher("/department-form.jsp").forward(req, resp);
                break;
            case "delete":
                deptDao.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect(req.getContextPath() + "/departments");
                break;
            default: // list & search
                String keyword = req.getParameter("keyword");
                List<Department> list;
                if (keyword != null && !keyword.trim().isEmpty()) {
                    list = deptDao.searchByName(keyword.trim());
                    req.setAttribute("keyword", keyword);
                } else {
                    list = deptDao.getAll();
                }
                req.setAttribute("departments", list);
                req.getRequestDispatcher("/department-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");

        Department dept = new Department();
        dept.setName(name);

        if (idParam != null && !idParam.isEmpty()) {
            dept.setId(Integer.parseInt(idParam));
            deptDao.update(dept);
        } else {
            deptDao.save(dept);
        }
        resp.sendRedirect(req.getContextPath() + "/departments");
    }
}
