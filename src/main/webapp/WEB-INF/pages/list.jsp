<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/6
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3 align="center">显示帐户列表</h3>

<table align="center" border="1" cellpadding="0" cellspacing="0" width="300px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>余额</th>
    </tr>

    <c:forEach items="${list}" var="account" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>