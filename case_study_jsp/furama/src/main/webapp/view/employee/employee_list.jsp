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
    <title>Employee</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap413/css/style.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<button type="button" class="btn btn-primary"
        data-bs-toggle="modal" data-bs-target="#exampleModal1">
    Thêm mới
</button>
<table id="tableEmployee" class="table table-striped table-bordered col" style="width: 100%">
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
            <td>
                <a href="/employee?action=update&employee_id=${employee.employee_id}"><input type="button"
                                                                                              value="Edit"></a>
            </td>
            <td>
                <button type="button" class="btn btn-primary"
                        onclick="infoDelete('${employee.employee_id}','${employee.employee_name}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="idEmployeeToDelete" id="idDelete">
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
<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">Thêm mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <input type="text" hidden name="action" value="create">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Tên nhân viên</label>
                        <input type="text" name="employee_name" class="form-control" value="${employee.employee_name}"
                               id="exampleFormControlInput1"
                               placeholder="Nguyen Van A" required>
<%--                        <p style="color: red">${error.get("employee_name")}</p>--%>
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
<%--                        <p style="color: red">${error.get("employee_id_card")}</p>--%>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput4">Lương:</label>
                        <input type="text" name="employee_salary" class="form-control" value="${employee.employee_salary}"
                               id="exampleFormControlInput4"
                               placeholder="1000000" required>
<%--                        <p style="color: red">${error.get("employee_salary")}</p>--%>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput5">Số điện thoại</label>
                        <input type="text" name="employee_phone" class="form-control" value="${employee.employee_phone}"
                               id="exampleFormControlInput5"
                               placeholder="(84)90xxxxxxx or (84)91xxxxxxx" required>
<%--                        <p style="color: red">${error.get("employee_phone")}</p>--%>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput6">Email:</label>
                        <input type="text" name="employee_email" class="form-control" value="${employee.employee_email}"
                               id="exampleFormControlInput6"
                               placeholder="abcxyz@gmail.com">
<%--                        <p style="color: #ff0000">${error.get("employee_email")}</p>--%>
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
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous">
</script>
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
