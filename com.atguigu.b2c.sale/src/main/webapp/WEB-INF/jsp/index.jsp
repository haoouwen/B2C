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
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript" src="jQuery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
		$(function(){
			   $.getJSON("js/class1.js",function(data){
				   $(data).each(function(i,json){
					 $("#nav_mini").append("<li onmouseover=\"show_class2(this.value)\" value='"+json.Id+"'><a href=\"javascript:;\" id=\"class1_mch\">"+json.flmch1+"</a></li>")  
				   })
			   })
		})
		function show_class2(class1_id){
			
			$("#two_nav").empty();
			$("#two_nav").show();
			 $.getJSON("js/class2-"+class1_id+".js",function(data){
				   $(data).each(function(i,json){
					   $("#two_nav").append("<a href='goto_search.do?flbh2="+json.id+"&flmch2="+json.flmch2+"' value='"+json.id+"'>"+json.flmch2+"</a>")
				   })
			   })
		}
		function goto_login(){
			window.location.href="goto_login.do";
		}
		function goto_register(){
			window.location.href="goto_register.do";
		}
   
		
		$(function(){
			
		var cookies=document.cookie.replace(" ","").split(";");
		 	
		for(var i = 0; i <cookies.length;i++){
			var coo =cookies[i].split("=");
			for(var j = 0 ;j<coo.length;j++){
				if(coo[0]=="user"){
					$("#user_cookie").html(coo[1]);
				}
			}
		}
		
		})
	 
		
		
 </script>
</head>
<body>

   <div class="top">
		<div class="top_text">
			<!-- <a href="">用户登录</a>
			<a href="">用户注册</a>
			<a href="">供应商登录</a>
			<a href="">供应商注册</a> -->
		  <c:if test="${ user!=null }">
			   <h3>欢迎${user.yh_mch}</h3><br>
			   <a href="add_cookies_success.do">购物车</a>
			   <a href="goto_add_aadress.do">用户地址</a>
			   <a href="logout.do">注销</a>
	   </c:if>
	   <c:if test="${ user==null }">
		   <a href="goto_login.do"><span style="color: red" id="user_cookie"></span> 登录 </a><br>
		   <a href="goto_regist.do">注册</a><br>
	   </c:if>
			
		</div>
	</div>
	<div class="top_img">
		<img src="imge/top_img.jpg" alt="">
	</div>

   	<div class="search">
		<div class="logo"><img src="imge/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
		<div class="card">
			
        <jsp:include page="miniCart.jsp"></jsp:include>			
				
			</div>
		
		</div>
	</div>


<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini" id="nav_mini">
						<ul>
							<li>
								<a href="" id="class1_mch">家用电器</a>
								<div class="two_nav" id="two_nav">
									
								</div>
							</li>
							
						</ul>
					</div>
				</div>
				<ul>
					<li><a href="">服装城</a></li>
					<li><a href="">美妆馆</a></li>
					<li><a href="">超市</a></li>
					<li><a href="">全球购</a></li>
					<li><a href="">闪购</a></li>
					<li><a href="">团购</a></li>
					<li><a href="">拍卖</a></li>
					<li><a href="">金融</a></li>
					<li><a href="">智能</a></li>
				</ul>
			</div>
		</div>
	</div>

     <div class="banner">
		<div class="ban">
			<img src="imges/banner.jpg" width="980" height="380" alt="">
		</div>
	</div>

</body>
</html>