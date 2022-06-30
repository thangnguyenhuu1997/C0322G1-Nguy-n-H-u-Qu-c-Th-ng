<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Create Form</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse row w-100">
            <div class="col-md-1">
                <img src="image/logo_furama_2.png" alt="" height="100px">
            </div>
            <div class="col-md-8">
                <ul class="navbar-nav mr-auto w-100" id="navbarSupportedContent">
                    <li class="nav-item active">
                        <a class="nav-link" href="/index.jsp">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Employee<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-expanded="false">
                            Customer
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/customers">List Customer</a>
                            <a class="dropdown-item" href="/customers?action=create">Create New Customer</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Service<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Contract<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
            <div class="col-md-3">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<div class="create-form">
    <div class="main-form container w-50">
        <form action="/employees?action=create" method="post">
            <h3 style="align-content: center; color: #0069d9">Create Employee Form</h3>
            <div class="form-group">
                <label for="exampleFormControlInput1">Employee Name:</label>
                <input type="text" name="employeeName" value="${employee.employeeName}" class="form-control"
                       id="exampleFormControlInput1"
                       placeholder="Nguyễn Văn A" required>
                <p style="color: red">${error.get("name")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Employee Birthday:</label>
                <input type="date" name="employeeBirthday" class="form-control" value="${employee.employeeBirth}"
                       id="exampleFormControlInput2"
                       placeholder="Nguyen Van A" required>
                <p style="color: red">${error.get("")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Employee IDCard:</label>
                <input type="text" name="employeeIdCard" class="form-control" value="${employee.employeeIdCard}"
                       id="exampleFormControlInput3"
                       placeholder="XXXXXXXX or XXXXXXXXXX" required>
                <p style="color: red">${error.get("idCard")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Employee Salary:</label>
                <input type="number" name="employeeSalary" class="form-control" value="${employee.employeeSalary}"
                       id="exampleFormControlInput4"
                       placeholder="Số dương" required>
                <p style="color: red">${error.get("number")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Employee Phone:</label>
                <input type="text" name="employeePhone" class="form-control" value="${employee.employeePhone}"
                       id="exampleFormControlInput5"
                       placeholder="(84)xxxxxxxx or 0xxxxxxxx" required>
                <p style="color: red">${error.get("phone")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Employee Email:</label>
                <input type="text" name="employeeEmail" class="form-control" value="${employee.employeeEmail}"
                       id="exampleFormControlInput6"
                       placeholder="abcxyz@gmail.com">
                <p style="color: red">${error.get("email")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput7">Employee Address:</label>
                <input type="text" name="employeeAddress" class="form-control" value="${employee.employeeAddress}"
                       id="exampleFormControlInput7" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Choose Position</label>
                <select class="form-control" name="positionId" id="exampleFormControlSelect1">
                    <c:forEach items="${listPosition}" var="position">
                        <option value="${position.positionId}">${position.positionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Choose Education Degree</label>
                <select class="form-control" name="educationDegreeId" id="exampleFormControlSelect2">
                    <c:forEach items="${listDegree}" var="degree">
                        <option value="${degree.educationDegreeId}">${degree.educationDegreeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect3">Choose Division</label>
                <select class="form-control" name="divisionId" id="exampleFormControlSelect3">
                    <c:forEach items="${listDivision}" var="division">
                        <option value="${division.divisionId}">${division.divisionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="w-100">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Lưu</button>
            </div>
            <div class="w-100">
                <p style="color: forestgreen; alignment: center!important;">${message}</p>
            </div>
        </form>
    </div>
</div>

<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
