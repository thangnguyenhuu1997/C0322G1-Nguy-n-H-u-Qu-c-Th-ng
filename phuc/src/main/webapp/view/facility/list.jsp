<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Facility Page</title>
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
<c:if test="${mess!=null}">
    <p style="color: #0c5460">${mess}</p>
</c:if>
<div class="container">
    <div class="row w-100 mx-auto" style="text-align: center">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <a class="btn btn-outline-primary" href="/facility?action=create">Create New Service</a>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<div class="container-fluid">
    <table class="table table-striped table-responsive w-100">
        <thead>
        <tr>
            <th scope="col">ID Dịch vụ</th>
            <th scope="col">Tên dịch vụ</th>
            <th scope="col">Diện tích phòng</th>
            <th scope="col">Giá phòng</th>
            <th scope="col">Số người tối đa</th>
            <th scope="col">Kiểu thuê</th>
            <th scope="col">Loại dịch vụ</th>
            <th scope="col">Tiêu chuẩn phòng</th>
            <th scope="col">Mô tả khác</th>
            <th scope="col">Diện tích hồ bơi</th>
            <th scope="col">Số tầng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${facilityList}" var="facility">
            <tr>
                <th scope="row">${facility.serviceId}</th>
                <td>${facility.serviceName}</td>
                <td>${facility.serviceArea}</td>
                <td>${facility.serviceCost}</td>
                <td>${facility.serviceMaxPeople}</td>
                <td>${mapRentType.get(facility.rentTypeId)}</td>
                <td>${mapServiceType.get(facility.serviceTypeId)}</td>
                <td>${facility.standardRoom}</td>
                <td>${facility.description}</td>
                <td>${facility.poolArea}</td>
                <td>${facility.numberOfFloor}</td>
                <td><a class="btn btn-primary" href="/facility?action=update&facilityId=${facility.serviceId}">Edit</a></td>
                <td><input id="del" onclick="showInfo('${facility.serviceId}','${facility.serviceName}')"
                           data-toggle="modal" data-target="#modal1" type="button"
                           class="btn  btn-outline-danger" value="Delete">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="modal fade" id="modal1" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/facility?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input id="serviceId" name="serviceId">
                    <span>Chắc chắn muốn xóa</span><span id="serviceName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function showInfo(id, name) {
        document.getElementById("serviceName").innerText = name;
        document.getElementById("serviceId").value = id;
    }
</script>
<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
