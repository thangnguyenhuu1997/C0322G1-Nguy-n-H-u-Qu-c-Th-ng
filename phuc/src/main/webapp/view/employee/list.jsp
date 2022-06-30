<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Employee<span class="sr-only">(current)</span></a>
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
                        <a class="nav-link" href="#">Service<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Contract<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
            <div class="col-md-3">
                <form class="form-inline my-2 my-lg-0" action="/customers?action=search" method="get">
                    <input class="form-control mr-sm-2" type="search" name="keyword" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<c:if test="${mess!=null}">
    <p style="color: #0c5460">${mess}</p>
</c:if>
<table class="table table-striped table-responsive">
    <thead>
    <tr>
        <th scope="col">ID nhân viên</th>
        <th scope="col">Tên nhân viên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Số CMND</th>
        <th scope="col">Mức lương</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Email</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Vị trí</th>
        <th scope="col">Trình độ</th>
        <th scope="col">Bộ phận</th>
        <th scope="col">Username</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <th scope="row">${employee.employeeId}</th>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeBirth}</td>
            <td>${employee.employeeIdCard}</td>
            <td>${employee.employeeSalary}</td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeAddress}</td>
            <td>${mapPosition.get(employee.positionId)}</td>
            <td>${mapEducationDegree.get(employee.educationDegreeId)}</td>
            <td>${mapDivision.get(employee.divisionId)}</td>
            <td>${employee.username}</td>
            <td><a class="btn btn-primary" href="/employees?action=update&employeeId=${employee.employeeId}">Edit</a></td>
            <td><input id="del" onclick="showInfo('${employee.employeeId}','${employee.employeeName}')"
                       data-toggle="modal" data-target="#modal1" type="button"
                       class="btn  btn-outline-danger" value="Delete">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="modal1" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employees?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input id="employeeId" name="employeeId">
                    <span>Chắc chắn muốn xóa</span><span id="employeeName"></span>
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
        document.getElementById("employeeName").innerText = name;
        document.getElementById("employeeId").value = id;
    }
</script>
<script src="bootstrap/js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
