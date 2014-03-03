<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>任务列表</title>
</head>
<body>

	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>

<!-- 
	<div class="clearfix">
		<div class="input-append input-prepend">
			<input type="text" placeholder="Search" class="placeholder"/>
			<span class="add-on">
				<i class="icon-search"></i>
			</span> 
		</div>
	</div>
-->	

	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>名称：</label> 
				<input type="text" name="search_LIKE_taskName" class="input-medium" value="${param.search_LIKE_taskName}"/> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><th>操作</th></tr></thead>
		<tbody>
			<c:forEach items="${tasks.content}" var="task">
				<tr>
					<td>${task.taskName}</td>
					<td>${task.taskDesc}</td>
					<td>
						<a href="${ctx}/bootstrap/task/update/${task.taskId}">修改</a>&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;
						<a href="${ctx}/bootstrap/task/delete/${task.taskId}">删除</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<span style="float:left;">
			<a class="btn" href="${ctx}/bootstrap/task/create">添加</a>
		</span> 
		<span style="float:right;">
			<tags:pagination page="${tasks}" paginationSize="5"/>
		</span> 
	</div>
	
	
</body>
</html>