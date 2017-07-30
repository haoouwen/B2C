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
			   $("#spu_publish_class_1_select").append("<option value='"+json.Id+"'>"+json.flmch1+"</option>")
		   })
	   })
});
     /* 一级列表被选择，后加载二级列表 */
    function select_flxx(class1_id){
    	 $("#spu_publish_class_2_select").empty();
    	$.getJSON("js/class2-"+class1_id+".js",function(data){
    		$(data).each(function(i,json){
    			$("#spu_publish_class_2_select").append("<option value='"+json.id+"'>"+json.flmch2+"</option>")
    		})
    	})
    	select_pp(class1_id);
     }
     /*加载品牌列表 */
   function select_pp(class1_id){
	   $("#spu_publish_class_tm_select").empty();
    	 $.getJSON("js/trade-mark-"+class1_id+".js",function(data){
    		 $(data).each(function(i,json){
    			 $("#spu_publish_class_tm_select").append("<option value='"+json.id+"'>"+json.ppmch+"</option>")
    		 })
    	 })
     }
   function select_tp(index){
	  
	   $("#tp_"+index).click();
   }
   function spu_tp_replace(index){
	  
	   var imgfile =$("#tp_"+index)[0].files[0];
	     var imgsrc =window.URL.createObjectURL(imgfile);
	     $("#img_"+index).attr("src",imgsrc);
	     add_img(index+1);
	     
   }
   
     function add_img(index){
    	alert(index);
	     var a ='<img  id="img_'+index+'" style="cursor:pointer;float:left;" src="imge/upload_hover.png" onclick="select_tp('+index+')">';
    	 var b ='<input style="display: none;" type="file" id="tp_'+index+'" name="image_file" onchange="spu_tp_replace('+index+')"/>';
    	 $("#addimg").append(a+b);
     }
 </script>
</head>
<body>
${success}
<form action="saveProduct.do" method="post" enctype="multipart/form-data">
		<select name="flbh1" id="spu_publish_class_1_select" onChange="select_flxx(this.value)"></select><br>
		<select name="flbh2" id="spu_publish_class_2_select"></select><br>
		<select name="pp_id" id="spu_publish_class_tm_select"></select><br>
		
		商品名称<input type="text" name="shp_mch"/><br>
		商品描述<input type="text"  name="shp_msh"/><br>
		
		<dir id="addimg">
		<img alt="" id="img_0" src="imge/upload_hover.png" onclick="select_tp(0)">
		
		商品图片<input style="display: none;" type="file" id="tp_0" name="image_file" onchange="spu_tp_replace(0)"/><br>
		</dir>
		<input type="submit" value="发布商品信息"/>
	</form>


</body>
</html>