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
 <title>注册页面</title>

<base href="<%=basePath %>" />
  <link rel="stylesheet" href="css/sign.css"/>
<script type="text/javascript" src="jQuery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
   
   function check_userName(yh_mch){
	   alert(yh_mch)
	   $.ajax({
	   url:"check_yhmch.do",
	   typt:"post",
	   data:{
		   yu_mch:yh_mch
	   },success : function (data){
		   $("#message").html(data.message);
	   }
	   })
   }
   
 </script>
</head>
<body>
<div class="header">
        <a class="logo" href="##"></a>
        <div class="desc">欢迎注册</div>
    </div>
    <!--版心-->
    <div class="container">
    	<!--京东注册模块-->
    <form action="regist.do" method="post">
    	
    	<div class="register">
    		<!--用户名-->
    		<div class="register-box">
    			
    			<div class="box default">
    				<label for="userName">用户名称</label>
    				<input type="text" onchange="check_userName(this.value)"  name="yh_mch" placeholder="用户名称" /><span id="message"></span>
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    			<div class="box default">
    				<label for="userName">用户昵称</label>
    				<input type="text"  name="yh_nch" placeholder="用户昵称" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    			
    			<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd">设 置 密 码</label>
    				<input type="password" name="yh_mm" placeholder="建议至少两种字符组合" />
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    			
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    			<div class="box default">
    				<label for="userName">用户姓名</label>
    				<input type="text"  name="yh_xm" placeholder="用户姓名" />
    				<i></i>
    			</div>
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    			<div class="box default">
    				<label for="userName">用户姓名</label>
    				<input type="text"  name="yh_yx" placeholder="用户邮箱" />
    				<i></i>
    			</div>
    		</div>
    
    		 <!--注册协议-->
    		<div class="register-box xieyi">
    			<!--表单项-->
    			<div class="box default">
    				<input type="checkbox" id="ck" />
    				<span>我已阅读并同意<a href="##">《京东用户注册协议》</a></span>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--注册-->
    		<input type="submit" value="注册">
    	</div>
    	</form>
    </div>



</body>
</html>