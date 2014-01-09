<%@ page language="java" pageEncoding="UTF-8"%>
<div data-options="region:'north'" style="height:80px;padding:10px;font-size:14px;">
	
	<div style="position: absolute; right: 0px; bottom: 0px; ">
		<a href="javascript:void(0)" class="easyui-menubutton" data-options="menu:'#controlPanel',iconCls:'icon-help'">控制面板</a>
		<a href="javascript:void(0)" class="easyui-menubutton" data-options="menu:'#logoutPanel',iconCls:'icon-back'">注销</a>
	</div>
	<div id="controlPanel" style="width:150px;">
		<div onclick="">个人信息</div>
		<div class="menu-sep"></div>
		<div>
			<span>更换皮肤</span>
			<div style="width:150px;">
				<div onclick="changeThemeFun('default');return false;" style="cursor:pointer">默认风格</div>
				<div onclick="changeThemeFun('gray');return false;" style="cursor:pointer">轻描淡写</div>
				<div onclick="changeThemeFun('cupertino');return false;" style="cursor:pointer">海洋之心</div>
				<div onclick="changeThemeFun('dark-hive');return false;" style="cursor:pointer">古典黑韵</div>
				<div onclick="changeThemeFun('pepper-grinder');return false;" style="cursor:pointer">古典黄韵</div>
				<div onclick="changeThemeFun('sunny');return false;" style="cursor:pointer">灿烂春日</div>
			</div>
		</div>
	</div>
	<div id="logoutPanel" style="width: 100px;">
		<div onclick="">锁定窗口</div>
		<div class="menu-sep"></div>
		<div onclick="">重新登录</div>
		<div onclick="">退出系统</div>
	</div>
	
</div>