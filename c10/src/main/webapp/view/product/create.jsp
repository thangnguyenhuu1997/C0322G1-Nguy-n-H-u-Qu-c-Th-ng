<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>Title</title>
    <title>Employee Create Form</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/product?action=create" method="post">
            <div class="form-group">
                <label for="exampleFormControlInput1">Product Name</label>
                <input type="text" name="product_name" class="form-control" value="${product.product_name}"
                       id="exampleFormControlInput1"
                       placeholder="Acer" required>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput2">Price:</label>
                <input type="text" name="product_price" class="form-control" value="${product.product_price}"
                       id="exampleFormControlInput2"
                       placeholder="100000000" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Quantity:</label>
                <input type="text" name="product_quantity" class="form-control" value="${product.product_quantity}"
                       id="exampleFormControlInput3"
                       placeholder="1" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Color</label>
                <input type="text" name="product_color" class="form-control" value="${product.product_color}"
                       id="exampleFormControlInput4"
                       placeholder="Black" required>

            </div>

            <div class="form-group">
                <label for="exampleFormControlSelect1">Category</label>
                <select class="form-control" name="category_id" id="exampleFormControlSelect1">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.category_id}">${category.category_name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Save</button>
            </div>
        </form>
    </div>
</div>
<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
