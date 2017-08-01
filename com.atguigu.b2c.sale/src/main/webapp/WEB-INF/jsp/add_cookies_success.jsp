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
<script type="text/javascript" src="jQuery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function update_status(hj,shfxz){
	   
	  var num= $("#zongjine").html();
	  alert(num);
	   $.ajax({
		   url:"update_num.do",
		   data:{
			   num:num,
			   hj:hj,
			   shfxz:shfxz
		   },success:function (data){
			   $("#zongjine").html(data.message);
			   $("#zje").val(data.message);
		   }
	   })
 }
  $(function(){
  	
     $.ajax({
  	   url:"ajax_select_shopingCart.do",
  	   success : function(data){
  		 var  shoppingCarts=  data.shoppingCart_list;
  			   var ele = "";
  			   ele+='   <tr>';
     		    ele+='    <td>是否被选中</td>';
     		    ele+='    <td>商品名称</td>';
     		    ele+='    <td>数量</td>';
     		    ele+='    <td>总价</td>';
     		    ele+='    <td>库存地址</td>';
     		    ele+='    </tr>';
  			   
  		   $(shoppingCarts).each(function(i,json){
  			ele+='   <tr>';
  			ele+=' <td><input onchange="update_status('+json.hj+',this.checked)" type="checkbox" ${json.shfxz=="1"? "checked":""}></td>';
  		    ele+='    <td><input type="hidden" name="list_info['+i+'].sku_mch" value='+json.sku_mch+'>'+json.sku_mch+'</td>';
  		    ele+='    <td><input type="hidden" name="list_info['+i+'].tjshl" value='+json.tjshl+'>'+json.tjshl+'</td>';
  		    ele+='    <td><input type="hidden" name="list_info['+i+'].hj" value='+json.hj+'>'+json.hj+'</td>';
  		    ele+='    <td><input type="hidden" name="dzh_mch" value='+json.kcdz+'>'+json.kcdz+'</td>';
  		    ele+='    <input type="hidden" name="list_info['+i+'].sku_id" value='+json.sku_id+'>';
  		    ele+='    </tr>';
  		   })
  		    ele+=' ';
  		  
  		 $("#shoppingCart_info").html(ele);
  		 $("#zongjine").html(data.message);
  		 $("#zje").val(data.message);
  	   }
     })
   })
   
 </script>
</head>
<body>
 
   <input type="hidden">
      <hr>
    <h1 style="color: red" >${success}</h1>
    <table id="shoppingCart_info" border="1" >
       
    
    </table>
  
  <form action="goto_pay.do" method="post">
     <input type="submit"  value="去结账！">
     <input id="zje" type="hidden" name="zje" value="">
     总金额：<span id="zongjine" style="color: red"></span>元
  </form>

</body>
</html>