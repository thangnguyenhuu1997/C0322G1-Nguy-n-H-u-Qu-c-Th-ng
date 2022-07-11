<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 01/07/2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <%--    DataTables 1.10.21 support bootstrap <= 4.1.3--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style>
        #carouselExampleIndicators {
            position: relative;
        }

        #furama-logo img {
            position: absolute;
            width: 48px;
            height: 70px;
            top: 20px;
            left: 30px;
        }

        a:hover {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                        aria-label="Slide 4"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="p1.PNG" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="p2.PNG" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="p3.PNG" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="p4.PNG" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>

    <div class="row" id="furama-logo">
        <a href="https://furamavietnam.com/vi/" class="headertext"><img class="mob-standard-logo"
                                                                        src="logo.png"
                                                                        alt=" Logo Header Menu"></a>
    </div>
</div>

<div class="container-fluid">
    <div class="row mt-4">
        <nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
            <div class="container-fluid">
                <div class="collapse navbar-collapse px-5" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 px-5">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee" target="_self">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer" target="_self">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/facility" target="_self">Facility</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract" target="_self">Contract</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2 mt-4">
            <div class="container-fluid">
                <div class="row pb-3">
                    <img src="r1.PNG" alt="">
                </div>
            </div>

            <div class="container-fluid">
                <div class="row pb-3">
                    <img src="r2.PNG" alt="">
                </div>
            </div>

            <div class="container-fluid">
                <div class="row pb-3">
                    <img src="r3.PNG" alt="">
                </div>
            </div>

            <div class="container-fluid">
                <div class="row pb-3">
                    <img src="r4.PNG" alt="">
                </div>
            </div>

            <div class="container-fluid">
                <div class="row pb-3">
                    <img src="r5.PNG" alt="">
                </div>
            </div>

            <div class="container-fluid">
                <div class="row">
                    <img src="r6.PNG" alt="">
                </div>
            </div>
        </div>

        <div class="col-lg-10 mt-4">
            <div class="container-fluid">
                <div class="row">
                    <caption><h2 align="center">Danh sách nhân viên</h2></caption>
                    <form class="row g-3" action="/employee" method="get">
                        <div class="col-auto">
                            <input type="text" hidden name="action" value="search">
                            <input type="text" class="form-control" name="keySearch" placeholder="Search Anything">
                        </div>
                        <div class="col-auto">
                            <button type="submit" class="btn btn-primary mb-3">Search</button>
                        </div>
                    </form>
                    <table class="table table-striped table-bordered" id="tableCustomer" style="width:100%">
                        <thead>
                        <tr class="table-success">
                            <th>ID</th>
                            <th>Name</th>
                            <th>Birthday</th>
                            <th>ID Card</th>
                            <th>Salary</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Position</th>
                            <th>Eduction Degree</th>
                            <th>Division</th>
                            <th>Username</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employee" items="${employeeList}">
                            <tr>
                                <td><c:out value="${employee.id}"/></td>
                                <td><c:out value="${employee.name}"/></td>
                                <td><c:out value="${employee.birthDay}"/></td>
                                <td><c:out value="${employee.idCard}"/></td>
                                <td><c:out value="${employee.salary}"/></td>
                                <td><c:out value="${employee.phone}"/></td>
                                <td><c:out value="${employee.email}"/></td>
                                <td><c:out value="${employee.address}"/></td>
                                <c:forEach var="postion" items="${positionList}">
                                    <c:if test="${postion.positionId == employee.positionId}">
                                        <td>
                                            <c:out value="${postion.positionName}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="educationDegree" items="${educationDegreeList}">
                                    <c:if test="${educationDegree.educationDegreeId == employee.educationDegreeId}">
                                        <td>
                                            <c:out value="${educationDegree.educationDegreeName}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="division" items="${divisionList}">
                                    <c:if test="${division.divisionId == employee.divisionId}">
                                        <td>
                                            <c:out value="${division.divisionName}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>
                                <c:forEach var="user" items="${userList}">
                                    <c:if test="${user.username == employee.username}">
                                        <td>
                                            <c:out value="${user.username}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>
                                <td>
                                    <button type="button" class="btn btn-primary"
                                            onclick="infoEdit('${employee.id}', '${employee.name}', '${employee.birthDay}', '${employee.idCard}', '${employee.salary}', '${employee.phone}', '${employee.email}', '${employee.address}', '${employee.positionId}', '${employee.educationDegreeId}', '${employee.divisionId}', '${employee.username}')"
                                            data-bs-toggle="modal" data-bs-target="#editModal">
                                        Edit
                                    </button>
                                </td>
                                <td>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary"
                                            onclick="infoDelete('${employee.id}','${employee.name}')"
                                            data-bs-toggle="modal" data-bs-target="#deleteModal">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <h2>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#createModal">
                            Add New Employee
                        </button>
                    </h2>
                </div>
            </div>


        </div>
    </div>
</div>
<hr>
<div class="container-fluid">
    <div class="row mt-4">
        <div class="col-lg-12" style="text-align: center">
            <div class="container-fluid">
                <div class="row">
                    <h4 style="font-size: 24px;color: #cbbe73;line-height: 36px;text-align: center;font-family:Playfair Display;font-weight:700;font-style:normal"
                        class="vc_custom_heading">Liên hệ </h4>
                </div>
            </div>

            <div class="container-fluid">
                <div class="row">
                    <p style="font-family: Playfair Display">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                        </svg>
                        103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam
                    </p>
                    <p style="font-family: Playfair Display">Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</p>
                    <p style="font-family: Playfair Display">Email: reservation@furamavietnam.com *
                        www.furamavietnam.com</p>
                    <p style="font-family: Playfair Display">GDS Codes: Amadeus-GD DADFUR,
                        Galileo/Apollo-GD 16236, Sabre-GD 032771, Worldspan- GD DADFU</p>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Cập nhật thông tin nhân viên</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="action" value="edit">
                    <c:if test="${message != null}">
                        <span class="fw-bolder text-danger">${message}</span>
                    </c:if>
                    <table class="table" cellpadding="5">
                        <tr>
                            <th>ID:</th>
                            <td>
                                <input type="text" name="id" id="idEdit" readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>Name:</th>
                            <td>
                                <input type="text" name="name" size="45" id="nameEdit"/>
                                <p class="text-danger">${error.get("name")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Birthday:</th>
                            <td>
                                <input type="date" name="birthDay" size="45" id="birthDayEdit"/>
                            </td>
                        </tr>
                        <tr>
                            <th>ID Card:</th>
                            <td>
                                <input type="text" name="idCard" size="45" id="idCardEdit"/>
                                <p class="text-danger">${error.get("idCard")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Salary:</th>
                            <td>
                                <input type="text" name="salary" size="45" id="salaryEdit"/>
                                <p class="text-danger">${error.get("salary")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Phone:</th>
                            <td>
                                <input type="text" name="phone" size="45" id="phoneEdit"/>
                                <p class="text-danger">${error.get("phone")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>
                                <input type="text" name="email" size="45" id="emailEdit"/>
                                <p class="text-danger">${error.get("email")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Address:</th>
                            <td>
                                <input type="text" name="address" size="45" id="addressEdit"/>
                                <p class="text-danger">${error.get("address")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Position:</th>
                            <td>
                                <select name="positionId" id="positionIdEdit">
                                    <option value="">Chọn vị trí</option>
                                    <c:forEach items="${positionList}" var="position">
                                        <option value="${position.positionId}">${position.positionName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Education Degree:</th>
                            <td>
                                <select name="educationDegreeId" id="educationDegreeIdEdit">
                                    <option value="">Chọn bằng cấp</option>
                                    <c:forEach items="${educationDegreeList}" var="educationDegree">
                                        <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Division:</th>
                            <td>
                                <select name="divisionId" id="divisionIdEdit">
                                    <option value="">Chọn bộ phận</option>
                                    <c:forEach items="${divisionList}" var="division">
                                        <option value="${division.divisionId}">${division.divisionName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Username:</th>
                            <td>
                                <select name="username" id="usernameEdit">
                                    <option value="">Chọn username</option>
                                    <c:forEach items="${userList}" var="user">
                                        <option value="${user.username}">${user.username}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function infoEdit(id, name, birthDay, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username) {
        document.getElementById("idEdit").value = id;
        document.getElementById("nameEdit").value = name;
        document.getElementById("birthDayEdit").value = birthDay;
        document.getElementById("idCardEdit").value = idCard;
        document.getElementById("salaryEdit").value = salary;
        document.getElementById("phoneEdit").value = phone;
        document.getElementById("emailEdit").value = email;
        document.getElementById("addressEdit").value = address;
        document.getElementById("positionIdEdit").value = positionId;
        document.getElementById("educationDegreeIdEdit").value = educationDegreeId;
        document.getElementById("divisionIdEdit").value = divisionId;
        document.getElementById("usernameEdit").value = username;
    }
</script>

<!-- Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="idDelete" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa nhân viên: </span>
                    <span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>

<!-- Create Modal -->
<div class="modal fade" id="createModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="createModalLabel">Thêm mới nhân viên</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="action" value="create">
                    <c:if test="${message != null}">
                        <span class="fw-bolder text-danger">${message}</span>
                    </c:if>
                    <table class="table" cellpadding="5">
                        <tr>
                            <th>Name:</th>
                            <td>
                                <input type="text" name="name" id="name" size="45"/>
                                <p class="text-danger">${error.get("name")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Birthday:</th>
                            <td>
                                <input type="date" name="birthDay" id="birthDay" size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>ID Card:</th>
                            <td>
                                <input type="text" name="idCard" id="idCard" size="45"/>
                                <p class="text-danger">${error.get("idCard")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Salary:</th>
                            <td>
                                <input type="text" name="salary" id="salary" size="45"/>
                                <p class="text-danger">${error.get("salary")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Phone:</th>
                            <td>
                                <input type="text" name="phone" id="phone" size="45"/>
                                <p class="text-danger">${error.get("phone")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>
                                <input type="text" name="email" id="email" size="45"/>
                                <p class="text-danger">${error.get("email")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Address:</th>
                            <td>
                                <input type="text" name="address" id="address" size="45"/>
                                <p class="text-danger">${error.get("address")}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>Position:</th>
                            <td>
                                <select name="positionId" id="positionId">
                                    <option value="">Chọn vị trí</option>
                                    <c:forEach items="${positionList}" var="position">
                                        <option value="${position.positionId}">${position.positionName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Education Degree:</th>
                            <td>
                                <select name="educationDegreeId" id="educationDegreeId">
                                    <option value="">Chọn bằng cấp</option>
                                    <c:forEach items="${educationDegreeList}" var="educationDegree">
                                        <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Division:</th>
                            <td>
                                <select name="divisionId" id="divisionId">
                                    <option value="">Chọn bộ phận</option>
                                    <c:forEach items="${divisionList}" var="division">
                                        <option value="${division.divisionId}">${division.divisionName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Username:</th>
                            <td>
                                <select name="username" id="username">
                                    <option value="">Chọn username</option>
                                    <c:forEach items="${userList}" var="user">
                                        <option value="${user.username}">${user.username}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
