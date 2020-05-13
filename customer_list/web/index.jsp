<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05/13/2020
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>danh sach </h2>
  <table>
    <c:forEach items="${requestScope['customers']}" var="customer">
      <tr>
        <td><c:out value="${customer.getHoTen()}" /></td>
        <td><c:out value="${customer.getNgaySinh()}" /></td>
        <td><c:out value="${customer.getDiaChi()}" /></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
