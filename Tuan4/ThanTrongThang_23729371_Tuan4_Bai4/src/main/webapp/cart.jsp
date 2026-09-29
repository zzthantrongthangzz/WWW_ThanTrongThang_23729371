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
  <title>Giỏ hàng - IUH BOOKSTORE</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .header-bg { background-color: #7b6d61; color: white; padding: 15px; }
    .nav-link { color: white !important; font-weight: bold; }
    .sidebar { background-color: #f8f9fa; padding: 20px; height: 100vh; }
    .table th { background-color: #2c3e50 !important; color: white !important; }
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

    <!-- Content Phải - Giỏ Hàng -->
    <div class="col-md-9">
      <h6 class="text-center text-muted mb-3">YOUR SHOPPING CART</h6>

      <table class="table table-bordered text-center align-middle">
        <thead>
        <tr>
          <th>Product ID</th>
          <th>Product name</th>
          <th>Price</th>
          <th>Qty</th>
          <th>Total</th>
          <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
          <c:when test="${empty cart.items}">
            <tr>
              <td colspan="6">Giỏ hàng của bạn đang trống!</td>
            </tr>
          </c:when>
          <c:otherwise>
            <c:forEach var="item" items="${cart.items}">
              <tr>
                <td>${item.book.id}</td>
                <td class="text-start">${item.book.tittle} - Tác giả: ${item.book.author}</td>
                <td><fmt:formatNumber value="${item.book.price}" pattern="#,###"/></td>
                <td>${item.quantity}</td>
                <td><fmt:formatNumber value="${item.book.price * item.quantity}" pattern="#,###"/></td>
                <td>
                  <form action="${pageContext.request.contextPath}/cart" method="post" class="m-0">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="productId" value="${item.book.id}">
                    <button type="submit" class="btn btn-link text-dark p-0" style="text-decoration: underline; font-size: 14px;">Remove</button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
        <tr>
          <td colspan="4" class="text-end border-0 text-muted">Total price</td>
          <td colspan="2" class="border-0 text-start text-muted">(VNĐ) <b><fmt:formatNumber value="${cart.total}" pattern="#,###"/></b></td>
        </tr>
        </tbody>
      </table>

      <div class="mt-3">
        <a href="${pageContext.request.contextPath}/checkout.jsp" class="btn btn-light border btn-sm text-secondary">Checkout</a>
        <a href="${pageContext.request.contextPath}/books" class="btn btn-light border btn-sm text-secondary">Continue shopping</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>
