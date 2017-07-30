<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
 <%@ page isELIgnored="false" %> 
 <%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath %>" />

   <link rel="stylesheet" type="text/css" href="jQuery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jQuery/themes/icon.css">
	<script type="text/javascript" src="jQuery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="jQuery/jquery.easyui.min.js"></script>
<script type="text/javascript">
    
      function show_tabs(url,title){
        $.post(url,function(data){
        	var b =$("#tt").tabs('exists',title);
        	if(!b){
			$('#tt').tabs('add',{    
			    title:title,    
			    content:data,    
			    closable:true, 
			    href:url
			});  
        }
      })
      }
 </script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
	<ul class="easyui-tree">
		<li>
			<span>My Documents</span>
			<ul>
				<li data-options="state:'closed'">
					<span>后台管理</span>
					<ul>
						<li>
							<span> <a href="javascript:show_tabs('goto_spu_publish/.do','商品信息管理');" >商品信息管理</a></span>
						</li>
						<li>
							<span> <<a href="javascript:show_tabs('goto_attr_publish.do','分类属性管理');"  >分类属性管理</a></span>
						</li>
						<li>               
							<span><a href="javascript:show_tabs('goto_sku_publish.do','库存信息管理');" >库存信息管理</a></span>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'">
			<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">   
			
	</div>
 </div>
</body>
</html>