<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 8:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh Sách Tin Tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .nav { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
<h2>Danh Sách Tin Tức Theo Danh Mục</h2>
<div class="nav">
    <a href="${pageContext.request.contextPath}/tintuc">Tất cả</a> |
    <c:forEach var="dm" items="${danhmucs}">
        <a href="?madm=${dm.maDM}">${dm.tenDanhMuc}</a> |
    </c:forEach>
</div>

<div class="nav">
    <a href="${pageContext.request.contextPath}/tintuc/form">[+] Thêm Tin Tức</a> |
    <a href="${pageContext.request.contextPath}/tintuc/quanly">Quản Lý (Xóa)</a>
</div>

<table>
    <tr>
        <th>Mã TT</th>
        <th>Tiêu Đề</th>
        <th>Nội Dung</th>
        <th>Liên Kết</th>
    </tr>
    <c:forEach var="tt" items="${tintucs}">
        <tr>
            <td>${tt.maTT}</td>
            <td>${tt.tieuDe}</td>
            <td>${tt.noiDungTT}</td>
            <td><a href="${pageContext.request.contextPath}/tintuc/chitiet?id=${tt.maTT}">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
