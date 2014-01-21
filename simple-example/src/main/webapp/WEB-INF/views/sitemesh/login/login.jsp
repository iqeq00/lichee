<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>登录</title>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#username").focus();
			$("#inputForm").validation();
		});
	</script>
</head>

<body>

	<form id="inputForm" action="${ctx}/sitemesh/login" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>用户登录</small></legend>
			<div class="control-group">
				<label for="user_name" class="control-label">用户名称:</label>
				<div class="controls">
					<input type="text" id="username" name="username" class="input-large"
						check-type="required" required-message="请填写用户名称"/>
				</div>
			</div>
			<div class="control-group">
				<label for="user_password" class="control-label">用户密码:</label>
				<div class="controls">
					<input type="password" id="password" name="password" class="input-large"
						check-type="required" required-message="请填写用户密码"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>

</body>
</html>