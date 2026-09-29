<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài 4 - Form Upload</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; }
    </style>
</head>
<body>

<h2>HTML Form Example with File Upload</h2>

<!-- enctype bắt buộc khi upload file -->
<form action="${pageContext.request.contextPath}/processFormUpload" method="post" enctype="multipart/form-data">

    <div class="form-group">
        <label>Name:</label>
        <input type="text" name="name">
    </div>

    <div class="form-group">
        <label>Password:</label>
        <input type="password" name="password">
    </div>

    <div class="form-group">
        <label>Gender:</label>
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female
    </div>

    <div class="form-group">
        <label>Hobbies:</label>
        <input type="checkbox" name="hobbies" value="Reading"> Reading
        <input type="checkbox" name="hobbies" value="Sports"> Sports
        <input type="checkbox" name="hobbies" value="Music"> Music
    </div>

    <div class="form-group">
        <label>Country:</label>
        <select name="country">
            <option value="Vietnam">Vietnam</option>
            <option value="USA">USA</option>
            <option value="Japan">Japan</option>
        </select>
    </div>

    <div class="form-group">
        <label>Birth Date:</label>
        <input type="date" name="birthDate">
    </div>

    <div class="form-group">
        <label>Profile Picture:</label>
        <input type="file" name="profilePic">
    </div>

    <input type="submit" value="Submit">
</form>

</body>
</html>