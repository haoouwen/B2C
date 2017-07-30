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
   
 </script>
</head>
<body>

  <a href="goto_spu_publish/.do">商品信息管理</a>
  <a href="goto_attr_publish.do">分类属性管理</a>
  <a href="goto_sku_publish.do">库存信息管理</a>

</body>
</html>