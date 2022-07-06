<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/5/2022
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap413/css/style.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>

<table id="tableCustomer" class="table table-striped table-bordered col" style="width: 100%">
    <thead>
    <tr>
        <th scope="col">ID Nhân Viên</th>
        <th scope="col">Tên Nhân Viên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Số CMND</th>
        <th scope="col">Lương</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Email</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Vị trí</th>
        <th scope="col">Trình độ học vấn</th>
        <th scope="col">Bộ phận làm việc</th>
        <th scope="col">User</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td scope="row">${employee.employee_id}</td>
            <td>${employee.employee_name}</td>
            <td>${employee.employee_birthday}</td>
            <td>${employee.employee_id_card}</td>
            <td>${employee.employee_salary}</td>
            <td>${employee.employee_phone}</td>
            <td>${employee.employee_email}</td>
            <td>${employee.employee_address}</td>
            <c:forEach items="${positionList}" var="positionList">
                <c:if test="${positionList.position_id==employee.position_id}">
                    <td>${positionList.position_name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${educationDegreeList}" var="educationDegreeList">
                <c:if test="${educationDegreeList.education_degree_id==employee.education_degree_id}">
                    <td>${educationDegreeList.education_degree_name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${divisionList}" var="divisionList">
                <c:if test="${divisionList.division_id==employee.division_id}">
                    <td>${divisionList.division_name}</td>
                </c:if>
            </c:forEach>
            <td>${employee.username}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>


<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous">
</script>

</body>
</html>
