<%--
  Created by IntelliJ IDEA.
  User: zhangyl27
  Date: 2014/10/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表页</title>
</head>
<body>
    <h1>展示所有用户的列表页面</h1>
    <table cellpadding="5" cellspacing="1" border="1">
        <tr>
            <td>email</td><td>contactName</td><td>phone</td><td>注册时期</td>
        </tr>
        <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.email}</td><td>${u.contactName}</td><td>${u.phone}</td><td>${u.ctime}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
