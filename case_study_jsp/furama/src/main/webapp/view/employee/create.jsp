<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2022
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Create Form</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<div class="create-form">
    <div class="container w-50">
        <form action="/employee?action=create" method="post">
            <div class="form-group">
                <label for="exampleFormControlInput1">Tên nhân viên</label>
                <input type="text" name="employee_name" class="form-control" value="${employee.employee_name}"
                       id="exampleFormControlInput1"
                       placeholder="Nguyen Van A" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Ngày sinh:</label>
                <input type="date" name="employee_birthday" class="form-control" value="${employee.employee_birthday}"
                       id="exampleFormControlInput2" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Số chứng minh nhân dân:</label>
                <input type="text" name="employee_id_card" class="form-control" value="${employee.employee_id_card}"
                       id="exampleFormControlInput3"
                       placeholder="XXXXXXXX or XXXXXXXXXX" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Lương:</label>
                <input type="text" name="employee_salary" class="form-control" value="${employee.employee_salary}"
                       id="exampleFormControlInput4"
                       placeholder="1000000" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Số điện thoại</label>
                <input type="text" name="employee_phone" class="form-control" value="${employee.employee_phone}"
                       id="exampleFormControlInput5"
                       placeholder="(84)90xxxxxxx or (84)91xxxxxxx" required>

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Email:</label>
                <input type="text" name="employee_email" class="form-control" value="${employee.employee_email}"
                       id="exampleFormControlInput6"
                       placeholder="abcxyz@gmail.com">

            </div>
            <div class="form-group">
                <label for="exampleFormControlInput7">Địa chỉ:</label>
                <input type="text" name="employee_address" class="form-control" value="${employee.employee_address}"
                       id="exampleFormControlInput7" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Vị trí</label>
                <select class="form-control" name="position_id" id="exampleFormControlSelect1">
                    <c:forEach items="${positionList}" var="position">
                        <option value="${position.position_id}">${position.position_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Trình độ học vấn</label>
                <select class="form-control" name="education_degree_id" id="exampleFormControlSelect2">
                    <c:forEach items="${educationDegreeList}" var="educationDegree">
                        <option value="${educationDegree.education_degree_id}">${educationDegree.education_degree_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect3">Bộ phận làm việc</label>
                <select class="form-control" name="division_id" id="exampleFormControlSelect3">
                    <c:forEach items="${divisionList}" var="division">
                        <option value="${division.division_id}">${division.division_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput8">Username:</label>
                <input type="text" name="username" class="form-control" value="${employee.username}"
                       id="exampleFormControlInput8" required>
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
