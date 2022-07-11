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
                    <h2 align="center">Edit Customer</h2>
                    <form method="post">
                        <table class="table" cellpadding="5">
                            <tr>
                                <th>ID:</th>
                                <td>
                                    <input type="text" name="id" value="${customer.id}" id="id" size="45" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th>Customer Type:</th>
                                <td>
                                    <select name="customerTypeID" id="customerTypeID">
                                        <option value="">Chọn loại khách</option>
                                        <c:forEach items="${customerTypeList}" var="customerType">
                                            <c:if test="${customerType.customerTypeId == customer.customerTypeID}">
                                                <option value="${customerType.customerTypeId}" selected>${customerType.customerTypeName}</option>
                                            </c:if>
                                            <c:if test="${customerType.customerTypeId != customer.customerTypeID}">
                                                <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Name:</th>
                                <td>
                                    <input type="text" name="name" id="name" size="45" value="${customer.name}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Birthday:</th>
                                <td>
                                    <input type="date" name="birthDay" id="birthDay" size="45" value="${customer.birthDay}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Gender:</th>
                                <td>
                                    <select name="gender" id="gender">
                                        <option value="">Chọn giới tính</option>
                                        <c:if test="${customer.gender == 0}">
                                            <option value="0" selected>Female</option>
                                            <option value="1">Male</option>
                                        </c:if>
                                        <c:if test="${customer.gender == 1}">
                                            <option value="0">Female</option>
                                            <option value="1" selected>Male</option>
                                        </c:if>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>ID Card:</th>
                                <td>
                                    <input type="text" name="idCard" id="idCard" size="45" value="${customer.idCard}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Phone:</th>
                                <td>
                                    <input type="text" name="phone" id="phone" size="45" value="${customer.phone}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td>
                                    <input type="text" name="email" id="email" size="45" value="${customer.email}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Address:</th>
                                <td>
                                    <input type="text" name="address" id="address" size="45" value="${customer.address}"/>
                                </td>
                            </tr>

                            <tr>
                                <td align="center">
                                    <a href="/facility">
                                        <button type="button" class="btn btn-primary">
                                            Back
                                        </button>
                                    </a>
                                </td>
                                <td align="left">
                                    <button type="submit" class="btn btn-primary">
                                        Save
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </form>
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

<script>
    function displayBonus(facilityTypeId) {
        let soutVilla = "<tr>\n" +
            "                                <th>Standard Room:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"standardRoom\" id=\"standardRoom\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>\n" +
            "                            <tr>\n" +
            "                                <th>Other Description:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"otherDescription\" id=\"otherDescription\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>\n" +
            "                            <tr>\n" +
            "                                <th>Pool Area:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"poolArea\" id=\"poolArea\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>\n" +
            "                            <tr>\n" +
            "                                <th>Number of floors:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"numberFloor\" id=\"numberFloor\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>";

        let soutHouse = "<tr>\n" +
            "                                <th>Standard Room:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"standardRoom\" id=\"standardRoom\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>\n" +
            "                            <tr>\n" +
            "                                <th>Other Description:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"otherDescription\" id=\"otherDescription\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>\n" +
            "                            <tr>\n" +
            "                                <th>Number of floors:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"numberFloor\" id=\"numberFloor\" size=\"45\"/>\n" +
            "                                </td>\n" +
            "                            </tr>";

        let soutRoom = "<tr><th>Facility free:</th>\n" +
            "                                <td>\n" +
            "                                    <input type=\"text\" name=\"facilityFree\" id=\"facilityFree\" size=\"45\"/>\n" +
            "                                </td></tr>";

        if (facilityTypeId.value == 1) {
            document.getElementById("bonusTable").hidden = false;
            document.getElementById("displayVilla").innerHTML = soutVilla;
            document.getElementById("displayVilla").hidden = false;
            document.getElementById("displayHouse").hidden = true;
            document.getElementById("displayRoom").hidden = true;
        } else if (facilityTypeId.value == 2) {
            document.getElementById("bonusTable").hidden = false;
            document.getElementById("displayHouse").innerHTML = soutHouse;
            document.getElementById("displayVilla").hidden = true;
            document.getElementById("displayRoom").hidden = true;
            document.getElementById("displayHouse").hidden = false;
        } else if (facilityTypeId.value == 3) {
            document.getElementById("bonusTable").hidden = false;
            document.getElementById("displayRoom").innerHTML = soutRoom;
            document.getElementById("displayHouse").hidden = true;
            document.getElementById("displayVilla").hidden = true;
            document.getElementById("displayRoom").hidden = false;
        } else {
            document.getElementById("bonusTable").hidden = true;
            document.getElementById("displayHouse").hidden = true;
            document.getElementById("displayVilla").hidden = true;
            document.getElementById("displayRoom").hidden = true;
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
