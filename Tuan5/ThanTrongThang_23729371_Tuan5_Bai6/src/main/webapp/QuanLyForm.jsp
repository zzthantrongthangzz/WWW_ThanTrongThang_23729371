<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 8:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Quản Lý Tin Tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #ffcccc; }
        .delete-btn { color: red; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
<h2>Quản Lý Phân Hệ Xóa Tin Tức</h2>
<a href="${pageContext.request.contextPath}/tintuc">Quay lại danh sách</a>

<table>
    <tr>
        <th>Mã TT</th>
        <th>Tiêu Đề</th>
        <th>Danh Mục (Mã)</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="tt" items="${tintucs}">
        <tr>
            <td>${tt.maTT}</td>
            <td>${tt.tieuDe}</td>
            <td>${tt.maDM}</td>
            <td>
                <a href="?action=delete&id=${tt.maTT}" class="delete-btn"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa tin tức [${tt.tieuDe}] không?');">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
