
<%@page import="com.ebuy.entity.EasybuyProduct"%>
<%@page import="com.ebuy.entity.EasybuyProductCategory"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->    
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
    
	<script type="text/javascript" src="js/lrscroll.js"></script>
    
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    
	<script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript">
    	//初始化购物车
    	function init(id){
    		jQuery("#i_car").load("CarsServlet","id="+id);
    	}
    
    </script>
    
<title>尤洪</title>
</head>
<body>&nbsp;   
<!--Begin Header Begin-->
<jsp:include page="indexElement/indexTop.jsp" ></jsp:include>
<!--End Header End  -->
	<% 
	//获取商品集合列表
	List<EasybuyProduct> productList=new ArrayList<EasybuyProduct>();
	 productList=(ArrayList<EasybuyProduct>) request.getAttribute("productShow");
	 //获取当前页码和总页数
	 int pageNo=(Integer)request.getAttribute("currentNo");
	 int pageTotal=(Integer)request.getAttribute("totalPageCount"); 
	//判断查询商品列表是否为空 若为不为空则输出商品信息
	if(productList!=null&&productList.size()>0){
	%>
	<div>
	<table style="font-size: 16px ">
		<tr style="font-weight: bold;">
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品图片名</td>
			<td>商品操作</td>
		</tr>
		<c:forEach items="${requestScope.productShow }" var="prd">
			<%-- <div>
				<ul>
					<div><img src="<%=basePath%>/images/${prd.fileName }" alt="${prd.fileName }" /></div>
					<li>${prd.name }</li>
					<li>${prd.price }</li>
				</ul>
			</div> --%>
			<tr>
				<td>${prd.name }</td>
				<td>${prd.price }</td>
				<td>${prd.fileName }</td>
				<td><a href="javascript:var id=${prd.id};init(id)">加入购物车</a></td>
			</tr>

		</c:forEach>
	</table >
	<table style="font-size: 16px; font-weight: bold;">
		<tr>
			<td>总页数:${requestScope.totalPageCount}页</td>
			<td><a href="productShow?currentNo=1&id=${requestScope.id}">首页</a></td>
			<td><a href="productShow?currentNo=<%=pageNo-1 %>&id=${requestScope.id}">上一页</a></td>
			<td><a href="productShow?currentNo=<%=pageNo+1 %>&id=${requestScope.id}">下一页</a></td>
			<td><a href="productShow?currentNo=<%=pageTotal%>&id=${requestScope.id}">末页</a></td>
			<td>总条数:${requestScope.count}条</td>
		</tr>
	</table>
	</div>
	<%	
	}else{
	%>
	<script type="txt/html">
	alert("对不起没有找到相关的商品信息！");
	</script>
	<%	
	}
	%>
	
	


	<div class="i_t mar_10">
    	<span class="fl">猜你喜欢</span>
    </div>    
    <div class="like">        	
        <div id="featureContainer1">
            <div id="feature1">
                <div id="block1">
                    <div id="botton-scroll1">
                        <ul class="featureUL">
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot1.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>德国进口</h2>
                                        德亚全脂纯牛奶200ml*48盒
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>189</span></font> &nbsp; 26R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot2.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>iphone 6S</h2>
                                        Apple/苹果 iPhone 6s Plus公开版
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>5288</span></font> &nbsp; 25R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot3.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>倩碧特惠组合套装</h2>
                                        倩碧补水组合套装8折促销
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>368</span></font> &nbsp; 18R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot4.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>280</span></font> &nbsp; 30R
                                    </div>
                                </div>
                            </li>
                            <li class="featureBox">
                                <div class="box">
                                    <div class="imgbg">
                                        <a href="#"><img src="images/hot4.jpg" width="160" height="136" /></a>
                                    </div>                                        
                                    <div class="name">
                                        <a href="#">
                                        <h2>品利特级橄榄油</h2>
                                        750ml*4瓶装组合 西班牙原装进口
                                        </a>
                                    </div>
                                    <div class="price">
                                        <font>￥<span>280</span></font> &nbsp; 30R
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <a class="l_prev" href="javascript:void();">Previous</a>
                <a class="l_next" href="javascript:void();">Next</a>
            </div>
        </div>
    </div>
    <!--End 猜你喜欢 End-->
      <jsp:include page="indexElement/indexFooter.jsp" ></jsp:include>
    <!--End footer End-->

</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
