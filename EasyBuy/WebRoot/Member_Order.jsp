<%@page import="com.ebuy.entity.EasybuyOrderDetail"%>
<%@page import="com.ebuy.entity.EasybuyOrder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
    		jQuery("#order").addClass("now");
    		init();
    	});
    	
    	
    	function init(){
    		jQuery("#info").load("MemberOrderServlet"); 	
    	}
    </script>
  <body>&nbsp;&nbsp; 
     <jsp:include page="memberTemp/Member_Top.jsp"></jsp:include>
	<div class="i_bg bg_color">
		<div class="m_content">
		<jsp:include page="memberTemp/Member_Left.jsp"></jsp:include>
			<c:choose>
				<c:when test="${sessionScope.user.type == 1 }">
					<!-- 管理员 -->
					<div class="m_right" id="info">
		    			            
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
</html>
