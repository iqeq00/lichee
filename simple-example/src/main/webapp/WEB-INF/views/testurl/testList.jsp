<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>url例子</title>
	<link href="${ctx}/static/script/bootstrap/2.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><th>操作</th></tr></thead>
		<tbody>
			<c:forEach items="${tests.content}" var="test">
				<tr>
					<td>${test.testName}</td>
					<td>
						<a href="${ctx}/testurl/testInfo/${test.testId}">修改</a>&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;
						<a href="${ctx}/testurl/testDelete/${test.testId}">删除</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<span style="float:left;">
			<a class="btn" href="${ctx}/testurl/testAddJsp">添加</a>	
		</span> 
		<span style="float:right;">
			<tags:pagination pager="${tests}" paginationSize="5"/>
		</span> 
	</div>
	
</body>
</html>