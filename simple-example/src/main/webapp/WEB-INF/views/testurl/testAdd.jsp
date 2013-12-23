<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>测试添加</title>
	<link href="${ctx}/static/script/bootstrap/2.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
</head>
<body>
	
	<form id="inputForm" action="${ctx}/testurl/testAdd" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>测试添加</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">测试名称:</label>
				<div class="controls">
					<input type="text" name="testName" class="input-large required"/>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="添加"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	
</body>
</html>