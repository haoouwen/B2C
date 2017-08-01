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
    
    <h2>订单列表页</h2>
    <form action="to_pay.do" method="post">
       <table>
       <h3>选择地址</h3>
          <c:forEach items="${get_address}" var="address">
           <input type="checkbox" value="${address.yh_dz}" name="dzh_mch">${address.yh_dz}
           <input type="hidden" value="${address.id}" name="dzh_id">${address.id}
           <input type="checkbox" value="${address.shjr}" name="shhr">${address.shjr}
          </c:forEach>
       </table>
       <c:forEach items="${list_order}" var="order">
       <table>
       共计：${order.zje}
       <c:forEach items="${order.list_info}" var="order_info">
       <tr><td>${order_info.sku_mch}</td><td>${order_info.sku_jg}</td><td>${order_info.sku_shl}</td></tr>
       </table>
       </c:forEach>
    </c:forEach>
    <br>
    总金额：<input type="hidden" name="zje" value="${sum}">${sum}
    
    <br><input type="submit" value="支付">
    </form>

</body>
</html>