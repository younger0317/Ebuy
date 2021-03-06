<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<%
		String id=request.getParameter("id");
		
		if(id == null){
	 %>
    <script type="text/javascript">
    	jQuery(function(){
    		jQuery(".m_left li a").removeClass("now");
    		jQuery("#newsList").addClass("now");
    		init();
    	});
    	//初始化加载
    	function init(){
    		jQuery("#info").load("MemberNews","type=newsList&currentNo=1");
    	}
    	//分页跳转
    	function redirect(currentNo){
    		jQuery("#info").load("MemberNews","type=newsList&currentNo="+currentNo);
    	}
    	//详情展示
    	function toShowInfo(id){
    		jQuery("#info").load("MemberNews","type=showInfo&id="+id);
    	}
    	
    </script>  
  	<%
  		}else{
  	 %>
  	   <script type="text/javascript">
    	jQuery(function(){
    		jQuery(".m_left li a").removeClass("now");
    		jQuery("#newsList").addClass("now");
    		toShowInfo(<%=id %>);
    	});
    	//初始化加载
    	function init(){
    		jQuery("#info").load("MemberNews","type=newsList&currentNo=1");
    	}
    	//分页跳转
    	function redirect(currentNo){
    		jQuery("#info").load("MemberNews","type=newsList&currentNo="+currentNo);
    	}
    	//详情展示
    	function toShowInfo(id){
    		jQuery("#info").load("MemberNews","type=showInfo&id="+id);
    	}
    	
    </script> 
    
    <%
    }
     %>
  <body>
    <jsp:include page="memberTemp/Member_Top.jsp"></jsp:include>
	<div class="i_bg bg_color">
		<div class="m_content">
		<jsp:include page="memberTemp/Member_Left.jsp"></jsp:include>
			<div class="m_right" id="info">
		        	
		            
		    </div>
	    </div>
		<jsp:include page="memberTemp/Member_Footer.jsp"></jsp:include>
    </div>
  </body>
</html>
