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
     /*
      页面加载完成后，异步加载js数据
     */
$(function(){
	   
	   $.getJSON("js/class1.js",function(data){
		   
		   $(data).each(function(i,json){
			   $("#sku_publish_class_1_select").append("<option value='"+json.Id+"'>"+json.flmch1+"</option>")
		   })
	   })
});
     /* 一级列表被选择，后加载二级列表 */
    function select_flxx(class1_id){
    	 $("#sku_publish_class_2_select").empty();
    	$.getJSON("js/class2-"+class1_id+".js",function(data){
    		$(data).each(function(i,json){
    			$("#sku_publish_class_2_select").append("<option value='"+json.id+"'>"+json.flmch2+"</option>")
    		})
    	})
    	
    	select_pp(class1_id);
     }
     /*加载品牌列表 */
   function select_pp(class1_id){
	   $("#sku_publish_class_tm_select").empty();
    	 $.getJSON("js/trade-mark-"+class1_id+".js",function(data){
    		 $(data).each(function(i,json){
    			 $("#sku_publish_class_tm_select").append("<option value='"+json.id+"'>"+json.ppmch+"</option>")
    		 })
    	 })
     }
     
     
  function select_shp_mch(){
	var flbh1=  $("#sku_publish_class_1_select").val();
	var flbh2=  $("#sku_publish_class_2_select").val();
	var pp_id=  $("#sku_publish_class_tm_select").val();
	$("#sku_publish_class_shp_mch_select").empty();
	$.get("get_shp_mch.do",{flbh1:flbh1,flbh2:flbh2,pp_id:pp_id},function(data){
		var datas = data.list_product;
		$(datas).each(function(i,json){
			$("#sku_publish_class_shp_mch_select").append("<option name='shp_id'  value='"+json.id+"'>"+json.shp_mch+"</option>")
		})
		
	})  
	show_attr();
  }
  function show_attr(){
	  
	  var flbh2=  $("#sku_publish_class_2_select").val();
	  var flmch2=  $("#sku_publish_class_2_select").html();
	   $.ajax({
		  url:"select_attr.do",
		  type:"post",
		   data:{
			   flbh2:flbh2,
			   flmch2:flmch2
		   },
		   before:function(){
			   
		   },
		   success:function(data){
			   if(data.success){
				  class2Attrs = data.list;
				   var ele ="<h1>分类属性列表:<h1>";
				   $(class2Attrs).each(function(i,class2Attr){
					   ele +='<input type="checkbox" id="'+class2Attr.id+'" name="list['+i+'].id" onclick="option_attr(this.value,this.checked)" value="'+class2Attr.id+'" />'+class2Attr.shxm_mch;
				   })
				    $(class2Attrs).each(function(i,class2Attr){
				    	
					   attrValues = class2Attr.list;
					   ele += '<div id="for_sku_value_area_'+class2Attr.id+'" style="display:none;">'; 
					   $(attrValues).each(function(j,attrValue){
						   ele += '<input type="radio"  name="list['+i+'].list[0].id"  value="'+attrValue.id+'" />'+attrValue.shxzh+"   ";
						   ele += attrValue.shxzh_mch+"";
						   ele += "<br>";
					   })
					   ele += "</div>";
				   })
				    ele +="<br><hr>"
				   $("#attr_info").html(ele);
			   }else{
				   alert("出错了");
			   }
		   }
	   })
  }
     //当单选框状态改变后，隐藏或显示属性
  function option_attr(id,ckeck){
    	 if(ckeck){
    		 $("#for_sku_value_area_"+id).show();
    	 }else{
    		 
    		 $("#for_sku_value_area_"+id).hide();
    	 }
     }
     
 </script>
</head>
<body>
${success}
<form action="saveSkuInfo.do" method="post" >
		一级分类列表：<select name="flbh1" id="sku_publish_class_1_select" onChange="select_flxx(this.value)"></select><br>
		二级分类列表<select name="flbh2" id="sku_publish_class_2_select" onChange="select_shp_mch()"></select><br>
		品牌:<select name="pp_id" id="sku_publish_class_tm_select" onChange="select_shp_mch()"></select><br>
		商品名称:<select name="shp_id" id="sku_publish_class_shp_mch_select" ></select><br>
		<div id="attr_info">
        </div>
        库存名称：<input type="text" name="sku_mch" >
        库存数量：<input type="text" name="kc" >
        库存价格：<input type="text" name="jg" >
        库存地址：<input type="text" name="kcdz" >
        
        
        <input type="submit" value="发布库存信息"/>
	</form>
</body>
</html>