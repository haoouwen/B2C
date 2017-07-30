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
   
  function show_minicart(){
	 

	   $.ajax({
		   url:"show_mini_shopingCart.do",
		   success: function(data){
			  alert("1");
			   $("#mini_cart_div").html(data);

			   $("#mini_cart_div").show();
		   }
	   });
 
   
   
 }
   
  function hide_minicart(){
	 
	$("#mini_cart_div").hide();
  }
  
 </script>
</head>
<body>
   
    <a href="javascript:;" onmouseover="show_minicart()" onmousemove="hide_minicart()">购物车<div class="num">0</div></a>
			
			<!--购物车商品-->
			<div class="cart_pro">
				<h6>最新加入的商品</h6>
				
				
				<div class="gobottom">
					共<span>2</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
					共计￥<span>20000</span>
					<button class="goprice">去购物车</button>
				</div>
				
				</div>


   <h1 >我的购物车</h1>
  <div id="mini_cart_div" style="display: none;">
   
 </div>
 
</body>
</html>