<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/11/2022
  Time: 7:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap413/css/style.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<h2>Danh Sách Hộ Khẩu</h2>
<a href="/hokhau?action=create"><input type="button" value="Thêm mới"></a>
<table id="tableHoKhau" class="table table-striped table-bordered col" style="width: 100%">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã Hộ Khẩu</th>
        <th scope="col">Tên chủ hộ</th>
        <th scope="col">Số Lượng thành viên</th>
        <th scope="col">Ngày lập hộ khẩu</th>
        <th scope="col">Địa chỉ nhà</th>
        <th scope="col">Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hoKhauList}" var="hoKhau">
        <tr>
            <td scope="row">${hoKhau.stt}</td>
            <td>${hoKhau.ma_ho_khau}</td>
            <td>${hoKhau.ten_chu_ho}</td>
            <td>${hoKhau.so_luong_thanh_vien}</td>
            <td>${hoKhau.ngay_lap_ho_khau}</td>
            <td>${hoKhau.dia_chi}</td>
            <td>
                <a href="/hokhau?action=update&stt=${hoKhau.stt}"><input type="button"
                                                                                         value="Sửa"></a>
            </td>
            <td>
                <a href="/hokhau?action=update&stt=${hoKhau.stt}"><input type="button"
                                                                         value="Xem thành viên"></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous">
</script>
<script>
    $(document).ready(function () {
        $('#tableHoKhau').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
