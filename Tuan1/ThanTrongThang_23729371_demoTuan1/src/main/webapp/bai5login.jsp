<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 5 - Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<!-- Hiện thông báo lỗi nếu đăng nhập sai -->
<p style="color:red;">${error}</p>

<form action="${pageContext.request.contextPath}/bai5login" method="post">
    Tên đăng nhập: <input type="text" name="username"><br><br>
    Mật khẩu: <input type="password" name="password"><br><br>
    <input type="submit" value="Đăng nhập">
</form>
</body>
</html>