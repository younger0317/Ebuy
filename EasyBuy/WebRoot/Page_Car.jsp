<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="car_t">购物车 [ <span>
								<c:if test="${sessionScope.totalNum==null }">0</c:if>
								${sessionScope.totalNum }
							</span> ]</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.user==null}">
                <div class="un_login">还未登录！<a href="Login.html" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            </c:if> 
            <ul class="cars" id="cars">
				<c:if test="${!empty sessionScope.cars}">
					<c:forEach items="${sessionScope.cars}" var="map">
					        
					          	 <li>
				                	<div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
				                    <div class="name">${map.value.name}<a href="#">${map.value.description}</a></div>
				                    <div class="price"><font color="#ff4e00">￥${map.value.price}</font> X${map.value.num}</div>
				                </li>
					          
					        
					
					</c:forEach>
				</c:if>
				<c:if test="${empty sessionScope.cars}">您尚未购买任何物品</c:if>
				
				<c:if test="${sessionScope.user != null }">
					<div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>${sessionScope.totalCost }</span></div>
				    <div class="price_a"><a href="BuyCar.jsp">去购物车结算</a></div>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span><c:if test="${sessionScope.totalCost==null }">0</c:if>${sessionScope.totalCost }</span></div>
				</c:if>
           </ul>
         </div>
