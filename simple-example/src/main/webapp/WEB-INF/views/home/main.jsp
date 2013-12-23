<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>后台管理</title>
<jsp:include page="../base/meta.jsp" />
<jsp:include page="../base/linkScript.jsp" />
<script type="text/javascript">

	var centerTabs;
	function addTabFun(opts) {
		var options = $.extend({
			title : '',
			content : '<iframe src="' + opts.src + '" frameborder="0" style="border:0;width:100%;height:99.2%;"></iframe>',
			closable : true,
			iconCls : ''
		}, opts);
		if (centerTabs.tabs('exists', options.title)) {
			centerTabs.tabs('close', options.title);
		}
		centerTabs.tabs('add', options);
	}

	$(function(){
		centerTabs = $('#centerTabs').tabs({
			border : false,
			fit : true
		});
		
		$('#tt').tree({  
		    url:'${ctx}/static/json/tree_data.json',
		    animate:true,
		    lines:true,
		    //onlyLeafCheck:true,
		    //checkbox:true,
		    //dnd:true,
			onClick:function(node){
				
				if(node.attributes){
					var href = node.attributes.src;
					$.messager.progress({
						text : '请求数据中....',
						interval : 100
					});
					addTabFun({
						src : href,
						title : node.text
					});
				}
			}
		});  
		
		setTimeout(function() {
			var src = 'index';
			centerTabs.tabs('add', {
				title : '首页',
				content : '<iframe src="' + src + '" frameborder="0" style="border:0;width:100%;height:99.2%;"></iframe>',
				closable : true,
				iconCls : ''
			});
		}, 0);
		
	});
	
	
</script>
</head>

<body class="easyui-layout">
	<jsp:include page="../layout/header.jsp" />
	<jsp:include page="../layout/left.jsp" />
	<jsp:include page="../layout/center.jsp" />
	<jsp:include page="../layout/footer.jsp" />
</body>

</html>
