<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
    <title>密钥</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="/Spring-Hibernate-Example/assets/css/key.css"/>
    
</head>
<body>
<div class="leoss-header">
	<%@include file="../include/header.jsp"%>
</div>

<div class="leoss-box">
<div class="leoss-keys">

	<table class="table-keys">
		<thead>
			<tr class="title-keys">
				<th>创建时间</th>
				<th>AccessKey/SecretKey</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="key-tbody">
			<input type="hidden" id="_csrf" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<tr id="key-list-tr" style="display:none;">
				<td class="key-ctime">
                    <input type="hidden" id="id" name="id" value="${key.id}"/>
                    <input type="hidden" id="status" name="status" value="${key.status}"/>
					<span id="ctime">${key.ctime}</span>
				</td>
				<td class="key-input">
					<div class="access-key">
					<span>AK:</span><input type="text" id="access_key" name="access_key" readonly="ture" value="" onclick="this.select();"/>
					</div>
					<div class="secret-key">
					<span>SK:</span><input type="text" id="secret_key" name="secret_key" readonly="ture" value="" onclick="this.select();"/><span class="key-cover"></span>
					</div>
				</td>
				<td class="key-status">
                    <div id="statususe">
						<span class="status-using">使用中</span>

                    </div>
                    <div id="statusstop">
						<span>已停用</span>
					</div>
				</td>
				<td>
                    <div id="btnuse">
                        <a class="disableBtn" href="javascript:;" id="disableBtn">禁用</a>
                    </div>
                    <div id="btnstop">
                        <a class="enableBtn"  href="javascript:;" id="enableBtn">启用</a>
                        <a class="deletebtn"  href="javascript:;" id="deleteBtn">删除</a>
                    </div>
                    
             </td>
			</tr>
		</tbody>
	</table>
	<div class="newkeys">
		<a class="createbtn" href="javascript:;" id="createBtn">+ 创建新密钥</a>
	</div>
	<div class="tips">
		<p>友情提示：</p>
		<ol>
			<li>一个账号最多拥有两对密钥(Access/Secret Key)。</li>
			<li>更换密钥时，请创建第二个密钥。</li>
			<li>删除密钥前须停用。</li>
			<li>出于安全考虑，建议您周期性地更换密钥。</li>
			<li>查看更多
				<a href="" target="_blank" title="安全使用密钥建议">安全使用密钥建议</a>
			</li>
		</ol>
	</div>
</div>
</div>
<div class="leoss-footer">
	<%@include file="../include/footer.jsp"%>
</div>
<script>
    seajs.use(['leoss/key'],function(keys){
        keys.init();
    })
</script>
</body>
</html>

