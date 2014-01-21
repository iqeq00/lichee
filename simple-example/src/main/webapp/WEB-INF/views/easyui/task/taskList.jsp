<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>任务列表</title>
	<jsp:include page="../../../layouts/easyui/linkScript.jsp" />
	<script type="text/javascript">
	
		$(function() {
			$('#datagrid').datagrid({
				url : "${ctx}/easyui/task",
				fit : true,
				fitColumns : true,
				border : false,
				pagination : true,
				rownumbers:true, 
				idField : 'taskId',
				sortName : 'taskId',
				sortOrder : 'desc',
				striped: true, 		
				checkOnSelect : false,
				selectOnCheck : false,
				loadMsg:'正在加载，请稍后...',
				nowrap : false,
				frozenColumns : [ [ {
					title : '任务Id',
					field : 'taskId',
					width : 150,
					sortable : true,
					checkbox : true
				} ]],
				columns : [ [ {
					title : '任务名称',
					field : 'taskName',
					width : 150,
					sortable : true
				},	{
					title : '任务描述',
					field : 'taskDesc',
					width : 150,
					sortable : true
				},  {
					field : 'action',
					title : '操作',
					width : 100,
					formatter : function(value, row, index) { 
						return "<img onclick='update("+row.taskId+");' src='../common/images/pencil.png'/>"+"&nbsp;<img onclick='taskDelete("+row.taskId+");' src='../common/images/cancel.png'/>";
					}
				}] ],
				toolbar : [ {
					text : '任务添加',
					iconCls : 'icon-add',
					handler : function() {
						create();
					}
				}, '-', {
					text : '批量删除',
					iconCls : 'icon-remove',
					handler : function() {
						deleteAll();
					}
				}],
				onDblClickRow : function(index, row){
					update(row.taskId);
				},
				onLoadSuccess:function(data){
	    			//var pset = "1,2,3";
	    			//var grid = $('#testDatagrid');
	    			//grid.datagrid('selectRow', 1);
	    			//grid.datagrid('selectRow', 2);
	    			//grid.datagrid('selectRow', 3);
					//$.each(pset,function(idx,v){
						//var index = grid.datagrid('getRowIndex', v);
						//console.log(index);
						//grid.datagrid('selectRow', parseInt(index));
					//});
				}
			});
		});
		
		//新增  
		function create(){  
			
			$('#datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('<div/>').dialog({
				href : '${ctx}/easyui/task/create',
				width : 300,
				height : 180,
				modal : true,
				title : '任务添加',
				buttons : [ {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#inputForm').form('submit', {
							url : '${ctx}/easyui/task/create',
							success : function(result) {
								try {
									var result = $.parseJSON(result);
									if (result.success) {
										$('#datagrid').datagrid('reload');
										$('#datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
										d.dialog('destroy');
									}
									$.messager.show({
										title : '提示',
										msg : result.msg
									});
								} catch (e) {
									$.messager.alert('提示', result);
								}
							}
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				}
			});
		}  
		
		//修改
		function update(id) {
			
			$('#datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('<div/>').dialog({
				href : '${ctx}/easyui/task/update',
				width : 300,
				height : 180,
				modal : true,
				title : '任务修改',
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#inputForm').form('submit', {
							url : '${ctx}/easyui/task/update',
							success : function(result) {
								try {
									var result = $.parseJSON(result);
									if (result.success) {
										$('#datagrid').datagrid('updateRow', {
											index : $('#datagrid').datagrid('getRowIndex', id),
											row : result.obj
										});
										d.dialog('destroy');
									}
									$.messager.show({
										title : '提示',
										msg : result.msg
									});
								} catch (e) {
									$.messager.alert('提示', result);
								}
							}
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				},
				onLoad : function() {
					var index = $('#datagrid').datagrid('getRowIndex', id);
					var rows = $('#datagrid').datagrid('getRows');
					var o = rows[index];
					$('#inputForm').form('load', o);
				}
			});
		}
		
		//删除
		function taskDelete(id) {

			$('#datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('#datagrid').datagrid('checkRow',$('#datagrid').datagrid('getRowIndex', id));
			deleteAll();
		}

		function deleteAll() {

			var rows = $('#datagrid').datagrid('getChecked');
			var params = "";
			if (rows.length > 0) {
				$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
					if (r) {
						$.each(rows, function(i, task) {
							params += task.taskId + ",";
						});
						$.ajax({
							url : '${ctx}/easyui/task/delete/' + params,
							dataType : 'json',
							success : function(result) {
								if (result.success) {
									$('#datagrid').datagrid('reload');
									$('#datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
								}
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						});
					}
				});
			} else {
				$.messager.show({
					title : '提示',
					msg : '请勾选要删除的记录！'
				});
			}
		}
	</script>
</head>

<body>

	<table id="datagrid"></table>
	
</body>

</html>
