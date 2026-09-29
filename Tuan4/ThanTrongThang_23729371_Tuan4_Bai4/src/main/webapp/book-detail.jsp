<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 28/09/2026
  Time: 10:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
  <title>Chi tiết sách - IUH BOOKSTORE</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .header-bg { background-color: #7b6d61; color: white; padding: 15px; }
    .nav-link { color: white !important; font-weight: bold; }
    .sidebar { background-color: #f8f9fa; padding: 20px; height: 100vh; }
  </style>
</head>
<body>
<!-- Header -->
<div class="header-bg d-flex justify-content-between align-items-center">
  <h2>IUH BOOKSTORE</h2>
  <nav class="nav">
    <a class="nav-link" href="${pageContext.request.contextPath}/books">HOME</a>
    <a class="nav-link" href="#">EXAMPLES</a>
    <a class="nav-link" href="#">SERVICES</a>
    <a class="nav-link" href="#">PRODUCTS</a>
    <a class="nav-link" href="#">CONTACT</a>
  </nav>
</div>

<div class="container-fluid mt-3">
  <div class="row">
    <!-- Sidebar Trái -->
    <div class="col-md-3 sidebar">
      <h5>ABOUT US</h5>
      <p class="text-muted" style="font-size:12px;">About us information will be here... <a href="#" class="text-secondary">Read More »</a></p>
      <hr>
      <h5>SEARCH SITE</h5>
      <input type="text" class="form-control mb-3">
      <a href="${pageContext.request.contextPath}/cart" class="text-secondary">Shopping cart (<c:out value="${cart.items.size() != null ? cart.items.size() : 0}"/>)</a>
    </div>

    <!-- Content Phải - Chi Tiết Sách -->
    <div class="col-md-9">
      <p class="text-muted" style="font-size:13px;">Product details: ${book.tittle} - Tác giả: ${book.author}</p>

      <div style="width: 250px;">
        <h3 style="color: #8b5a2b;" class="text-center">${book.tittle}</h3>
        <div class="text-center p-3 mb-3" style="background-color: #f0ebe1; border: 1px solid #ddd;">
          <img src="${pageContext.request.contextPath}/imgesbook/${book.imgBook}" alt="${book.tittle}" class="img-fluid" style="max-height: 250px;">
        </div>
        <p class="mb-0 text-muted">Price (VNĐ): <b><fmt:formatNumber value="${book.price}" pattern="#,###"/></b></p>
        <p class="text-muted">Quantity: 10</p>

        <a href="${pageContext.request.contextPath}/books" class="text-secondary" style="text-decoration: underline; font-size: 14px;">Back to Product List</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>