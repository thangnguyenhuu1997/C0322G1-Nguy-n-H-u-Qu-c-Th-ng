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
                                                                    alt="Logo Header Menu"></a>
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
              <a class="nav-link" href="/employee">Employee</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/customer">Customer</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/facility">Facility</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/contract">Contract</a>
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
          <iframe width="100%" height="400px" src="https://www.youtube.com/embed/IjlT_4mvd-c"
                  title="The Furama Resort DaNang - Couples Corporate" frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                  allowfullscreen></iframe>
        </div>
      </div>

      <div class="container-fluid">
        <div class="row mt-3">
          <h2 style="font-size: 24px;color: #cbbe73;line-height: 36px;text-align: left;font-family:Playfair Display;font-weight:700;font-style:normal"
              class="vc_custom_heading">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI FURAMA ĐÀ NẴNG, TỰ HÀO LÀ KHU NGHỈ
            DƯỠNG ẨM THỰC TẠI VIỆT NAM</h2>
        </div>
      </div>

      <div class="container-fluid">
        <div class="row">
          <p style="font-family: Playfair Display">Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản
            văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng
            với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo
            phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành
            khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới
            hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
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
          <p style="font-family: Playfair Display">Email: reservation@furamavietnam.com * www.furamavietnam.com</p>
          <p style="font-family: Playfair Display">GDS Codes: Amadeus-GD DADFUR,
            Galileo/Apollo-GD 16236, Sabre-GD 032771, Worldspan- GD DADFU</p>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
