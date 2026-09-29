<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 28/09/2026
  Time: 10:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
  <title>Thanh toán - IUH BOOKSTORE</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .header-bg { background-color: #7b6d61; color: white; padding: 15px; }
    .nav-link { color: white !important; font-weight: bold; }
    .sidebar { background-color: #f8f9fa; padding: 20px; height: 100vh; }
    .table td { vertical-align: middle; }
    .td-label { background-color: #f8f9fa !important; width: 25%; color: #666; font-size: 14px; }
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

    <!-- Content Phải - Thanh Toán -->
    <div class="col-md-9">
      <p class="text-center text-muted" style="font-size: 13px;">Checkout - Already registered? ...</p>

      <table class="table table-bordered">
        <tbody>
        <tr>
          <td class="td-label">Fullname:</td>
          <td><input type="text" name="fullname" class="form-control form-control-sm w-50"></td>
        </tr>
        <tr>
          <td class="td-label">Shipping address:</td>
          <td><input type="text" name="address" class="form-control form-control-sm w-75"></td>
        </tr>
        <tr>
          <td class="td-label">Total price:</td>
          <td>
            <input type="text" name="total" value="<fmt:formatNumber value='${cart.total}' pattern='#'/>" readonly class="form-control form-control-sm w-50 bg-light text-muted">
          </td>
        </tr>
        <tr>
          <td class="td-label">Payment method:</td>
          <td>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="payment" id="pay1" value="paypal" checked>
              <label class="form-check-label text-muted" for="pay1" style="font-size: 13px;">Paypal</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="payment" id="pay2" value="atm">
              <label class="form-check-label text-muted" for="pay2" style="font-size: 13px;">ATM Debit</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="payment" id="pay3" value="visa">
              <label class="form-check-label text-muted" for="pay3" style="font-size: 13px;">Visa/Master card</label>
            </div>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button type="submit" class="btn btn-light border btn-sm text-secondary px-3">Save</button>
            <button type="reset" class="btn btn-light border btn-sm text-secondary px-3">Cancel</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>