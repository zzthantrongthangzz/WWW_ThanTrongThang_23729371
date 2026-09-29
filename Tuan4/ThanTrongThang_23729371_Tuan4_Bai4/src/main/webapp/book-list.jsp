<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 28/09/2026
  Time: 10:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>IUH BOOKSTORE</title>
    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .header-bg { background-color: #7b6d61; color: white; padding: 15px; }
        .nav-link { color: white !important; font-weight: bold; }
        .sidebar { background-color: #f8f9fa; padding: 20px; height: 100vh; }
        .book-card { border: 1px solid #ddd; text-align: center; padding: 10px; margin-bottom: 20px; }
        .book-card img { height: 180px; object-fit: contain; }
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
            <p class="text-muted" style="font-size:12px;">About us information will be here...</p>
            <hr>
            <h5>SEARCH SITE</h5>
            <input type="text" class="form-control mb-3">
            <a href="${pageContext.request.contextPath}/cart">Shopping cart (${cart.items.size()})</a>
        </div>

        <!-- Content Phải -->
        <div class="col-md-9">
            <div class="row">
                <c:forEach items="${books}" var="b">
                    <div class="col-md-3">
                        <div class="book-card">
                            <p class="text-muted mb-1" style="font-size:11px;">${b.tittle} - ${b.author}</p>
                            <h6>${b.tittle}</h6>
                            <img src="${pageContext.request.contextPath}/imgesbook/${b.imgBook}" alt="${b.tittle}" class="img-fluid mb-2">
<%--                            <p class="mb-0">Price: ${b.price}</p>--%>
                            <p class="mb-0">Price: <b><fmt:formatNumber value="${b.price}" pattern="#,###"/></b></p>

                            <form action="${pageContext.request.contextPath}/cart" method="post" class="mt-2">
                                Quantity: <input type="number" name="quantity" value="1" style="width: 40px;"><br>
                                <a href="${pageContext.request.contextPath}/book?id=${b.id}" style="font-size:12px;">Product details</a><br>
                                <input type="hidden" name="id" value="${b.id}">
                                <input type="hidden" name="action" value="add">
                                <button type="submit" class="btn btn-sm btn-outline-secondary mt-1">Add to cart</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>