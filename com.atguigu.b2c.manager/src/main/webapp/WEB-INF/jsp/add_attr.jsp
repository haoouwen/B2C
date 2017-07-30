<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
 <%@ page isELIgnored="false" %> 
 <%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <base href="<%=basePath %>" /> 
<script type="text/javascript">
   function add_attr(index){
	   index= index+1;
	    var ele="";
	   ele+='   <table id="add_attr_'+index+'" background="1" border="1">';
	   ele+='   <tr> ';
	   ele+='   <td>属性名：<input type="text" name="shxmch" ></td>';
	   ele+='   <td></td>';
	   ele+='   <td><input type="submit" value="添加属性" onclick="add_attr_value()"></td>';
	   ele+='   </tr>';
	   ele+='   <tr id="remove_0"> ';
	   ele+='   <td>属性值：<input type="text" name="shxzh" ></a></td>';
	   ele+='   <td>属性值名：<input type="text" name="shxzh" ></a</td>';
	   ele+='   <td><input type="submit" value="删除" onclick="delete_attr_value()"></td>';
	   ele+='   </tr>';
	   ele+='   </table><br>';
	 
	  var n = index-1;
	 
	   $("#add_attr_"+n).after(ele);
	   
   }        
   
   function add_attr_value(index){
	   var ele ="";
	ele+='  <tr id="shx_1"> ';
	ele+='  <td>属性值：<input type="text" name="list[0].list[0].shxzh" ></a></td>';
	ele+='  <td>属性值名：<input type="text" name="list[0].list[0].shxzh_mch" ></a</td>';
	ele+='  <td><input type="submit" value="删除" onclick="delete_attr_value()"></td>';
	ele+='  </tr>';
	
	   $("#add_attr_"+index).append(ele);
	   return false;
	  
   }
   function delete_attr_value(){
	  
	   $("#shx_0").remove();
	   
   }
 </script>
</head>
<body>

	<h1>添加属性:${flmch2}</h1>
	<h1>${message}</h1>
		
		
		<h1><button onclick="add_attr(0)">添加属性</button></h1>
		  <form  action="" method="post"> 
		  
		 <table id="add_attr_0"  border="1">
		   <tr> 
		   <td>属性名：<input type="text" name="list[0].shxm_mch" ></td>
		   <td></td>
		   <td><a href="javascript:;" onclick="add_attr_value(0)">添加属性</a></td>
		   </tr>
		   
		   <tr id="shx_0"> 
		   <td>属性值：<input type="text" name="list[0].list[0].shxzh" ></a></td>
		   <td>属性值名：<input type="text" name="list[0].list[0].shxzh_mch" ></a</td>
		   <td><button onclick="delete_attr_value()">删除</button></td>
		   </tr>
		   </table><br>
		 
		  <input type="submit" value="提交">
		   </form> 
		 
  </body>
</html>