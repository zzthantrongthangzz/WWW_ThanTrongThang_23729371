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
<head><title>Department Information</title></head>
<body>
<img src="${pageContext.request.contextPath}/images/HRbanner.jpg" width="100%" height="200" alt="Banner"/>
<h2>Department Information</h2>
<form action="${pageContext.request.contextPath}/departments" method="post">
    <input type="hidden" name="id" value="${department != null ? department.id : ''}"/>
    Name: <input type="text" name="name" value="${department != null ? department.name : ''}" required/><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
