<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<c:choose>
        		<c:when test="${sessionScope.user==null}">
        			<!--没有登陆 -->
        			<span class="fl">你好，请<a href="Login.html">登录</a>&nbsp; <a href="Regist.html" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="Login.html">我的订单</a>&nbsp;|</span>
        			<span class="ss">
            			<div class="ss_list">
	                		<a href="Login.html">收藏夹</a>
	                   		<div class="ss_list_bg">
	                    		<div class="s_city_t"></div>
	                        	<div class="ss_list_c">
	                        		<ul>
	                            		<li><a href="Login.html">我的收藏夹</a></li>
	                                	<li><a href="Login.html">我的收藏夹</a></li>
	                            	</ul>
	                        	</div>
	                    	</div>     
                		</div>
               		 <div class="ss_list">
	                	<a href="Login.html">客户服务</a>
	                    <div class="ss_list_bg">
	                    	<div class="s_city_t"></div>
	                        <div class="ss_list_c">
	                        	<ul>
	                            	<li><a href="Login.html">客户服务</a></li>
	                                <li><a href="Login.html">客户服务</a></li>
	                                <li><a href="Login.html">客户服务</a></li>
	                            </ul>
	                        </div>
	                    </div>    
                	</div>
        		</c:when>
        		<c:otherwise>
        		<!-- 登陆 -->
        			<span class="fl">你好，${sessionScope.user.loginName}&nbsp;<a href="User?type=exit">退出</a>|&nbsp;<a href="javascript:alert('该功能未能使用');">我的订单</a>&nbsp;|</span>
        			<span class="ss">
            			<div class="ss_list">
	                		<a href="javascript:alert('该功能未能使用');">收藏夹</a>
	                   		<div class="ss_list_bg">
	                    		<div class="s_city_t"></div>
	                        	<div class="ss_list_c">
	                        		<ul>
	                            		<li><a href="javascript:alert('该功能未能使用');">我的收藏夹</a></li>
	                                	<li><a href="javascript:alert('该功能未能使用');">我的收藏夹</a></li>
	                            	</ul>
	                        	</div>
	                    	</div>     
                		</div>
               		 <div class="ss_list">
	                	<a href="javascript:alert('该功能未能使用');">客户服务</a>
	                    <div class="ss_list_bg">
	                    	<div class="s_city_t"></div>
	                        <div class="ss_list_c">
	                        	<ul>
	                            	<li><a href="javascript:alert('该功能未能使用');">客户服务</a></li>
	                                <li><a href="javascript:alert('该功能未能使用');">客户服务</a></li>
	                                <li><a href="javascript:alert('该功能未能使用');">客户服务</a></li>
	                            </ul>
	                        </div>
	                    </div>    
                	</div>
        		</c:otherwise>
        	</c:choose>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="${ctx}/Home?action=index"><img src="${ctx}/statics/images/logo.png"></a></div>
    <div class="search">
        <form>
            <input txype="text" value="" class="s_ipt">
            <input type="submit" value="搜索" class="s_btn">
        </form>
        <span class="fl">
            <a href="javascript:void(0)">咖啡</a>
            <a href="javascript:void(0)">iphone 6S</a>
            <a href="javascript:void(0)">新鲜美食</a>
            <a href="javascript:void(0)">蛋糕</a>
            <a href="javascript:void(0)">日用品</a>
            <a href="javascript:void(0)">连衣裙</a>
        </span>
    </div>
    <div class="i_car">
        <div class="car_t">购物车 [ <span>3</span> ]</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.user==null}">
                <div class="un_login">还未登录！<a href="${ctx}/Login?action=toLogin" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            </c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <c:if test="${sessionScope.cart2==null || sessionScope.cart2.items.size()<1}"> 您尚未购买任何物品，是否进入<a href="${ctx}/Home?action=index">商品页</a>进行购买！</c:if>
                <c:if test="${sessionScope.cart2.items.size()>=1}">
                    <li>
                        <div class="img">
                            <a href="javascript:void(0)">
                                <img src="${ctx}/statics/images/car1.jpg" width="58" height="58">
                            </a>
                        </div>
                        <div class="name">
                            <a href="javascript:void(0)">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a>
                        </div>
                        <div class="price">
                            <font color="#ff4e00">￥399</font>X1
                        </div>
                    </li>
                </c:if>
            </ul>
            <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
            <div class="price_a"><a href="javascript:void(0)">去购物车结算</a></div>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<!--End Header End--> 






