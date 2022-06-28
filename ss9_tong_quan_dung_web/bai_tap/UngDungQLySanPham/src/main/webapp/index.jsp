<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
  <title>$Title$</title>
  <style>
    #content {
      width: 450px;
      margin: 0 auto;
      padding: 0px 20px 20px;
      background: white;
      border: solid navy 2px;
    }
    label {
      width: 10em;
      padding-right: 1em;
      float: left;
    }
    #data input {
      float: left;
      width: 15em;
      margin-bottom: .5em;
    }
    #submit {
      margin: 10px 175px;
    }
  </style>
</head>
<body>
<div id="content">
  <h1>Product Discount Calculator</h1>
  <form action="calculator" method="post">
    <div id="data">
      <label>Product Description</label>
      <input type="text" name="description">
      <br>
      <label>Price</label>
      <input type="text" name="price">
      <br>
      <label>Discount Percent</label>
      <input type="text" name="discount">
    </div>
    <div>
      <br>
      <input id="submit" type="submit" value="Discount Product">
    </div>
  </form>
</div>
<h1>${description}</h1>
<h1>Giá gốc: ${price}</h1>
<h1>Tỷ lệ chiết khấu: ${discount_percent}</h1>
<h1>Lượng chiết khấu: ${discount_amonunt}</h1>
<h1>Giá sau chiết khấu: ${total}</h1>
</body>
</html>
