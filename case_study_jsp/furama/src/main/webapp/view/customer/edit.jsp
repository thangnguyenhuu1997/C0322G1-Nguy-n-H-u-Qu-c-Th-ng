<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/customers?action=update" method="post">
            <c:if test="${customer != null}">
                <input type="hidden" name="customer_id" value="<c:out value='${customer.customer_id}'  />"/>
            </c:if>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Chọn loại khách</label>
                <select class="form-control" name="customer_type_id" id="exampleFormControlSelect1">
                    <c:forEach items="${typeList}" var="type">
                        <c:choose>
                            <c:when test="${type.customer_type_id == customer.customer_type_id}">
                                <option selected  value="${type.customer_type_id}">${type.customer_type_name}</option>
                            </c:when>
                            <c:otherwise>
                                <option  value="${type.customer_type_id}">${type.customer_type_name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Tên Khách Hàng:</label>
                <input type="text" name="customer_name" class="form-control" value="${customer.customer_name}"
                       id="exampleFormControlInput2" required>
                <p style="color: red">${error.get("customer_name")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Ngày sinh:</label>
                <input type="date" name="customer_birthday" class="form-control" value="${customer.customer_birthday}"
                       id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Giới tính</label>
                <div id="exampleFormControlSelect2">
                    <input type="radio" name="customer_gender" value="0" checked>Nam
                    <input type="radio" name="customer_gender" value="1">Nữ
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Số chứng minh nhân dân:</label>
                <input type="text" name="customer_id_card" class="form-control" value="${customer.customer_id_card}"
                       id="exampleFormControlInput4" required>
                <p style="color: red">${error.get("customer_id_card")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Số điện thoại:</label>
                <input type="text" name="customer_phone" class="form-control" value="${customer.customer_phone}"
                       id="exampleFormControlInput5" required>
                <p style="color: red">${error.get("customer_phone")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Email:</label>
                <input type="text" name="customer_email" class="form-control" value="${customer.customer_email}"
                       id="exampleFormControlInput6" required>
                <p style="color: red">${error.get("customer_email")}</p>
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
