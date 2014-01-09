<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${ctx}/static/styles/page/page.css"/>

	<div class="fenye">
		<div class="fenye_kuang2">
			总共<span class="spanred"><s:property value="%{pageBean.allRow}" /></span>条记录
		</div>
		<div class="fenye_kuang">
			<a href="<s:property value='%{pageBean.url}'/>?page=1" <s:if test='pageBean.currentPage=="1"'>disabled</s:if>>首页</a>
		</div>
		<div class="fenye_kuang">
			<a href="<s:property value='%{pageBean.url}'/>?page=<s:property value="%{pageBean.currentPage-1}"/>" <s:if test='pageBean.currentPage=="1"'>disabled</s:if>>上一页</a>
		</div>
		<s:bean name="org.apache.struts2.util.Counter" id="counter">
			<s:param name="first" value="pageBean.startPage" />
			<s:param name="last" value="pageBean.endPage" />
			<s:iterator>
				<div class="fenye_kuang1">
					<a href="<s:property value='%{pageBean.url}'/>?page=<s:property/>">
						<s:if test="current-1==pageBean.currentPage">
							<span class="spanred"><s:property/></span>
						</s:if>
						<s:else>
							<span><s:property/></span>
						</s:else>
					</a>
				</div>
			</s:iterator>
		</s:bean>
		<div class="fenye_kuang">
			<a href="<s:property value='%{pageBean.url}'/>?page=<s:property value="%{pageBean.currentPage+1}"/>" <s:if test='pageBean.currentPage==pageBean.totalPage'>disabled</s:if>>下一页</a>
		</div>
		<div class="fenye_kuang">
			<a href="<s:property value='%{pageBean.url}'/>?page=<s:property value="%{pageBean.totalPage}"/>" <s:if test='pageBean.currentPage==pageBean.totalPage'>disabled</s:if>>尾页</a>
		</div>
		<div class="fenye_kuang2">
			总共<span class="spanred"><s:property value="%{pageBean.totalPage}"/></span>页,
			当前页是第<span class="spanred"><s:property value="pageBean.currentPage"/></span>页
		</div>
		<div class="clear"></div>
	</div>    

