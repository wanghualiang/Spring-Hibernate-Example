<%@ page import="com.lenovo.leoss.utils.ErrorCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息反馈页面</title>
</head>
<body>
<h1>操作信息展示</h1>
<c:set var="code" value='<%=request.getParameter("code")%>' />
<c:set var="actLinkExpired" value='<%=ErrorCode.ACTIVATION_LINK_EXPIRED%>' />
<c:set var="actLinkInvalid" value='<%=ErrorCode.ACTIVATION_LINK_INVALID%>' />
<table cellpadding="5" cellspacing="1" border="1">
    <tr>
        <td>message</td>
    </tr>
    <tr>
        <td>
            <c:choose>
            <c:when test="${code==actLinkExpired}">
                激活链接过期
            </c:when>
            <c:when test="${code==actLinkInvalid}">
                激活链接无效
            </c:when>
            <c:otherwise>
                服务器意外出错，请稍后重试
            </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
</body>
</html>
