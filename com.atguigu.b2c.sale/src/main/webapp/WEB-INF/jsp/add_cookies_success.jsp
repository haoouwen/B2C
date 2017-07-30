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
   
    $(function(){
    	
       $.ajax({
    	   url:"ajax_select_shopingCart.do",
    	   success : function(data){
    		 var  shoppingCarts=  data.shoppingCart_list;
    			   var ele = "";
    			   ele+='   <tr>';
       		    ele+='    <td>商品名称</td>';
       		    ele+='    <td>数量</td>';
       		    ele+='    <td>总价</td>';
       		    ele+='    </tr>';
    			   
    		   $(shoppingCarts).each(function(i,json){
    			   
    			ele+='   <tr>';
    		    ele+='    <td>'+json.sku_mch+'</td>';
    		    ele+='    <td>'+json.tjshl+'</td>';
    		    ele+='    <td>'+json.hj+'</td>';
    		    ele+='    </tr>';
    		   })
    		 $("#shoppingCart_info").html(ele);
    	   }
       })
     })
 </script>
</head>
<body>
    
      <hr>
    <h1 style="color: red" >${success}</h1>
    <table id="shoppingCart_info" border="1" >
       
    
    </table>


</body>
</html>