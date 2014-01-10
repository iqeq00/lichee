<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>测试表单</title>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#taskName").focus();
			$("#inputForm").validation();
		});
	</script>
</head>
<body>
	
	<form id="inputForm" action="${ctx}/sitemesh/task/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="taskId" value="${task.taskId}"/>
		<fieldset>
			<legend><small>测试修改</small></legend>
			<div class="control-group">
				<label for="task_name" class="control-label">测试名称:</label>
				<div class="controls">
					<input type="text" id="taskName" name="taskName" value="${task.taskName}" class="input-large"
						check-type="required" required-message="请填写测试名称信息"/>
				</div>
			</div>
			<div class="control-group">
				<label for="task_desc" class="control-label">测试描述:</label>
				<div class="controls">
					<div class="textarea">
						<textarea name="taskDesc" class="input-large" style="width:210px;height:150px;" 
							check-type="required" required-message="请填写模版描述信息" />${task.taskDesc}</textarea>
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