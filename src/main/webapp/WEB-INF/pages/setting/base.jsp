<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!Doctype html>
<html>
<head>
    <title>用户信息编辑页面</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="/leoss_portal/assets/css/base.css"/>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<%@include file="../include/header.jsp" %>

<div class="leoss-box">
	<form:form method="post" id="baseForm" commandName="user" action="/leoss_portal/setting/base">
	<form:hidden path="id" />
	<form:hidden path="email"/>
    <div class="i-base">
        <div class="p-info">
            ${user.email}
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">登录密码：</span>
            <span class="t-right">
            <form:input path="password" type="password" class="i-unedit" disabled="true"/>
            
            </span>
			
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">联系电话：</span>
            <span class="t-right">
            	<form:input path="phone" class="i-unedit" disabled="true" />
				<form:errors path="phone" class="error"/>
            </span>

        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">联系人：</span>
            <span class="t-right">
            	<form:input path="contactName" class="i-unedit" disabled="true" />
				<form:errors path="contactName" class="error"/>
            </span>
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">企业类型：</span>
            <span class="t-right">
                <span id="companyType-Val" style="padding-left: 5px;">
                	<c:if test="${user.companyType == -1}">未选择</c:if>
                	<c:if test="${user.companyType == 0}">个人用户</c:if>
                	<c:if test="${user.companyType == 1}">IT/互联网</c:if>
                	<c:if test="${user.companyType == 2}">媒体</c:if>
                	<c:if test="${user.companyType == 3}">金融</c:if>
                	<c:if test="${user.companyType == 4}">科研</c:if>
                	<c:if test="${user.companyType == 5}">教育</c:if>
                	<c:if test="${user.companyType == 6}">文化娱乐</c:if>
                	<c:if test="${user.companyType == 7}">商务服务</c:if>
                	<c:if test="${user.companyType == 8}">政民服务</c:if>
                	<c:if test="${user.companyType == 9}">其他</c:if>
				</span>
                <form:select path="companyType" style="display: none;height: 28px;line-height: 28px;">
                	<form:option value="-1">--所属行业--</form:option>
                    <form:option value="0">个人用户</form:option>
                    <form:option value="1">IT/互联网</form:option>
                    <form:option value="2">媒体</form:option>
                    <form:option value="3">金融</form:option>
                    <form:option value="4">科研</form:option>
                    <form:option value="5">教育</form:option>
                    <form:option value="6">文化娱乐</form:option>
                    <form:option value="7">商务服务</form:option>
                    <form:option value="8">政民服务</form:option>
                    <form:option value="9">其他</form:option>
                </form:select>
                <form:errors path="companyType" class="error"/>
            </span>
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">企业名称：</span>
            <span class="t-right">
            	<form:input path="companyName" class="i-unedit" disabled="true"/>
            </span>
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-left">企业网址：</span>
            <span class="t-right">
            	<form:input path="companySite" class="i-unedit" disabled="true"/>
            </span>
        </div>
        <div class="horizontal-line i-top"></div>
        <div class="i-line i-top">
            <span class="t-right">
                <a href="javascript:;" style="display: none;" id="i-cancel">取消</a>
                <a href="javascript:;" style="display: none;" id="i-save">保存</a>
                <a href="javascript:;" id="i-edit">修改</a>
            </span>
        </div>
    </div>
    </form:form>
</div>
<%@include file="../include/footer.jsp" %>
<script type="text/javascript">
    seajs.use(['leoss/base'],function(base){
        new base().init();
    })
</script>
</body>
</html>
