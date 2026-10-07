<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 4:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Employee Information</title></head>
<body>
<img src="${pageContext.request.contextPath}/images/HRbanner.jpg" width="100%" height="200" alt="Banner"/>
<h2>Employee Information</h2>
<form action="${pageContext.request.contextPath}/employees" method="post">
    <input type="hidden" name="id" value="${employee != null ? employee.id : ''}"/>

    Name: <input type="text" name="name" value="${employee != null ? employee.name : ''}" required/><br/>
    Role: <input type="text" name="role" value="${employee != null ? employee.role : ''}" required/><br/>
    Salary: <input type="number" step="0.01" name="salary" value="${employee != null ? employee.salary : ''}" required/><br/>

    Department:
    <select name="departmentId">
        <c:forEach var="dep" items="${departments}">
            <option value="${dep.id}"
                ${(employee != null && employee.departmentId == dep.id) || (employee == null && deptId == dep.id) ? 'selected' : ''}>
                    ${dep.name}
            </option>
        </c:forEach>
    </select><br/>

    Position:
    <select name="positionId">
        <c:forEach var="pos" items="${positions}">
            <option value="${pos.id}" ${employee != null && employee.positionId == pos.id ? 'selected' : ''}>
                    ${pos.title}
            </option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Save"/>
</form>
</body>
</html>
