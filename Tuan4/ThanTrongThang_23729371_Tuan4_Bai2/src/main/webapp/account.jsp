<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Danh Sách Tài Khoản</title>
  <style>table, th, td { border: 1px solid black; padding: 8px; }</style>
</head>
<body>
<h2>Danh Sách Đăng Ký Thành Công</h2>
<table>
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Birthday</th>
  </tr>
  <c:forEach var="acc" items="${accounts}">
    <tr>
      <td>${acc.id}</td>
      <td>${acc.firstname}</td>
      <td>${acc.lastname}</td>
      <td>${acc.email}</td>
      <td>${acc.dateOfBirth}</td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="RegisterForm.jsp">Đăng ký người mới</a>
</body>
</html>
