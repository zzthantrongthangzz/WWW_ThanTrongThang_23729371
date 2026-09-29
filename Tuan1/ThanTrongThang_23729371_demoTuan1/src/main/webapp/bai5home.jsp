<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 15/09/2026
  Time: 2:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 5 - Trang chủ</title>
</head>
<body>
<h2>Xin chào, ${sessionScope.user}</h2>
<!-- Link trỏ vào thư mục bảo mật -->
<a href="${pageContext.request.contextPath}/bai5secure/bai5secure.jsp">Trang bảo mật</a><br><br>
<a href="${pageContext.request.contextPath}/bai5logout">Đăng xuất</a>
</body>
</html>