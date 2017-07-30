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
   
   function add_address(){
	  
	   $("#add_address_from").show();
   }
   
   function save_address(){
	 
	   var yh_dz=$("#yh_dz").val();
	   var shjr=$("#shjr").val();
	   var lxfsh=$("#lxfsh").val();
	   
	  $("#add_address_from").hide();
	  $.ajax({
		  url:"save_address.do",
		  data:{
			  yh_dz:yh_dz,
			  shjr:shjr,
			  lxfsh:lxfsh
		  },success:function(data){
			  alert(data);
			  var e ="";
			e=e+' <tr>';
		    e=e+'   <td>data.object.yh_dz</td>';
		    e=e+'   <td>data.object.dzzt</td>';
		    e=e+'   <td>data.object.shjr</td>';
		    e=e+'   <td>data.objectlxfsh</td>';
		    e=e+'  </tr>';
			  $("#address_tbody").append(e);
		  }
	  })
   }
 </script>
</head>
<body>
<h2 style="color: red "> 用户地址列表</h2>
    <table border="1">
    <thead>
      <tr>
      <td>用户地址</td>
      <td>地址状态</td>
      <td>收件人</td>
      <td>联系方式</td>
      </tr>
    </thead>
     <tbody id="address_tbody">
     <c:forEach items="${list_address}" var="address">
       <tr>
        <td>${address.yh_dz}</td>
        <td>${address.dzzt}</td>
        <td>${address.shjr}</td>
        <td>${address.lxfsh}</td>
       </tr>
       </c:forEach>
       
     </tbody>
    </table>
   <h3><input type="submit" onclick="add_address()" value="添加地址"></h3>
   
    <div id="add_address_from" style="display: none;">
     <form id="address_form" action="javascript:save_address();" method="post">
           用户地址:<input id="yh_dz" name="yh_dz" type="text">
	   收件人: <input id="shjr" name="shjr" type="text">
	   联系方式 <input id="lxfsh" name="lxfsh" type="text">
	   <input type="submit" value="添加">
     </form>
    </div>
    
    
    

</body>
</html>