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
   
   function change_sku(sku_id){
	   alert(sku_id);
   }
   
 </script>
</head>
<body>
 
   <div align="right" >
 
     <jsp:include  page="miniCart.jsp"></jsp:include>
        
      </div>
   
   
      <div class="Sbox">
        
		<div class="list">
			<div class="img"><img src="${sku.product.shp_tp}" alt=""></div>
			<div class="jg">${sku.jg}</div>
			<div class="xl">${sku.sku_xl}</div>
			<div class="kc">${sku.kc}</div>
			<div class="title">${sku.product.shp_mch}</div>
			<c:forEach items="${list}" var="obj_pro">
			<a href="javascript:change_sku(${obj_pro.id});" >${obj_pro.sku_mch}</a>
			</c:forEach>
		</div>
	</div>
		<div class="list">
			<div class="img"><img src="${skuPro.product.shp_tp}" alt=""></div>
			<div class="jg">${skuPro.jg}</div>
			<div class="xl">${skuPro.sku_xl}</div>
			<div class="kc">${skuPro.kc}</div>
			<div class="title"><a >${skuPro.product.shp_mch}</a></div>
		</div>
	</div>
 

   <form  action="add_shopping_cart.do" method="post">
    <input type="hidden" name="sku_id" value="${skuPro.id}">
    <input type="hidden" name="sku_mch" value="${skuPro.sku_mch}">
    <input type="hidden" name="sku_jg" value="${skuPro.jg}">
    <input type="hidden" name="tjshl" value="1">
    <input type="hidden" name="hj" value="${skuPro.jg}">
    <input type="hidden" name="yh_id" value="${user.id}">
    <input type="hidden" name="shfxz" value="1">
    <input type="hidden" name="kcdz" value="${kcdz}">
    <input type="submit"  value="提交购物车" >
   </form>

</body>
</html>