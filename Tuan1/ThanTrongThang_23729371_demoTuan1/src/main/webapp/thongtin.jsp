<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin đã đăng ký</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; line-height: 1.6; }
        .result-box { border: 1px solid #ccc; padding: 20px; max-width: 500px; }
    </style>
</head>
<body>

<div class="result-box">
    <h2>Form Data Received:</h2>
    <p><b>Name:</b> ${name}</p>
    <p><b>Password:</b> ${password}</p>
    <p><b>Gender:</b> ${gender}</p>
    <p><b>Hobbies:</b> ${hobbies}</p>
    <p><b>Country:</b> ${country}</p>
    <p><b>Birth Date:</b> ${birthDate}</p>
    <p><b>Uploaded File:</b> ${fileName}</p>
    <p><b>Saved to:</b> ${uploadPath}</p>

    <br>
    <a href="${pageContext.request.contextPath}/bai4index.jsp">Quay lại form</a>
</div>

</body>
</html>