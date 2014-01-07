<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>url例子</title>
	<link type="text/css" rel="stylesheet" href="${ctx}/common/script/bootstrap/2.3.0/css/bootstrap.min.css"/>
	<script type="text/javascript" src="${ctx}/common/script/jquery/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/common/script/bootstrap/2.3.0/js/bootstrap.min.js"></script>
</head>
<body>

	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><th>操作</th></tr></thead>
		<tbody>
			<c:forEach items="${tests.content}" var="test">
				<tr>
					<td>${test.testName}</td>
					<td>${test.testDesc}</td>
					<td>
						<a href="${ctx}/testurl/update/${test.testId}">修改</a>&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;
						<a href="${ctx}/testurl/delete/${test.testId}">删除</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<span style="float:left;">
			<a class="btn" href="${ctx}/testurl/create">添加</a>	
		</span> 
		<span style="float:right;">
			<tags:pagination pager="${tests}" paginationSize="5"/>
		</span> 
	</div>
	
</body>
</html>