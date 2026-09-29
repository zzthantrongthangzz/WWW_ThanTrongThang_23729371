package com.fit.demotuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

// Mapping đúng với action của form
@WebServlet("/processFormUpload")
// Bắt buộc phải có MultipartConfig để xử lý form có enctype="multipart/form-data"
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,      // 1MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 15     // 15MB
)
public class Bai4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Thiết lập encoding để đọc tiếng Việt không bị lỗi font
        req.setCharacterEncoding("utf-8");

        // 1. Lấy dữ liệu từ các thành phần text, password, radio, select, date
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String birthDate = req.getParameter("birthDate");

        // Lấy dữ liệu từ checkbox (trả về mảng String)
        String[] hobbies = req.getParameterValues("hobbies");

        // 2. Xử lý lấy file và lưu file
        Part filePart = req.getPart("profilePic");
        String fileName = filePart.getSubmittedFileName();

        // Định nghĩa thư mục lưu file (lưu vào thư mục uploads ở user.home)
        String uploadPath = System.getProperty("user.home") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Ghi file vào thư mục nếu có file được upload
        if (fileName != null && !fileName.isEmpty()) {
            filePart.write(uploadPath + File.separator + fileName);
        }

        // Xử lý chuỗi hobbies và fileName cho đẹp trước khi gửi qua JSP
        String hobbiesStr = (hobbies != null) ? String.join(", ", hobbies) : "None";
        String finalFileName = (fileName != null && !fileName.isEmpty()) ? fileName : "No file";

        // Đưa dữ liệu vào thuộc tính của Request để chuyển sang JSP
        req.setAttribute("name", name);
        req.setAttribute("password", password);
        req.setAttribute("gender", gender);
        req.setAttribute("hobbies", hobbiesStr);
        req.setAttribute("country", country);
        req.setAttribute("birthDate", birthDate);
        req.setAttribute("fileName", finalFileName);
        req.setAttribute("uploadPath", uploadPath);

        // Forward (chuyển tiếp) request và response sang file thongtin.jsp
        req.getRequestDispatcher("/thongtin.jsp").forward(req, resp);
    }
}