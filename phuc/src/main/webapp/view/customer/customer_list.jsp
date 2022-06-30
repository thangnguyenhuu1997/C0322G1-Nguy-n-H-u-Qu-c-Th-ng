<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap413/css/style.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse row w-100">
            <div class="col-md-1">
                <img src="image/logo_furama_2.png" alt="" height="100px">
            </div>
            <div class="col-md-7">
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
            <div class="col-md-4">
                <form class="form-inline my-2 my-lg-0" action="/customers?action=search" method="post">
                    <div class="d-flex">
                        <input class="form-control mr-sm-2 col-md-3" type="number" name="idSearch" value=""
                               placeholder="Customer ID" aria-label="Search">
                        <input class="form-control mr-sm-2 col-md-3" type="text" name="nameSearch" value=""
                               placeholder="Customer Name" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0 w-25" type="submit">Search</button>
                    </div>

                </form>
            </div>
        </div>
    </nav>
</header>
<c:if test="${mess!=null}">
    <p style="color: #0c5460">${mess}</p>
</c:if>
<table id="tableCustomer" class="table table-striped table-bordered col" style="width: 100%">
    <thead>
    <tr>
        <th scope="col">ID khách hàng</th>
        <th scope="col">Mã khách hàng</th>
        <th scope="col">Loại khách hàng</th>
        <th scope="col">Tên khách hàng</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Số CMND</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Email</th>
        <th scope="col">Địa chỉ</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td scope="row">${customer.customerId}</td>
            <td>${customer.customerCode}</td>
            <td>${customer.customerTypeId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirth}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
            <td><input type="button" class="btn btn-primary" value="Edit"><a
                    href="/customers?action=update&customerId=${customer.customerId}">Update</a></td>
            <td><input id="del" onclick="showInfo('${customer.customerId}','${customer.customerName}')"
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
        <form action="/customers?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Xác nhận xóa</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="nameCustomer">
                    <input type="hidden" id="idCustomer" name="idCustomerToDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<script>
    function showInfo(id, name) {
        document.getElementById("nameCustomer").innerHTML = "Chắc chắn xóa <b style='color: blue'>" + name + "</b> ?";
        document.getElementById("idCustomer").value = id;
    }
</script>
</body>
</html>
