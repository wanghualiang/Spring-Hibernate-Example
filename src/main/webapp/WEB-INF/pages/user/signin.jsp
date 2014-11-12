<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!Doctype html>
<html>
<head>
<title>登陆 - 联想云存储</title>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" href="/Spring-Hibernate-Example/assets/css/signin.css"/>
	<link rel="stylesheet" href="/Spring-Hibernate-Example/assets/css/main.css"/>
	
	<style>
      .error {
      	padding: 15px;
      	margin-bottom: 20px;
      	border: 1px solid transparent;
      	border-radius: 4px;
      	color: #a94442;
      	background-color: #f2dede;
      	border-color: #ebccd1;
      }
       
      .msg {
      	padding: 15px;
      	margin-bottom: 20px;
      	border: 1px solid transparent;
      	border-radius: 4px;
      	color: #31708f;
      	background-color: #d9edf7;
      	border-color: #bce8f1;
      }
      </style>

</head>
<body>
	<%@include file="../include/header.jsp"%>
	
	
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	
	<div class="block">
		<form:form id="loginForm" class="login-form" commandName="user" method="POST" action="/Spring-Hibernate-Example/auth/login_check">
			<h3 class="title">登录</h3>
			<div class="i-line">
				<input class="l-input" type="text" placeholder="登录名" id="login_name" name="username"><br/>
				<form:errors path="username"/>
			</div>
			<div class="i-line">
				<input class="l-input" type="password" placeholder="密码" id="password" name="password">
				<form:errors path="password"/>
			</div>
			<!-- <div class="line">
				<input class="s-input" type="text" placeholder="验证码" id="verify"/>
				<img src="/Spring-Hibernate-Example/captcha.jpg" id="validate_img" alt="验证码" title="点击刷新"/>
			</div> -->
			<div class="line">
				<div class="remember-line">
					<div class="ableft">
					<input id="if-remember" type="checkbox" value="true"
						name="remember-me"> <label class="link" for="if-remember">一周内自动登录</label>
					</div>
					<div class="abright">
					<a href="/Spring-Hibernate-Example/user/findpassword">忘记密码</a>
					</div>
				</div>
			</div>
			<div class="line">
				<div class="ableft">
					<button id="loginBtn" class="login" type="submit">确认登录</button>
				</div>
				<div class="abright">
					<a href="/Spring-Hibernate-Example/user/signup">注册账号</a>
				</div>
			</div>
		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
	

	<script>
		seajs.use([ 'leoss/signin' ], function(signin) {
			signin.init();
		})
	</script>
</body>
</html>
