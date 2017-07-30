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
<title>检索</title>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="css/css.css">

<script type="text/javascript" src="jQuery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    
    function selectProAttr(shxm_mch,shxm_id,shxzh_id,shxzh){
    	
    	var a = "<input type='text' name='search_shxm_shxzh_id' value='{\"shxm_id\":"+shxm_id+",\"shxzh_id\":"+shxzh_id+"}'/>";
		var c = shxm_mch + ":" + shxzh;
		
		$(".search_parm").append(a+c);
    	selectProAttrAjax($("#old_param").val());
    }
   
     function selectProAttrAjax(orderBy){
    	 var flbh2 = ${flbh2};
    	 
    	var params= $("input[name='search_shxm_shxzh_id']");
    	 
    	 var par = "flbh2="+flbh2;
    	 
    	     par += "&orderBy="+orderBy;
    	 $(params).each(function(i,json){
    		 json_obj = $.parseJSON(json.value);
    		 par += "&listValue["+i+"].shxm_id="+json_obj.shxm_id+"&listValue["+i+"].id="+json_obj.shxzh_id;
    	 })
    	 alert(par)
    	 $.ajax({
    		 url:"get_search_attr.do",
    		 data:par,
    		 success : function (data){
    			 if(data.success){
    				 var ele ="";
    				 
    				var datas= data.list_ObjSkuPro;
    				$(datas).each(function(i,json){
    					ele+='<div class="list">';
    				ele+='<div class="img"><img src='+json.product.shp_tp+' alt=""></div>';
    				ele+='	<div class="price">'+json.jg+'</div>';
    				ele+='	<div class="xl">'+json.sku_xl+'</div>';
    				ele+='	<div class="kc">'+json.kc+'</div>';
    				ele+='	<div   class="shp_mch"><a onclick="show_pro_info('+json.id+')">'+json.product.shp_mch+'</a></div>';
    					ele+='</div>';
    				})
    				 $(".Sbox").html(ele);
    			 }else{
    			 alert("出错了");
    			 }
    		 }
    	 })
     }
     
     
     function order_product(new_param){
    	 
    	 var old_param=$("#old_param").val();
    	 if(old_param==new_param){
    		 order_By_sql=new_param+" desc  ";
    		 alert(order_By_sql);
    		 selectProAttrAjax(order_By_sql);
    	 }else{
    		 order_By_sql=new_param;
    		 $("#old_param").attr("value",new_param);
    		 selectProAttrAjax(order_By_sql);
    	 }
    	 
     }
     
     function show_pro_info(sku_id){
    	 alert(sku_id);
    	window.location.href="show_pro_info.do?sku_id="+sku_id+"";
     }
     
     
</script>
</head>
<body>   
   <div class="filter">
		<h2>${flmch2} </h2>
	</div>
	
	<div align="right" >
 
     <jsp:include  page="miniCart.jsp"></jsp:include>
        
      </div>
      
	
   <div class="search_parm">
		<form action="" id="serializeForm" method="post">
		</form>
	</div>
   <div id="order_div">
       <input type="hidden" id="old_param" value="">
     <a  href="javascript:order_product('order by jg');">价格</a>
     <a  href="javascript:order_product('order by sku_xl');">销量</a>
     <a  href="javascript:order_product('order by kc');">库存</a>
     <a  href="javascript:order_product('order by p.chjshj');">时间</a>
   </div>
   <div class="Sscreen">
		<div class="title">
			<!-- 平板电视 商品筛选 共1205个商品 -->
		</div>
			<c:forEach  items="${listAttr}" var="attr">
			   <div class="list">
				<h3>${attr.shxm_mch}</h3>
				  <c:forEach items="${attr.list}" var="val">
	           <h3 style="color: red"><a href="javascript:selectProAttr('${attr.shxm_mch}','${attr.id}','${val.id}','${val.shxzh}');">${val.shxzh_mch}:${val.shxzh}</a></h3>	
				  </c:forEach>
			  </div>
		   </c:forEach>
	  </div>
<div class="Sbox">
        <c:forEach items="${list}" var="sku">
		<div class="list">
			<div class="jg">${sku.jg}</div>
			<div class="xl">${sku.sku_xl}</div>
			<div class="kc">${sku.kc}</div>
			<div class="title"><a onclick="show_pro_info(${sku.id})">${sku.product.shp_mch}</a></div>
		</div>
		</c:forEach>
	</div>
     
</body>
</html>