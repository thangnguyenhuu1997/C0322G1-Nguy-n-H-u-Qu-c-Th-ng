<%@ page import="model.ContractDetail" %>
<%@ page import="java.util.List" %>
<%@ page import="service.ContractDetailService" %>
<%@ page import="service.impl.ContractDetailServiceImpl" %>
<%@ page import="service.AttachFacilityService" %>
<%@ page import="service.impl.AttachFacilityServiceImpl" %>
<%@ page import="model.AttachFacility" %>
<%@ page import="java.io.PrintWriter" %><%--
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
                    <caption><h2 align="center">Danh sách hợp đồng</h2></caption>
                    <table class="table table-striped table-bordered tableContract" style="width:100%">
                        <thead>
                        <tr class="table-success">
                            <th>ID</th>
                            <th>Ngày bắt đầu</th>
                            <th>Ngày kết thúc</th>
                            <th>Deposit</th>
                            <th>Employee</th>
                            <th>Customer</th>
                            <th>Facility</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="contractFacility" items="${contractFacilityList}">
                            <tr>
                                <td><c:out value="${contractFacility.contractId}"/></td>
                                <td><c:out value="${contractFacility.startDate}"/></td>
                                <td><c:out value="${contractFacility.endDate}"/></td>
                                <td><c:out value="${contractFacility.deposit}"/></td>


                                <c:forEach var="employee" items="${employeeList}">
                                    <c:if test="${employee.id == contractFacility.employeeId}">
                                        <td>
                                            <c:out value="${employee.name}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>

                                <c:forEach var="customer" items="${customerList}">
                                    <c:if test="${customer.id == contractFacility.customerId}">
                                        <td>
                                            <c:out value="${customer.name}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>

                                <c:forEach var="facility" items="${facilityList}">
                                    <c:if test="${facility.id == contractFacility.facilityId}">
                                        <td>
                                            <c:out value="${facility.name}"/>
                                        </td>
                                    </c:if>
                                </c:forEach>

                                <td>
                                    <button type="button" class="btn btn-primary"
                                            onclick="getInfoContract('${contractFacility.contractId}', '${contractFacility.deposit}')"
                                            data-bs-toggle="modal" data-bs-target="#addContractDetailModal">
                                        +
                                    </button>
                                </td>

                                <td>
                                    <button type="submit" class="btn btn-primary" id="listFacility"
                                            data-bs-toggle="modal" data-bs-target="#infoAttachFacilityModal">
                                        Danh sách dịch vụ đi kèm
                                    </button>
                                </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <h2>
                        <a href="/contract?action=create">
                            <button type="button" class="btn btn-primary">Add New Contract</button>
                        </a>
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


<!-- Add Contract Detail Modal -->
<div class="modal fade" id="addContractDetailModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="/contract" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addContractDetailLabel">Thêm mới hợp đồng chi tiết</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="action" value="createContractDetail">

                    <table class="table" cellpadding="5">
                        <tr>
                            <th>ID Contract:</th>
                            <td>
                                <input type="text" readonly name="contractId" id="contractId">
                            </td>
                        </tr>
                        <tr>
                            <th>Attach Facility:</th>
                            <td>
                                <select name="attachFacilityId" id="attachFacilityId"
                                        onchange="displayAttachFacility(this)">
                                    <option value="" selected>Chọn dịch vụ đi kèm</option>
                                    <c:forEach items="${attachFacilityList}" var="attachFacility">
                                        <option value="${attachFacility.id}">${attachFacility.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Deposit:</th>
                            <td>
                                <input type="text" name="deposit" id="deposit" size="45" oninput="changeDeposit()"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Cost:</th>
                            <td>
                                <input type="text" name="cost" id="cost" size="45" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <th>Unit:</th>
                            <td>
                                <input type="text" name="unit" id="unit" size="45" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <th>Status:</th>
                            <td>
                                <input type="text" name="status" id="status" size="45" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <th>Quantity:</th>
                            <td>
                                <input type="text" name="quantity" id="quantity" size="45" oninput="changeDeposit()"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Total money:</th>
                            <td>
                                <input readonlytype="text" name="total" id="total" size="45" readonly/>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="xoa()" data-bs-dismiss="modal">Hủy bỏ</button>
                    <button type="submit" class="btn btn-primary">Tạo hợp đồng</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function getInfoContract(id, deposit) {
        document.getElementById("contractId").value = id;
        document.getElementById("deposit").value = deposit;
    }
</script>
<script>
    function displayAttachFacility(attachFacilityId) {
        if (attachFacilityId.value == 1) {
            document.getElementById("cost").value = 10000;
            document.getElementById("unit").value = "giờ";
            document.getElementById("status").value = "tiện nghi, hiện tại";
        }

        if (attachFacilityId.value == 2) {
            document.getElementById("cost").value = 10000;
            document.getElementById("unit").value = "chiếc";
            document.getElementById("status").value = "hỏng 1 xe";
        }

        if (attachFacilityId.value == 3) {
            document.getElementById("cost").value = 20000;
            document.getElementById("unit").value = "chiếc";
            document.getElementById("status").value = "tốt";
        }

        if (attachFacilityId.value == 4) {
            document.getElementById("cost").value = 15000;
            document.getElementById("unit").value = "suất";
            document.getElementById("status").value = "đầy đủ đồ ăn, tráng miệng";
        }

        if (attachFacilityId.value == 5) {
            document.getElementById("cost").value = 90000;
            document.getElementById("unit").value = "suất";
            document.getElementById("status").value = "đầy đủ đồ ăn, tráng miệng";
        }

        if (attachFacilityId.value == 6) {
            document.getElementById("cost").value = 16000;
            document.getElementById("unit").value = "suất";
            document.getElementById("status").value = "đầy đủ đồ ăn, tráng miệng";
        }
    }

    function changeDeposit() {
        let costAttachFacility = Number(document.getElementById("cost").value);
        let depositMoney = Number(document.getElementById("deposit").value);
        let quantityAttachFacility = Number(document.getElementById("quantity").value);
        document.getElementById("total").value = depositMoney + quantityAttachFacility * costAttachFacility;
    }

    function xoa() {
        document.getElementById("deposit").value = "";
        document.getElementById("quantity").value = "";
        document.getElementById("total").value = "";
    }
</script>

<!-- Attach Facility Modal -->
<div class="modal fade" id="infoAttachFacilityModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="/contract" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="infoAttachFacilityModalLabel">Danh sách dịch vụ đi kèm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped table-bordered tableContract" style="width:100%">
                       <thead>
                       <tr class="table-success">
                           <th>ID</th>
                           <th>Name</th>
                           <th>Cost</th>
                           <th>Unit</th>
                           <th>Status</th>
                       </tr>
                       </thead>
                        <tbody>
                        <c:forEach var="attachFacility" items="${attachFacilityListContract}">
                            <tr class="${attachFacility.id}">
                                <td>${attachFacility.id}</td>
                                <td>${attachFacility.name}</td>
                                <td>${attachFacility.cost}</td>
                                <td>${attachFacility.unit}</td>
                                <td>${attachFacility.status}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Show</button>
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
        $('.tableContract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
