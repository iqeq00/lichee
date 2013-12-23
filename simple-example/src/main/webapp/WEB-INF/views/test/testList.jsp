<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>测试列表</title>
	<jsp:include page="../base/meta.jsp" />
	<jsp:include page="../base/linkScript.jsp" />
	<script type="text/javascript">
	
		$(function() {
			$('#testDatagrid').datagrid({
				url : '../test/testList',
				fit : true,
				fitColumns : true,
				border : false,
				pagination : true,
				rownumbers:true, 
				idField : 'testId',
				sortName : 'testId',
				sortOrder : 'desc',
				striped: true, 		
				checkOnSelect : false,
				selectOnCheck : false,
				loadMsg:'正在加载，请稍后...',
				nowrap : false,
				frozenColumns : [ [ {
					title : '测试Id',
					field : 'testId',
					width : 150,
					sortable : true,
					checkbox : true
				} ]],
				columns : [ [ {
					title : '测试名称',
					field : 'testName',
					width : 150,
					sortable : true
				}, {
					field : 'action',
					title : '动作',
					width : 100,
					formatter : function(value, row, index) { 
						return "<img onclick='testInfo("+row.testId+");' src='../static/images/pencil.png'/>"+"&nbsp;<img onclick='testDelete("+row.testId+");' src='../static/images/cancel.png'/>";
					}
				}] ],
				toolbar : [ {
					text : '测试添加',
					iconCls : 'icon-add',
					handler : function() {
						testAdd();
					}
				}, '-', {
					text : '批量删除',
					iconCls : 'icon-remove',
					handler : function() {
						testDeleteAll();
					}
				}],
				onDblClickRow : function(index, row){
					testInfo(row.testId);
				},
				onLoadSuccess:function(data){
	    			//var pset = "1,2,3";
	    			var grid = $('#testDatagrid');
	    			grid.datagrid('selectRow', 1);
	    			grid.datagrid('selectRow', 2);
	    			grid.datagrid('selectRow', 3);
					//$.each(pset,function(idx,v){
						//var index = grid.datagrid('getRowIndex', v);
						//console.log(index);
						//grid.datagrid('selectRow', parseInt(index));
					//});
				}
			});
		});
		
		//新增  
		function testAdd(){  
			
			$('#testDatagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('<div/>').dialog({
				href : '../test/testAddJsp',
				width : 300,
				height : 100,
				modal : true,
				title : '测试添加',
				buttons : [ {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#testAddForm').form('submit', {
							url : '../test/testAdd',
							success : function(result) {
								try {
									var result = $.parseJSON(result);
									if (result.success) {
										$('#testDatagrid').datagrid('reload');
										$('#testDatagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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
		function testInfo(testId) {
			
			$('#testDatagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('<div/>').dialog({
				href : '../test/testInfoJsp',
				width : 300,
				height : 100,
				modal : true,
				title : '测试修改',
				buttons : [ {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						var d = $(this).closest('.window-body');
						$('#testUpdateForm').form('submit', {
							url : '../test/testUpdate',
							success : function(result) {
								try {
									var result = $.parseJSON(result);
									if (result.success) {
										$('#testDatagrid').datagrid('updateRow', {
											index : $('#testDatagrid').datagrid('getRowIndex', testId),
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
					var index = $('#testDatagrid').datagrid('getRowIndex', testId);
					var rows = $('#testDatagrid').datagrid('getRows');
					var o = rows[index];
					$('#testUpdateForm').form('load', o);
				}
			});
		}
		
		//删除
		function testDelete(testId) {

			$('#testDatagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
			$('#testDatagrid').datagrid('checkRow',$('#testDatagrid').datagrid('getRowIndex', testId));
			testDeleteAll();
		}

		function testDeleteAll() {

			var rows = $('#testDatagrid').datagrid('getChecked');
			var params = "";
			if (rows.length > 0) {
				$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
					if (r) {
						$.each(rows, function(i, test) {
							params += test.testId + ",";
						});
						$.ajax({
							url : '../test/testDelete/' + params,
							dataType : 'json',
							success : function(result) {
								if (result.success) {
									$('#testDatagrid').datagrid('reload');
									$('#testDatagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
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

	<table id="testDatagrid"></table>
	
</body>

</html>
