<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html style="height: 100%;">
<head>
	<meta charset="UTF-8">
	<title>Basic Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		function urlClick(){
		
			var tabExists = $("#tabs").tabs("exists","学生管理");
			//不存在该选项卡打开，存在就选中
			if(!tabExists){
				$("#tabs").tabs("add",{
					title:'学生管理',    //标题
				    content:'<iframe src="studentManager.html" frameborder=0 scrolling="no" width="100%" height="100%"></iframe>',    //内容
				    closable:true,  //是否能被关闭  
				})
			}else{
				$("#tabs").tabs("select","学生管理");
			}
		}
	</script>
</head>
<body style="margin: 1px;height: 100%">
	<div class="easyui-layout" style="width:100%;height:100%;margin:0px">
		<div data-options="region:'north'" style="height:170px"></div>
		<div data-options="region:'west',split:true" title="导航菜单" style="width:20%;">
			<div class="easyui-accordion" style="width:500px;height:300px;">
				<div title="权限管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<c:forEach var="menu" items="${requestScop.menuList}">
					
					</c:forEach>
					<a href="javaScript:urlClick('${menu.menuName}','${pageContext.request.contextPath}${menu.menuUrl}')" style="text-decoration: none;"><img alt="" src="themes/icons/search.png" style="margin-top: 5px">${menu.menuName}</a>
				</div>
				<div title="系统配置" data-options="iconCls:'icon-help'" style="padding:10px;">

				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div id="tabs" class="easyui-tabs" style="width:100%;height:100%;">
				<div title="欢迎使用" style="padding:10px">
				</div>
				<!--<div title="学生管理" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
				</div>-->
			</div>
		</div>
	</div>
 
</body>
</html>