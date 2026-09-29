package iuh.fit.thantrongthang_23729371_tuan4_bai4.servlet;

import iuh.fit.thantrongthang_23729371_tuan4_bai4.beans.Book;
import iuh.fit.thantrongthang_23729371_tuan4_bai4.dao.BookDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/books", "/book"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Resource(name="jdbc/bookstoredb")
    private DataSource dataSource;

    @Override
    public void init() { bookDAO = new BookDAO(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if(idStr != null && !idStr.trim().isEmpty()) {
            Book book = bookDAO.getBookById(Integer.parseInt(idStr));
            req.setAttribute("book", book);
            req.getRequestDispatcher("/book-detail.jsp").forward(req, resp);
            return;
        }
        List<Book> books = bookDAO.getAllBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/book-list.jsp").forward(req, resp);
    }
}
