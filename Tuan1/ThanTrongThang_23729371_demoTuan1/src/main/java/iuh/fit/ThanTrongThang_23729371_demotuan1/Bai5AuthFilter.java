package iuh.fit.demotuan1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Filter lọc tất cả các request đi vào thư mục /bai5secure/
@WebFilter("/bai5secure/*")
public class Bai5AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        if (loggedIn) {
            // Cho phép đi tiếp vào tài nguyên nếu đã login
            chain.doFilter(request, response);
        } else {
            // Nếu chưa login, đẩy về trang đăng nhập
            res.sendRedirect(req.getContextPath() + "/bai5login.jsp");
        }
    }
}