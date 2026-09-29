package iuh.fit.demotuan1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/bai6upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,      // 1MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class Bai6UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Thư mục lưu file trên server (trong thư mục webapp)
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Lấy tất cả file từ request
        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                // Ghi file vào thư mục
                part.write(uploadPath + File.separator + fileName);
            }
        }

        // Hiển thị thông báo thành công
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3>Files uploaded successfully to " + uploadPath + "</h3>");
        resp.getWriter().println("<br><a href='" + req.getContextPath() + "/bai6upload.jsp'>Quay lại trang Upload</a>");
    }

    // Hàm hỗ trợ bóc tách tên file từ header của Part theo hướng dẫn của Bài 6
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");

        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return null;
    }
}
