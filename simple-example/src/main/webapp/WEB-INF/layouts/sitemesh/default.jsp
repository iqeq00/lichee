<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>simple example演示:<sitemesh:title/></title>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="text/css" rel="stylesheet" href="${ctx}/common/script/bootstrap/2.3.0/css/bootstrap.min.css"/>
<script type="text/javascript" src="${ctx}/common/script/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ctx}/common/script/bootstrap/2.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/common/script/jquery/bootstrap-validation.js"></script>
<sitemesh:head/>

</head>

<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/sitemesh/header.jsp"%>
		<div id="content">
			<sitemesh:body/>
		</div>
		<%@ include file="/WEB-INF/layouts/sitemesh/footer.jsp"%>
	</div>
</body>
</html>