<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05/08/2020
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="/calculateDiscount" method="post">
  <label>Product Description: </label><br/>
  <input type="text" name="ProductDescription" /><br/>
  <label>List Price: </label><br/>
  <input type="text" name="ListPrice" /><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="DiscountPercent" />
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>