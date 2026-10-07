<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 10:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Chi Tiết Tin Tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        .container { border: 1px solid #ccc; padding: 20px; border-radius: 8px; max-width: 600px; }
        .back-link { display: inline-block; margin-top: 15px; text-decoration: none; color: blue; }
    </style>
</head>
<body>
<div class="container">
    <h2>Trang chi tiết tin tức</h2>
    <hr/>
    <h3>Tiêu đề: ${tintuc.tieuDe}</h3>

    <a href="${pageContext.request.contextPath}/tintuc" class="back-link">⬅ Quay lại danh sách</a>
</div>
</body>
</html>