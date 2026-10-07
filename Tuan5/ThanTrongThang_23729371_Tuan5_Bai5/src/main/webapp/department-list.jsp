<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 4:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Departments</title>
  <style>
    table { width: 100%; border-collapse: collapse; margin-top: 10px; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/HRbanner.jpg" width="100%" height="200" alt="Banner"/>
<h2>Departments List</h2>
<a href="${pageContext.request.contextPath}/departments?action=new">Add Department</a>
<br/><br/>

<form action="${pageContext.request.contextPath}/departments" method="get">
  Tìm phòng ban: <input type="text" name="keyword" value="${keyword}" />
  <input type="submit" value="Search"/>
</form>

<table>
  <tr>
    <th>DEPT ID</th>
    <th>Name Department</th>
    <th>Action</th>
  </tr>
  <c:forEach var="dept" items="${departments}">
    <tr>
      <td>${dept.id}</td>
      <td>${dept.name}</td>
      <td>
        <a href="departments?action=edit&id=${dept.id}">Edit</a> |
        <a href="departments?action=delete&id=${dept.id}">Delete</a> |
        <a href="employees?deptId=${dept.id}">Employees</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
