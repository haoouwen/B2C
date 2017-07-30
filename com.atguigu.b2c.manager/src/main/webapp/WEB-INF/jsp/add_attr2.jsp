<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />

<script type="text/javascript">
	var attr_add_table_index = 1;

	function attr_add_table(){
		var del_id = "attr_add_"+attr_add_table_index+"_0";
		var a = '<table id="attr_add_table_'+attr_add_table_index+'" border="1">';
		var b = '<tr><td>属性名：<input type="text" name = "list['+attr_add_table_index+'].shxm_mch"/></td><td></td><td><a href="javascript:attr_add_tr('+attr_add_table_index+');">添加值</a></td></tr>';
		var c = '<tr id = "'+del_id+'"><td>属性值：<input type="text" name = "list['+attr_add_table_index+'].list[0].shxzh"/></td><td>属性值名：<input type="text" name = "list['+attr_add_table_index+'].list[0].shxzh_mch"/></td><td><a href="javascript:attr_add_tr_del(\''+del_id+'\');">删除</a></td></tr>';
		var d = '</table>';
		$("#attr_add_table_"+(attr_add_table_index-1)).after("<br>"+a+b+c+d);
		attr_add_table_index++;
	}
	
	function attr_add_tr(attr_add_table_index_table){
		// 先获得需要添加值的table
		var table = $("#attr_add_table_"+attr_add_table_index_table);
		
		// 在table内部添加tr的值输入域
		var tr_length = $("#attr_add_table_"+attr_add_table_index_table+" tr").length - 1;
		var del_id = "attr_add_"+attr_add_table_index_table+"_"+tr_length;
		table.append('<tr id = "'+del_id+'"><td>属性值：<input type="text" name = "list['+attr_add_table_index_table+'].list['+tr_length+'].shxzh"/></td><td>属性值名：<input type="text" name = "list['+attr_add_table_index_table+'].list['+tr_length+'].shxzh_mch"/></td><td><a href="javascript:attr_add_tr_del(\''+del_id+'\');">删除</a></td></tr>');	
	}
	
	function attr_add_tr_del(del_id){
	
		if($("#"+del_id).next().length!=0){
		 $("#"+del_id).remove();
			
		}else{
			$("#"+del_id).parent().remove();
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new jsp</title>
</head>
<body>
	添加${class_2_name}${class_2_id}分类属性:<br>
	<a href="javascript:attr_add_table();">添加属性表格</a>:<br>
	<form action="attr_add.do" method="post">
		<input type="hidden" name="flmch2" value="${flmch2}"/>
		<input type="hidden" name="flbh2" value="${flbh2}"/>
		
		<table id="attr_add_table_0" border="1">
			    <tr>
				   <td>属性名：<input type="text" name = "list[0].shxm_mch"/></td><td></td><td><a href="javascript:attr_add_tr(0);">添加值</a></td>
				</tr>
				<tr  id="attr_add_0_0">
				<td>属性值：<input  type="text" name = "list[0].list[0].shxzh"/></td>
				<td>属性值名：<input type="text" name = "list[0].list[0].shxzh_mch"/></td>
				<td><a href="javascript:attr_add_tr_del('attr_add_0_0');">删除</a></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="发布分类属性">
	</form>
	
</body>
</html>