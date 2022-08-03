<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="header">
	<div id="title">
		<h1>
			<a href="${ctx}">Simple Example示例</a><small>--TodoList应用演示</small>
			<div class="btn-group pull-right">
			
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i><shiro:principal/><span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<!-- 
					<li><a href="${ctx}/admin/user">Admin Users</a></li>
					<li class="divider"></li>
					<li><a href="${ctx}/profile">Edit Profile</a></li>
					 -->
					<li><a href="${ctx}/logout">退出</a></li>
				</ul>
				
			</div>
		</h1>
	</div>
</div>