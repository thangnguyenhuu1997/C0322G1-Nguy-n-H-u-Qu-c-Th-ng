<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Create Form</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/customers" method="post">
            <input type="text" name="action" value="create" hidden>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Chọn loại khách</label>
                <select class="form-control" name="customer_type_id" id="exampleFormControlSelect1">
                    <c:forEach items="${typeList}" var="type">
                        <option value="${type.customer_type_id}">${type.customer_type_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Tên khách hàng</label>
                <input type="text" name="customer_name" class="form-control" value="${customer.customer_name}"
                       id="exampleFormControlInput2"
                       placeholder="Nguyen Van A" required>
                <p style="color: red">${error.get("customer_name")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Ngày sinh:</label>
                <input type="date" name="customer_birthday" class="form-control" value="${customer.customer_birthday}"
                       id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Giới tính:</label>
                <div id="exampleFormControlSelect2">
                    <input type="radio" name="customer_gender" value="0" checked>Nam
                    <input type="radio" name="customer_gender" value="1">Nữ
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Số chứng minh nhân dân:</label>
                <input type="text" name="customer_id_card" class="form-control" value="${customer.customer_id_card}"
                       id="exampleFormControlInput4"
                       placeholder="XXXXXXXX or XXXXXXXXXX" required>
                <p style="color: red">${error.get("customer_id_card")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Số điện thoại</label>
                <input type="text" name="customer_phone" class="form-control" value="${customer.customer_phone}"
                       id="exampleFormControlInput5"
                       placeholder="(84)90xxxxxxx or (84)91xxxxxxx" required>
                <p style="color: red">${error.get("customer_phone")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Email:</label>
                <input type="text" name="customer_email" class="form-control" value="${customer.customer_email}"
                       id="exampleFormControlInput6"
                       placeholder="abcxyz@gmail.com">
                <p style="color: #ff0000">${error.get("customer_email")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput7">Địa chỉ:</label>
                <input type="text" name="customer_address" class="form-control" value="${customer.customer_address}"
                       id="exampleFormControlInput7" required>
            </div>
            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Lưu</button>
            </div>
        </form>
    </div>
</div>
<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
