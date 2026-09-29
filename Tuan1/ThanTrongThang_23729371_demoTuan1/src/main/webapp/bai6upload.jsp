<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 15/09/2026
  Time: 2:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 6 - Upload Multi Files</title>
</head>
<body>
<h2>Upload multi-files</h2>

<form action="${pageContext.request.contextPath}/bai6upload" method="post" enctype="multipart/form-data">
    File #1: <input type="file" name="file"/><br/><br/>
    File #2: <input type="file" name="file"/><br/><br/>
    File #3: <input type="file" name="file"/><br/><br/>
    File #4: <input type="file" name="file"/><br/><br/>
    File #5: <input type="file" name="file"/><br/><br/>

    <input type="submit" value="Upload"/>
    <input type="reset" value="Reset"/>
</form>

</body>
</html>
