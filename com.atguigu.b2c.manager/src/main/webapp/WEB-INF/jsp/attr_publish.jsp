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
<script type="text/javascript" src="js/layer.js"></script>
<script type="text/javascript">
   
   $(function(){
	   $.getJSON("js/class1.js",function(data){
		   $(data).each(function(i,json){
			 $("#class1").append("<option value='"+json.Id+"'>"+json.flmch1+"</option>")  
		   })
	   })
   })
   function select_class1(class1_id){
	   $.getJSON("js/class2-"+class1_id+".js",function(data){
		   $(data).each(function(i,json){
			   $("#class2").append("<option value='"+json.id+"'>"+json.flmch2+"</option>")
		   })
	   })
   }
   function show_attr(class2_id){
	   var flmch2 = $("#class2 option:selected").html();
	   var flbh2 = $("#class2 option:selected").val();
	   $.ajax({
		  url:"show_attr.do",
		  type:"post",
		   data:{
			   class2_id:class2_id,
			   flmch2:flmch2
		   },
		   before:function(){
			   
		   },
		   success:function(data){
			   if(data.success){
				  class2Attrs = data.list;
				   var ele ="";
				   $(class2Attrs).each(function(i,class2Attr){
					   ele += class2Attr.shxm_mch+"<br>";
					   attrValues = class2Attr.list;
					   $(attrValues).each(function(i,attrValue){
						   ele += attrValue.shxzh+"   ";
						   ele += attrValue.shxzh_mch+"   ";
						   ele += "<br>";
					   })
					   
				   })
				   
				   $("#attr_info").html(ele)
			   }else{
				   alert("出错了");
			   }
		   }
		   
	   })
   }
   
   function add_attr(){
	  
	   var flmch2 = $("#class2 option:selected").html();
	   var  flbh2 =$("#class2 option:selected").val();
	  
	  window.location.href="add_attr/"+flbh2+"/"+flmch2+".do";
   }
   
 </script>
</head>
<body>
 <h1>分类属性列表</h1>
   一级分类列表 <select  id="class1" onchange="select_class1(this.value)"></select>
    二级分类列表<select  id="class2" onchange="show_attr(this.value)"></select>
    <hr>
 <div id="attr_info">
 
 </div>
 <a href="javascript:add_attr();" id="add" >添加分类属性</a>

</body>
</html>