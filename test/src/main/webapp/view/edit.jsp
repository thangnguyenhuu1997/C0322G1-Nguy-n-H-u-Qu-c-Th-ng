<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/11/2022
  Time: 7:54 AM
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
        <form action="/hokhau?action=update" method="post">
            <c:if test="${hokhau != null}">
                <input readonly name="stt" value="${hokhau.stt}"/>
            </c:if>
            <div class="form-group">
                <label for="exampleFormControlInput1">Tên chủ hộ:</label>
                <input type="text" name="ten_chu_ho" class="form-control" value="${hokhau.ten_chu_ho}"
                       id="exampleFormControlInput1" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Ngày lập hộ khẩu:</label>
                <input type="date" name="ngay_lap_ho_khau" class="form-control" value="${hokhau.ngay_lap_ho_khau}"
                       id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${hokhau.dia_chi}"
                       id="exampleFormControlInput4" required>

            </div>

            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Sửa</button>
            </div>
        </form>
    </div>
</div>
<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
