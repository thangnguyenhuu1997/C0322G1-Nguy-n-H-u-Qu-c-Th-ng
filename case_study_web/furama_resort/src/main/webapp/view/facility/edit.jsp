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
                    <h2 align="center">Edit Facility</h2>
                    <form method="post">
                        <c:if test="${message != null}">
                            <span>${message}</span>
                        </c:if>
                        <table class="table" cellpadding="5">
                            <c:if test="${villa.facilityTypeId == 1}">
                                <tr>
                                    <th>ID:</th>
                                    <td>
                                        <input type="text" readonly name="id" value="${villa.id}" size="45"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Name:</th>
                                    <td>
                                        <input type="text" name="name" value="${villa.name}" size="45"/>
                                        <p class="text-danger">${error.get("name")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area:</th>
                                    <td>
                                        <input type="text" name="area" value="${villa.area}" size="45"/>
                                        <p class="text-danger">${error.get("area")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost:</th>
                                    <td>
                                        <input type="text" name="cost" value="${villa.cost}" size="45"/>
                                        <p class="text-danger">${error.get("cost")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max people:</th>
                                    <td>
                                        <input type="text" name="maxPeople" value="${villa.maxPeople}" size="45"/>
                                        <p class="text-danger">${error.get("people")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent type:</th>
                                    <td>
                                        <select name="rentTypeId">
                                            <option value="">Chọn kiểu thuê</option>
                                            <c:forEach items="${rentTypeList}" var="rentType">
                                                <c:if test="${rentType.rentTypeId == villa.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}" selected>${rentType.rentTypeName}</option>
                                                </c:if>
                                                <c:if test="${rentType.rentTypeId != villa.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Facility type:</th>
                                    <td>
                                        <select name="facilityTypeId" onchange="displayBonus(this)">
                                            <option value="">Chọn kiểu dịch vụ</option>
                                            <c:forEach items="${facilityTypeList}" var="facilityType">
                                                <c:if test="${facilityType.facilityTypeId == villa.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}" selected>${facilityType.facilityTypeName}</option>
                                                </c:if>
                                                <c:if test="${facilityType.facilityTypeId != villa.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}">${facilityType.facilityTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr id="standardRoom">
                                    <th>Standard room:</th>
                                    <td>
                                        <input type="text" name="standardRoom" value="${villa.standardRoom}" size="45"/>
                                        <p class="text-danger">${error.get("standard")}</p>
                                    </td>
                                </tr>
                                <tr id="otherDescription">
                                    <th>Other Description:</th>
                                    <td>
                                        <input type="text" name="otherDescription" value="${villa.otherDescription}" size="45"/>
                                        <p class="text-danger">${error.get("other")}</p>
                                    </td>
                                </tr>
                                <tr id="poolArea">
                                    <th>Pool area:</th>
                                    <td>
                                        <input type="text" name="poolArea" value="${villa.poolArea}" size="45"/>
                                        <p class="text-danger">${error.get("pool")}</p>
                                    </td>
                                </tr>
                                <tr id="numberFloor">
                                    <th>Number of floors:</th>
                                    <td>
                                        <input type="text" name="numberFloor" value="${villa.numberFloor}" size="45"/>
                                        <p class="text-danger">${error.get("floor")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="facilityFree">
                                    <th>Facility Free:</th>
                                    <td>
                                        <input type="text" name="facilityFree" size="45"/>
                                        <p class="text-danger">${error.get("free")}</p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${house.facilityTypeId == 2}">
                                <tr>
                                    <th>ID:</th>
                                    <td>
                                        <input type="text"  readonly name="id" value="${house.id}" size="45"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Name:</th>
                                    <td>
                                        <input type="text" name="name" value="${house.name}" size="45"/>
                                        <p class="text-danger">${error.get("name")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area:</th>
                                    <td>
                                        <input type="text" name="area" value="${house.area}" size="45"/>
                                        <p class="text-danger">${error.get("area")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost:</th>
                                    <td>
                                        <input type="text" name="cost" value="${house.cost}" size="45"/>
                                        <p class="text-danger">${error.get("cost")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max people:</th>
                                    <td>
                                        <input type="text" name="maxPeople" value="${house.maxPeople}" size="45"/>
                                        <p class="text-danger">${error.get("people")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent type:</th>
                                    <td>
                                        <select name="rentTypeId">
                                            <option value="">Chọn kiểu thuê</option>
                                            <c:forEach items="${rentTypeList}" var="rentType">
                                                <c:if test="${rentType.rentTypeId == house.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}" selected>${rentType.rentTypeName}</option>
                                                </c:if>
                                                <c:if test="${rentType.rentTypeId != house.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Facility type:</th>
                                    <td>
                                        <select name="facilityTypeId" onchange="displayBonus(this)">
                                            <option value="">Chọn kiểu dịch vụ</option>
                                            <c:forEach items="${facilityTypeList}" var="facilityType">
                                                <c:if test="${facilityType.facilityTypeId == house.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}" selected>${facilityType.facilityTypeName}</option>
                                                </c:if>
                                                <c:if test="${rentType.facilityTypeId != house.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}">${facilityType.facilityTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr id="standardRoom">
                                    <th>Standard room:</th>
                                    <td>
                                        <input type="text" name="standardRoom" value="${house.standardRoom}" size="45"/>
                                        <p class="text-danger">${error.get("standard")}</p>
                                    </td>
                                </tr>
                                <tr id="otherDescription">
                                    <th>Other Description:</th>
                                    <td>
                                        <input type="text" name="otherDescription" value="${house.otherDescription}" size="45"/>
                                        <p class="text-danger">${error.get("other")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="poolArea">
                                    <th>Pool Area:</th>
                                    <td>
                                        <input type="text" name="poolArea" size="45"/>
                                        <p class="text-danger">${error.get("pool")}</p>
                                    </td>
                                </tr>
                                <tr id="numberFloor">
                                    <th>Number of floors:</th>
                                    <td>
                                        <input type="text" name="numberFloor" value="${house.numberFloor}" size="45"/>
                                        <p class="text-danger">${error.get("floor")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="facilityFree">
                                    <th>Facility Free:</th>
                                    <td>
                                        <input type="text" name="facilityFree" size="45"/>
                                        <p class="text-danger">${error.get("free")}</p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${room.facilityTypeId == 3}">
                                <tr>
                                    <th>ID:</th>
                                    <td>
                                        <input type="text"  readonly name="id" value="${room.id}" size="45"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Name:</th>
                                    <td>
                                        <input type="text" name="name" value="${room.name}" size="45"/>
                                        <p class="text-danger">${error.get("name")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area:</th>
                                    <td>
                                        <input type="text" name="area" value="${room.area}" size="45"/>
                                        <p class="text-danger">${error.get("area")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost:</th>
                                    <td>
                                        <input type="text" name="cost" value="${room.cost}" size="45"/>
                                        <p class="text-danger">${error.get("cost")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max people:</th>
                                    <td>
                                        <input type="text" name="maxPeople" value="${room.maxPeople}" size="45"/>
                                        <p class="text-danger">${error.get("people")}</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent type:</th>
                                    <td>
                                        <select name="rentTypeId">
                                            <option value="">Chọn kiểu thuê</option>
                                            <c:forEach items="${rentTypeList}" var="rentType">
                                                <c:if test="${rentType.rentTypeId == room.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}" selected>${rentType.rentTypeName}</option>
                                                </c:if>
                                                <c:if test="${rentType.rentTypeId != room.rentTypeId}">
                                                    <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Facility type:</th>
                                    <td>
                                        <select name="facilityTypeId" onchange="displayBonus(this)">
                                            <option value="">Chọn kiểu dịch vụ</option>
                                            <c:forEach items="${facilityTypeList}" var="facilityType">
                                                <c:if test="${facilityType.facilityTypeId == room.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}" selected>${facilityType.facilityTypeName}</option>
                                                </c:if>
                                                <c:if test="${facilityType.facilityTypeId != room.facilityTypeId}">
                                                    <option value="${facilityType.facilityTypeId}">${facilityType.facilityTypeName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr hidden id="standardRoom">
                                    <th>Standard Room:</th>
                                    <td>
                                        <input type="text" name="standardRoom" size="45"/>
                                        <p class="text-danger">${error.get("standard")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="otherDescription">
                                    <th>Other Description:</th>
                                    <td>
                                        <input type="text" name="otherDescription" size="45"/>
                                        <p class="text-danger">${error.get("other")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="poolArea">
                                    <th>Pool Area:</th>
                                    <td>
                                        <input type="text" name="poolArea" size="45"/>
                                        <p class="text-danger">${error.get("pool")}</p>
                                    </td>
                                </tr>
                                <tr hidden id="numberFloor">
                                    <th>Number of Floors:</th>
                                    <td>
                                        <input type="text" name="numberFloor" size="45"/>
                                        <p class="text-danger">${error.get("floor")}</p>
                                    </td>
                                </tr>
                                <tr id="facilityFree">
                                    <th>Facility free:</th>
                                    <td>
                                        <input type="text" name="facilityFree" value="${room.facilityFree}" size="45"/>
                                        <p class="text-danger">${error.get("free")}</p>
                                    </td>
                                </tr>
                            </c:if>

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
        if (facilityTypeId.value == 1) {
            document.getElementById("standardRoom").hidden = false;
            document.getElementById("otherDescription").hidden = false;
            document.getElementById("poolArea").hidden = false;
            document.getElementById("numberFloor").hidden = false;
            document.getElementById("facilityFree").hidden = true;
        } else if (facilityTypeId.value == 2) {
            document.getElementById("standardRoom").hidden = false;
            document.getElementById("otherDescription").hidden = false;
            document.getElementById("poolArea").hidden = true;
            document.getElementById("numberFloor").hidden = false;
            document.getElementById("facilityFree").hidden = true;
        } else if (facilityTypeId.value == 3) {
            document.getElementById("standardRoom").hidden = true;
            document.getElementById("otherDescription").hidden = true;
            document.getElementById("poolArea").hidden = true;
            document.getElementById("numberFloor").hidden = true;
            document.getElementById("facilityFree").hidden = false;
        } else {
            document.getElementById("standardRoom").hidden = true;
            document.getElementById("otherDescription").hidden = true;
            document.getElementById("poolArea").hidden = true;
            document.getElementById("numberFloor").hidden = true;
            document.getElementById("facilityFree").hidden = true;
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
