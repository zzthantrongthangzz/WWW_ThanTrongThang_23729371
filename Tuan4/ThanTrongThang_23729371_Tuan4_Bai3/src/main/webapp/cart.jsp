<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 28/09/2026
  Time: 8:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            border: 2px solid;
            padding: 20px;
            width: 800px;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .table th, .table td {
            border-bottom: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        .table th {
            font-size: 18px;
        }
    </style>
</head>
<body>
  <div class="container">
      <h2>Cart</h2>
      <c:if test="${empty cart.items}">
        <p>Cart is emppty!</p>
      </c:if>

    <c:if test="${not empty cart.items}">
      <table class="table table-border">
        <tr>
          <th>Model</th>
          <th>Quantity</th>
          <th>Price</th>
          <th>Total</th>
          <th>Actions</th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
         <tr>
            <td>${item.product.model}</td>
            <td>
                <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                  <input type="hidden" name="action" value="update"/>
                  <input type="hidden" name="productId" value="${item.product.id}"/>
                  <input type="number" name="quantity" value="${item.quantity}" min="1"/>
                  <input type="submit" value="Update"/>
                </form>
            </td>
            <td>${item.product.price}</td>
            <td>${item.product.price * item.quantity}</td>
            <td>
                <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                  <input type="hidden" name="action" value="remove"/>
                  <input type="hidden" name="productId" value="${item.product.id}"/>
                  <input type="submit" value="Remove"/>
                </form>
            </td>
        </tr>
        </c:forEach>
      </table>
      <p><strong>Total: </strong> ${cart.total}</p>

        <form action="${pageContext.request.contextPath}/cart" method="post" style="margin-top: 20px;">
            <input type="hidden" name="action" value="clear"/>
            <input type="submit" value="Clear All" style="padding: 5px 10px;"/>
        </form>

    </c:if>
      <a href="product">Continute Shopping</a>
  </div>

</body>
</html>
