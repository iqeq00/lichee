<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="inputForm" method="post">
		<input type="hidden" name="taskId" value="${task.taskId}"/>
		测试名称：<input name="taskName" style="width:100px;" value="${task.taskName}"/><br/>
		测试描述：<textarea name="taskDesc" style="width:100px;height:60px;">${task.taskDesc}</textarea>
	</form>
</div>

