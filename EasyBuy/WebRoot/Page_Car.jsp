<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${!empty sessionScope.keyId}">
	<c:forEach items="${sessionScope.keyId}" var="map">
	        
	          	 <li>
                	<div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name">${map.value.name}<a href="#">${map.value.description}</a></div>
                    <div class="price"><font color="#ff4e00">￥${map.value.price}</font> X${map.value.num}</div>
                </li>
	          
	        
	
	</c:forEach>


</c:if>

              <!--   <li>
                	<div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li>
                <li>
                	<div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                    <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                    <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                </li> -->