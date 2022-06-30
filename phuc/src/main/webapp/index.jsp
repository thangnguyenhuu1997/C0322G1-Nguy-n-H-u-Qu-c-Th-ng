<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/8/2022
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<title>$Title$</title>
<link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap413/css/style.css">
</head>
<body>
<header>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse row w-100">
      <div class="col-md-1">
        <img src="image/logo_furama_2.png" alt="" height="100px">
      </div>
      <div class="col-md-8">
        <ul class="navbar-nav mr-auto w-100" id="navbarSupportedContent">
          <li class="nav-item active">
            <a class="nav-link" href="/index.jsp">Home<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button"
               data-toggle="dropdown" aria-expanded="false">
              Employee
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/employees">List Employee</a>
              <a class="dropdown-item" href="/employees?action=create">Create New Employee</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
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
            <a class="nav-link" href="/facility">Service<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">Contract<span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>
      <div class="col-md-3">
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>
</header>
<div class="container-fluid main-content">
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="d-block w-100" src="image/carousel_image_1.png" alt="First slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="image/carousel_image_2.png" alt="Second slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="image/carousel_image_3.png" alt="Third slide">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <%--    <div class="left-content col-md-2">--%>

  <%--    </div>--%>
  <%--    <div class="right-content col-md-10">--%>
  <%--      <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">--%>
  <%--        <div class="carousel-inner">--%>
  <%--          <div class="carousel-item active">--%>
  <%--            <img src="image/carousel_image_1.png" class="d-block w-100" height="500px" alt="...">--%>
  <%--          </div>--%>
  <%--          <div class="carousel-item">--%>
  <%--            <img src="image/carousel_image_2.png" class="d-block w-100" height="500px" alt="...">--%>
  <%--          </div>--%>
  <%--          <div class="carousel-item">--%>
  <%--            <img src="image/carousel_image_3.png" class="d-block w-100" height="500px" alt="...">--%>
  <%--          </div>--%>
  <%--        </div>--%>
  <%--        <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">--%>
  <%--          <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
  <%--          <span class="sr-only">Previous</span>--%>
  <%--        </button>--%>
  <%--        <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">--%>
  <%--          <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
  <%--          <span class="sr-only">Next</span>--%>
  <%--        </button>--%>
  <%--      </div>--%>
  <%--    </div>--%>
</div>
<footer>
  <div class="col-lg-12">
    <span>"103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam"</span>
    <br style="margin: 0px ; padding: 0px">
    <span>Tel: 84-236-3874 333/888</span>
    <br style="margin: 0px ; padding: 0px">
    <span>Email:&nbsp;</span>
    <a href="">reservation@furamavietnam.com</a>
  </div>
</footer>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap413/js/bootstrap.min.js"></script>
</body>
</html>