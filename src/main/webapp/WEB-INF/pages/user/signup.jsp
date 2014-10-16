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
	<%@include file="../include/header.jsp" %>
	
    <div class="leoss-box">
    	<h1>用户注册页面</h1>
    	<form:form method="post" id="leoss_regist" commandName="user" action="/user/signup">
		    <div class="i-line">
		        <p class="extra-name">
		        	请输入邮箱（将作为您的登录账号）:<i class="need">*</i>
		        </p>
		        <input type="text" id="email" name="email" class="long-input" placeholder="邮箱" />
		        <form:errors path="email" class="error"/>
		    </div>
		    <div class="i-line">
		    	<p class="extra-name">
		    		设定密码:<i class="need">*</i>
		    	</p>
		    	<input type="password" name="password" id="pwd" class="long-input" placeholder="登录密码" />
		        <form:errors path="password" class="error"/>
		    </div>
		    <div class="i-line">
		    	<p class="extra-name">
		    		确认密码:<i class="need">*</i>
		    	</p>
		    	<input type="password" name="cpassword" id="cpwd" class="long-input" placeholder="确认密码" />
		    </div>
		    <div class="i-line">
		    	<span class="p-line">联系人:</span>
	    		<i class="need">*&nbsp;</i><input type="text" name="contactName" id="contactName" class="short-input" placeholder="联系人" />
		        <form:errors path="contactName" class="error"/>
		    </div>
		    <div class="i-line">
		    	<span class="p-line">联系电话:</span>
	    		<i class="need">*&nbsp;</i><input type="text" name="phone" id="phone" class="short-input" placeholder="联系手机" />
		        <form:errors path="phone" class="error"/>
		    </div>
		    <div class="i-line">
		    	<span class="p-line">企业类型:</span>
		    	<i class="need">*&nbsp;</i>
		    	<select name="companyType" id="companyType" class="i-select">
					<option value="-1">--所属行业--</option>
					<option value="0">个人用户</option>
					<option value="1">IT/互联网</option>
					<option value="2">媒体</option>
					<option value="3">金融</option>
					<option value="4">科研</option>
					<option value="5">教育</option>
					<option value="6">文化娱乐</option>
					<option value="7">商务服务</option>
					<option value="8">政民服务</option>
					<option value="9">其他</option>
		    	</select>
		        <form:errors path="companyType" class="error"/>
		    </div>
		    <div class="i-line">
		    	<span class="p-line">企业名称:</span>
	    		<i class="need">*&nbsp;</i><input type="text" name="companyName" id="companyName" class="short-input" placeholder="企业名称" />
		        <form:errors path="companyName" class="error"/>
		    </div>
		    <div class="i-line">
		    	<span class="p-line">企业网址:</span>
	    		<i class="need">*&nbsp;</i><input type="text" name="companySite" id="companySite" class="short-input" placeholder="企业网址" />
		        <form:errors path="companySite" class="error"/>
		    </div>
		    <div class="i-line">
		    	<span class="p-line">验证码:</span>
		    	<i class="need">*&nbsp;</i><input type="text" name="captchaText" id="validate" class="short-input" style="width:42px" />
		    	<img src="/captcha.jpg" alt="验证码" title="点击刷新" id="validate_img" class="validate" />
		    	<!-- <a href="javascript:;" id="validate_btn">点击刷新</a> -->
                <p class="error">
		    	<c:if test="${captchaInvalid}" >
		    	<fmt:message key="captcha.invalid"/>
		    	</c:if>
                </p>
		    </div>
		    <div class="i-line" style="margin-bottom:10px;">
		    	<input type="submit" value="注册" class="reg_btn" />
		    	&nbsp;&nbsp;&nbsp;&nbsp;<a href="/user/signin">已有账号?去登录</a>
		    </div>
	    </form:form>
	</div>
   	<%@include file="../include/footer.jsp" %>
   	<script>
    seajs.use(['leoss/signup'],function(SP){
        SP.init();
    })
</script>
</body>
</html>
