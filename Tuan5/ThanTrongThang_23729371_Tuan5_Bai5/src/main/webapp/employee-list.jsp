<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Employees List</title>
  <style>
    table { width: 100%; border-collapse: collapse; margin-top: 10px; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #d9edf7; } /* Màu xanh nhạt theo ảnh */
  </style>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/HRbanner.jpg" width="100%" height="200" alt="Banner"/>
<h2>Employees List</h2>
<a href="${pageContext.request.contextPath}/employees?action=new&deptId=${currentDeptId}">Add Employee</a>

<table>
  <tr>
    <th>ID</th>
    <th>Name Employee</th>
    <th>Role</th>
    <th>Salary</th>
    <th>Dept</th>
    <th>Position</th>
    <th>Action</th>
  </tr>
  <c:forEach var="emp" items="${employees}">
    <tr>
      <td>${emp.id}</td>
      <td>${emp.name}</td>
      <td>${emp.role}</td>
      <td>${emp.salary}</td>
      <td>${emp.departmentId}</td>
      <td>${emp.positionId}</td>
      <td>
        <a href="employees?action=edit&id=${emp.id}">Edit</a> |
        <a href="employees?action=delete&id=${emp.id}&deptId=${emp.departmentId}" onclick="return confirm('Xóa nhân viên này?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="${pageContext.request.contextPath}/departments">Department</a>
</body>
</html>
