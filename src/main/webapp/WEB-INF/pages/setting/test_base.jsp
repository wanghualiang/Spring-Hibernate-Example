<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!Doctype html>
<html>
<head>
    <title>用户注册页面</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="/assets/css/signup.css"/>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<h1>用户信息编辑页面</h1>
<form:form method="post" commandName="user" action="/setting/base">
    <form:hidden path="id" />
    email:<form:input path="email" /> <form:errors path="email" class="error"/> <br/>
    password:<form:input path="password" /> <form:errors path="password" class="error"/> <br/>
    <%--loginName:<form:input path="loginName" /> <form:errors path="loginName" class="error"/> <br/>--%>
    contactName:<form:input path="contactName" /> <form:errors path="contactName" class="error"/> <br/>
    phone:<form:input path="phone" /> <form:errors path="phone" class="error"/> <br/>
    companyType:<form:input path="companyType" /> <form:errors path="companyType" class="error"/> <br/>
    companyName:<form:input path="companyName" /> <form:errors path="companyName" class="error"/> <br/>
    companySite:<form:input path="companySite" /> <form:errors path="companySite" class="error"/> <br/>
    <input type="submit" />
</form:form>
</body>
</html>
