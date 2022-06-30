<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Facility Page</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/style.css">
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
        <form action="/facility?action=create" method="post">
            <h3 style="text-align: center; color: #f1b0b7">Create Facility Form</h3>
            <div class="form-group">
                <label for="exampleFormControlInput1">Service Name:</label>
                <input type="text" name="serviceName" value="${facility.serviceName}" class="form-control"
                       id="exampleFormControlInput1"
                       placeholder="DV-XXXX (X = 0-9)" required>
                <p style="color: red">${error.get("name")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput2">Service Area Name:</label>
                <input type="number" name="serviceArea" class="form-control" value="${facility.serviceArea}"
                       id="exampleFormControlInput2"
                       placeholder="Số dương" required>
                <p style="color: red">${error.get("number")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput3">Service Cost:</label>
                <input type="number" name="serviceCost" class="form-control" value="${facility.serviceCost}"
                       placeholder="Số dương" id="exampleFormControlInput3" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput4">Max People:</label>
                <input type="number" name="serviceMaxPeople" class="form-control" value="${facility.serviceMaxPeople}"
                       id="exampleFormControlInput4"
                       placeholder="Số dương" required>
                <p style="color: red">${error.get("number")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Choose Rent Type:</label>
                <select class="form-control" name="rentTypeId" id="exampleFormControlSelect1">
                    <c:forEach items="${rentTypeList}" var="rType">
                        <option value="${rType.rentTypeId}">${rType.rentTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Choose Service Type:</label>
                <select class="form-control" name="serviceTypeId" id="exampleFormControlSelect2">
                    <c:forEach items="${serviceTypeList}" var="sType">
                        <option value="${sType.serviceTypeId}">${sType.serviceTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput5">Standard Room:</label>
                <input type="text" name="standardRoom" class="form-control" value="${facility.standardRoom}"
                       id="exampleFormControlInput5" required>
                <p style="color: red">${error.get("")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput6">Description:</label>
                <input type="text" name="description" class="form-control" value="${facility.description}"
                       id="exampleFormControlInput6" required>
                <p style="color: red">${error.get("")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput7">Pool Area:</label>
                <input type="number" name="poolArea" class="form-control" value="${facility.poolArea}"
                       placeholder="Số dương" id="exampleFormControlInput7" required>
                <p style="color: red">${error.get("number")}</p>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput8">Number Of Floor:</label>
                <input type="number" name="numberOfFloor" class="form-control" value="${facility.numberOfFloor}"
                       placeholder="Số dương" id="exampleFormControlInput8" required>
                <p style="color: red">${error.get("number")}</p>
            </div>
            <div class="w-100" style="display:  flex">
                <button type="submit" class="btn btn-success w-50" style="alignment: center">Lưu</button>
                <a href="/facility" class="btn btn-secondary w-50">Quay lại</a>
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
