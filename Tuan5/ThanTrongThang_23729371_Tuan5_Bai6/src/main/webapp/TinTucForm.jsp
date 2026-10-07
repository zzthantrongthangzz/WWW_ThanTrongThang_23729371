<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 01/10/2026
  Time: 8:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Thêm Tin Tức Mới</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    form { max-width: 500px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; font-weight: bold; margin-bottom: 5px; }
    input[type="text"], textarea, select { width: 100%; padding: 8px; box-sizing: border-box; }
    .error-note { color: red; font-size: 0.9em; }
  </style>
</head>
<body>
<h2>Thêm Tin Tức Mới</h2>
<form action="${pageContext.request.contextPath}/tintuc/form" method="post">
  <div class="form-group">
    <label>Tiêu đề (*):</label>
    <input type="text" name="tieuDe" required />
  </div>

  <div class="form-group">
    <label>Liên kết (*):</label>
    <input type="text" name="lienKet" pattern="^http://.*" title="Liên kết phải bắt đầu bằng 'http://'" required />
    <span class="error-note">Bắt buộc bắt đầu bằng http://</span>
  </div>

  <div class="form-group">
    <label>Danh mục (*):</label>
    <select name="maDM" required>
      <option value="">-- Chọn danh mục --</option>
      <c:forEach var="dm" items="${danhmucs}">
        <option value="${dm.maDM}">${dm.tenDanhMuc}</option>
      </c:forEach>
    </select>
  </div>

  <div class="form-group">
    <label>Nội dung (*):</label>
    <textarea name="noiDungTT" rows="4" maxlength="255" title="Nội dung không được vượt quá 255 ký tự" required></textarea>
    <span class="error-note">Tối đa 255 ký tự</span>
  </div>

  <button type="submit">Thêm Tin Tức</button>
  <a href="${pageContext.request.contextPath}/tintuc">Hủy / Quay lại</a>
</form>
</body>
</html>
