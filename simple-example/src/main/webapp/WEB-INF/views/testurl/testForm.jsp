<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>测试表单</title>
	<link href="${ctx}/common/script/bootstrap/2.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link type="text/css" rel="stylesheet" href="${ctx}/common/script/bootstrap/2.3.0/css/bootstrap.min.css"/>
	<script type="text/javascript" src="${ctx}/common/script/jquery/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/common/script/bootstrap/2.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/common/script/jquery/bootstrap-validation.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#testName").focus();
			$("#inputForm").validation();
		});
	</script>
</head>
<body>
	
	<form id="inputForm" action="${ctx}/testurl/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="testId" value="${test.testId}"/>
		<fieldset>
			<legend><small>测试修改</small></legend>
			<div class="control-group">
				<label for="test_name" class="control-label">测试名称:</label>
				<div class="controls">
					<input type="text" id="testName" name="testName" value="${test.testName}" class="input-large"
						check-type="required" required-message="请填写测试名称信息"/>
				</div>
			</div>
			<div class="control-group">
				<label for="test_desc" class="control-label">测试描述:</label>
				<div class="controls">
					<div class="textarea">
						<textarea name="testDesc" class="input-large" style="width:210px;height:150px;" 
							check-type="required" required-message="请填写模版描述信息" />${test.testDesc}</textarea>
					</div>
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