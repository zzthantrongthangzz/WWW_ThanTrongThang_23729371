<%--
  Created by IntelliJ IDEA.
  User: Trong Thang
  Date: 28/09/2026
  Time: 8:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .page-container {
            border: 2px solid;
            padding: 20px;
            width: fit-content;
        }
        .product-container {
            display: flex;
            gap: 15px;
            margin-top: 10px;
        }
        .product-class {
            border: 1px solid black;
            padding: 15px;
            text-align: center;
            width: 180px;
        }
        .product-class img {
            width: 120px;
            height: 120px;
            object-fit: contain;
        }
        .product-class input[type="text"] {
            width: 50px;
            text-align: center;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="page-container">
        <p>
            <a href="cart">View Cart</a>
        </p>
        <div class="product-container">
            <c:forEach items="${products}" var="p">
                <div class="product-class">
                    <b> ${p.model}</b>
                    <br/>
                    <img src="images/${p.imgURL}" class="hinh"> <br/>
                    Price: ${p.price}<br/>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="text" size="2" value="1" name="quantity"> <br/>
                        <input type="hidden" name="id" value="${p.id}">
                        <input type="hidden" name="price" value="${p.price}">
                        <input type="hidden" name="model" value="${p.model}">
                        <input type="hidden" name="action" value="add"><br/>
                        <input type="submit" name="addToCart" value="Add To Cart"><br/>
                    </form>
                    <a href="${pageContext.request.contextPath}/product?id=${p.id}">Product Detail</a><br/>
                </div>
            </c:forEach>
        </div>

    </div>

</body>
</html>
