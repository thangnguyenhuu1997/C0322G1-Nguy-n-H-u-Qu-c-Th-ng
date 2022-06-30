<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Create Form</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse row w-100" >
            <div class="col-md-1">
                <img src="image/logo_furama_2.png" alt="" height="100px">
            </div>
            <div class="col-md-8">
                <ul class="navbar-nav mr-auto w-100" id="navbarSupportedContent">
                    <li class="nav-item active">
                        <a class="nav-link" href="/index.jsp">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-expanded="false">
                            Employee
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/employees">List Employee</a>
                            <a class="dropdown-item" href="/employees?action=create">Create New Employee</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
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
                        <a class="nav-link" href="/facility">Service<span class="sr-only">(current)</span></a>
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
    <div class="container w-50">
        <form action="/customers?action=create" method="post">
            <h3 style="align-content: center; color: #0069d9">Create Customer Form</h3>
            <div class="form-group">
                <label for="exampleFormControlInput1">Customer Code:</label>
                <input type="text" name="customerCode" value="${customer.customerCode}" class="form-control"
                       id="exampleFormControlInput1"
                       placeholder="KH-XXXX" required>
                <p style="color: red">${error.get("code")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Choose Type Customer</label>
                <select class="form-control" name="customerTypeId" id="exampleFormControlSelect1">
                    <c:forEach items="${typeList}" var="type">
                        <option value="${type.customerTypeId}">${type.customerTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Customer Name:</label>
                <input type="text" name="customerName" class="form-control" value="${customer.customerName}"
                       id="exampleFormControlInput2"
                       placeholder="Nguyen Van A" required>
                <p style="color: red">${error.get("name")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Customer Birth:</label>
                <input type="date" name="customerBirth" class="form-control" value="${customer.customerBirth}"
                       id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Choose Gender</label>
                <div id="exampleFormControlSelect2">
                    <input type="radio" name="customerGender" value="0" checked>Nam
                    <input type="radio" name="customerGender" value="1">Nữ
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Customer IDCard:</label>
                <input type="text" name="customerIdCard" class="form-control" value="${customer.customerIdCard}"
                       id="exampleFormControlInput4"
                       placeholder="XXXXXXXX or XXXXXXXXXX" required>
                <p style="color: red">${error.get("idCard")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Customer Phone:</label>
                <input type="text" name="customerPhone" class="form-control" value="${customer.customerPhone}"
                       id="exampleFormControlInput5"
                       placeholder="(84)90xxxxxxx or (84)91xxxxxxx" required>
                <p style="color: red">${error.get("phone")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Customer Email:</label>
                <input type="text" name="customerEmail" class="form-control" value="${customer.customerEmail}"
                       id="exampleFormControlInput6"
                       placeholder="abcxyz@gmail.com">
                <p style="color: #ff0000">${error.get("email")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput7">Customer Address:</label>
                <input type="text" name="customerAddress" class="form-control" value="${customer.customerAddress}"
                       id="exampleFormControlInput7" required>
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
