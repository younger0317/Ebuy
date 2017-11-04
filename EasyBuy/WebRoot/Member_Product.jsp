<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
    <script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
    <script type="text/javascript" src="js/menu.js"></script>    
	<script type="text/javascript" src="js/select.js"></script>
    <script type="text/javascript">
    	jQuery(function(){
    		jQuery(".m_left li a").removeClass("now");
    		jQuery("#Product").addClass("now");
    		init();
    	});
    	//Ajax加载
    	function init(){
    		var currentNo = 1;
    		jQuery("#pro").load("product_servlet","type=Product&currentNo="+currentNo);  
    	}
    	//跳转功能
    	function redirect(currentNo){
    		jQuery("#pro").load("product_servlet","type=Product&currentNo="+currentNo); 
    	}
    </script>  
    
<title>尤洪</title>
</head>
<body>  
	<jsp:include page="memberTemp/Member_Top.jsp"></jsp:include>
	<div class="i_bg bg_color">
		<div class="m_content">
		<jsp:include page="memberTemp/Member_Left.jsp"></jsp:include>
			<c:choose>
				<c:when test="${sessionScope.user.type == 1 }">
					<!-- 管理员 -->
					<div class="m_right" id="pro">
		        	<!-- AJAX 局部刷新部分 -->	
		        	
		   		 	</div>
				
				</c:when>
				<c:otherwise>
					<!-- 不是管理员  -->
					<h3>你没有权限访问该页面</h3>
				</c:otherwise>
			</c:choose>
			
	    </div>
		<jsp:include page="memberTemp/Member_Footer.jsp"></jsp:include>
    </div>
</body>


