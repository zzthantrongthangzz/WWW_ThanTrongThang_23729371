package iuh.fit.thantrongthang_23729371_tuan4_bai4.servlet;

import iuh.fit.thantrongthang_23729371_tuan4_bai4.beans.Book;
import iuh.fit.thantrongthang_23729371_tuan4_bai4.beans.CartBean;
import iuh.fit.thantrongthang_23729371_tuan4_bai4.dao.BookDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private BookDAO bookDAO;

    // Đổi tên kết nối sang database của bài 4
    @Resource(name = "jdbc/bookstoredb")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            bookDAO = new BookDAO(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        try {
            if ("add".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));

                Book b = bookDAO.getBookById(id);
                cart.addBook(b, quantity);

                resp.sendRedirect("books"); // Chuyển hướng về danh sách sách
                return;

            } else if ("update".equals(action)) {
                int id = Integer.parseInt(req.getParameter("productId"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cart.updateQuantity(id, quantity);

            } else if ("remove".equals(action)) {
                int id = Integer.parseInt(req.getParameter("productId"));
                cart.removeBook(id);

            } else if ("clear".equals(action)) {
                cart.clear();

            } else if ("checkout".equals(action)) {
                // Chuyển hướng sang trang thanh toán
                resp.sendRedirect("checkout.jsp");
                return;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        resp.sendRedirect("cart");
    }
}
