<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<title>用户注册</title>
	<script type="text/javascript">
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#userName").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					userName: {
						remote: "${ctx}/bootstrap/register/checkUserName"
					}
				},
				messages: {
					userName: {
						remote: "用户登录名已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/bootstrap/register" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>用户注册</small></legend>
			<div class="control-group">
				<label for="userName" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="userName" name="userName" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="userAccount" class="control-label">昵称:</label>
				<div class="controls">
					<input type="text" id="userAccount" name="userAccount" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="userPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="userPassword" name="userPassword" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large required" equalTo="#userPassword"/>
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
