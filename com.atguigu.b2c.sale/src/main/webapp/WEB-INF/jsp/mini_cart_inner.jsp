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
   function update_status(sku_id,tjshl,sfxz){
	   alert(sku_id+" "+tjshl+" "+sfxz)
        $.ajax({
        	url:"update_shopping_cart.do",
        	data:{
        		sku_id:sku_id,
        		tjshl:tjshl,
        		sfxz:sfxz
        	},success : function (data){
        		var datas = data.shoppingCart_list;
        		var ele="";
        		$(datas).each(function(i,json){
        	ele+='	<tr>';
       		ele+=' <td></td><input onchange="update_status(${shoppingCart.sku_id},${shoppingCart.tjshl},this.checked)" type="checkbox" ${shoppingCart.shfxz==1?"checked":""}></td>';
       		ele+='  <td><img alt="" src="${shoppingCart.shp_tp}" ></td>';
       		ele+=' <td><h3>${shoppingCart.sku_mch}</h3></td>';
       		ele+=' <td><h3>${shoppingCart.sku_jg}</h3></td>';
       		ele+=' <td><button onclick="update_tjshl(${shoppingCart.sku_id},(${shoppingCart.tjshl}+1),-1)">+</button><h3>${shoppingCart.tjshl}</h3><button onclick="update_tjshl(${shoppingCart.sku_id},(${shoppingCart.tjshl}-1),-1)">-</button></td>';
       		ele+=' <td><h3>${shoppingCart.hj}</h3></td>';
       		ele+='  <td><button style="color: red" onclick="delete_cart(${shoppingCart.sku_id})">删除</button></td>';
       		ele+='   </tr>';
        		})
        		var message = data.message;
        		var m = message.split("");
        		$("#mini_cart").html(ele);
        		
        		
        		$("#tongji").html("共<span >"+m[0]+"</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;共计￥<span>"+m[1]+"</span><button class=\"goprice\">去购物车</button>");
        	}
        	
        })
	  }
   function update_tjshl(sku_id,tjshl,sfxz){
	  alert(sku_id+" "+tjshl+" "+sfxz)
	   if(tjshl!=0){
	   $.ajax({
        	url:"update_shopping_cart.do",
        	data:{
        		sku_id:sku_id,
        		tjshl:tjshl,
        		sfxz:sfxz
        	},success : function (data){
        		var datas = data.shoppingCart_list;
        		var ele="";
        		$(datas).each(function(i,json){
        	ele+='	<tr>';
       		ele+=' <td></td><input onchange="update_status(${shoppingCart.sku_id},${shoppingCart.tjshl},this.checked)" type="checkbox" ${shoppingCart.shfxz==1?"checked":""}></td>';
       		ele+='  <td><img alt="" src="${shoppingCart.shp_tp}" ></td>';
       		ele+=' <td><h3>${shoppingCart.sku_mch}</h3></td>';
       		ele+=' <td><h3>${shoppingCart.sku_jg}</h3></td>';
       		ele+=' <td><button onclick="update_tjshl(${shoppingCart.sku_id},(${shoppingCart.tjshl}+1),-1)">+</button><h3>${shoppingCart.tjshl}</h3><button onclick="update_tjshl(${shoppingCart.sku_id},(${shoppingCart.tjshl}-1),-1)">-</button></td>';
       		ele+=' <td><h3>${shoppingCart.hj}</h3></td>';
       		ele+='  <td><button style="color: red" onclick="delete_cart(${shoppingCart.sku_id})">删除</button></td>';
       		ele+='   </tr>';
        		})
        		var message = data.message;
        		var m = message.split("");
        		$("#mini_cart").html(ele);
        		$("#tongji").html("共<span >"+m[0]+"</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;共计￥<span>"+m[1]+"</span><button class=\"goprice\">去购物车</button>");
        	}
        	
        })
	  }
   }
   
   function delete_cart(sku_id){
	   alert("删除成功");
	   $(this).parent().parent().remove();
	   $.ajax({
		   url:"delete_cart.do",
		   data:{
			   sku_id : sku_id
		   },success: function (data){
			   alert(data.message);
		   }
	   })
   }
 </script>
</head>
<body>

            <table border="1" id="mini_cart"> 
		   <c:forEach items="${get_list}" var="shoppingCart">
		    
		        <div class="one">
					<img alt="" src="${shoppingCart.shp_tp}" >
					<span class="one_name">
						<h3>${shoppingCart.sku_mch}</h3>
					</span>
					<span class="one_name">
						<h3>${shoppingCart.tjshl}</h3>
					</span>
					<span class="one_prece">
						<b>${shoppingCart.hj}</b><br />
						&nbsp;&nbsp;&nbsp;&nbsp;<button style="color: red" onclick="delete_cart(${shoppingCart.sku_id})">删除</button>
					</span>
				</div>
		   </c:forEach>
		   		<div class="gobottom" id="tongji">
					共<span >${account}</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
					共计￥<span>${num}</span>
					<button class="goprice">去购物车</button>
				</div>
         </table>
         
         
</body>
</html>