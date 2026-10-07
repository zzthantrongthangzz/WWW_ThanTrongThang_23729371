package iuh.fit.thantrongthang_23729371_tuan5_bai5.servlet;

import iuh.fit.thantrongthang_23729371_tuan5_bai5.dao.DepartmentDAO;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.dao.EmployeeDAO;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.dao.PositionDAO;
import iuh.fit.thantrongthang_23729371_tuan5_bai5.model.Employee;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    @Resource(name = "jdbc/employee_db")
    private DataSource dataSource;

    private EmployeeDAO empDao;
    private DepartmentDAO deptDao;
    private PositionDAO posDao;

    @Override
    public void init() {
        empDao = new EmployeeDAO(dataSource);
        deptDao = new DepartmentDAO(dataSource);
        posDao = new PositionDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        String deptIdParam = req.getParameter("deptId");
        int deptId = (deptIdParam != null && !deptIdParam.isEmpty()) ? Integer.parseInt(deptIdParam) : 1;

        switch (action) {
            case "new":
                req.setAttribute("deptId", deptId);
                req.setAttribute("departments", deptDao.getAll());
                req.setAttribute("positions", posDao.getAll());
                req.getRequestDispatcher("/employee-form.jsp").forward(req, resp);
                break;
            case "edit":
                int empId = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("employee", empDao.getById(empId));
                req.setAttribute("departments", deptDao.getAll());
                req.setAttribute("positions", posDao.getAll());
                req.getRequestDispatcher("/employee-form.jsp").forward(req, resp);
                break;
            case "delete":
                empDao.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("employees?deptId=" + deptId);
                break;
            default: // list
                req.setAttribute("currentDeptId", deptId);
                req.setAttribute("employees", empDao.getAllByDepartment(deptId));
                req.getRequestDispatcher("/employee-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idParam = req.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        String name = req.getParameter("name");
        String role = req.getParameter("role");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        int positionId = Integer.parseInt(req.getParameter("positionId"));

        Employee emp = new Employee(id, name, role, salary, departmentId, positionId);

        if (id > 0) empDao.update(emp);
        else empDao.save(emp);

        resp.sendRedirect("employees?deptId=" + departmentId);
    }
}