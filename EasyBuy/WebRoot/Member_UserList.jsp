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
	<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
	<script type="text/javascript" src="js/MemberJS.js" ></script>
    <script type="text/javascript">
    	jQuery(function(){
    		jQuery(".m_left li a").removeClass("now");
    		jQuery("#userList").addClass("now");
    		//页面初次加载
    		init();
    	});
 		//Ajax加载
    	function init(){
    		var currentNo = 1;
    		jQuery("#info").load("MemberServlet","type=userList&currentNo="+currentNo);  
    	}
    	//跳转功能
    	function redirect(currentNo){
    		jQuery("#info").load("MemberServlet","type=userList&currentNo="+currentNo); 
    	}
    	
    	//修改跳转
    	function toModify(id){
    		jQuery("#info").load("MemberServlet","type=modify&id="+id);
    	}
    	
    	//提交修改
    	function doModify(){
    		var id = jQuery("#id").val();
    		var loginName = jQuery("#loginName").val();
    		var userName = jQuery("#userName").val();
    		var identityCode = jQuery("#identityCode").val();
    		var email = jQuery("#email").val();
    		var mobile = jQuery("#mobile").val();
    		var userType = jQuery("#type").val();
    		//alert(id+" "+loginName+" "+userName+" "+identityCode+" "+email+" "+mobile+" "+type);
    		
    		jQuery("#info").load("MemberServlet","type=doModify&id="+id+"&loginName="+loginName+"&userName="+userName+"&identityCode="+identityCode+"&email="+email+"&mobile="+mobile+"&userType="+userType);
    	}
    	
    	//删除提交
    	function toDel(id){
    		jQuery.get("MemberServlet","type=del&id="+id,delBack);
    		//回调函数
    		function delBack(data){
    			if(data=="true"){
    				alert("删除成功");
    			}else{
    				alert("删除失败");
    			}
    			init();
    		}
    	}
    	
    	//添加跳转
    	function toAddPage(){
    		jQuery("#info").load("MemberServlet","type=add");
    	}
    	
    	//添加提交
    	function doAdd(){
    		var id = jQuery("#id").val();
    		var loginName = jQuery("#loginName").val();
    		var userName = jQuery("#userName").val();
    		var identityCode = jQuery("#identityCode").val();
    		var email = jQuery("#email").val();
    		var mobile = jQuery("#mobile").val();
    		var userType = jQuery("#type").val();
    		var sex=jQuery(":radio[checked='checked']").val();
    		var password=jQuery("#password").val();
    	
    		
    		jQuery.post("MemberServlet","type=doAdd&id="+id+"&loginName="+loginName+"&userName="+userName+"&identityCode="+identityCode+"&email="+email+"&mobile="+mobile+"&userType="+userType+"&sex="+sex+"&password="+password,addBack);
    		function addBack(data){
    			if(data == "true"){
    				alert("添加成功");
    				init();
    			}else{
    				alert("添加失败");
    			}
    		} 
    		//jQuery("#info").load("MemberServlet","type=doAdd&id="+id+"&loginName="+loginName+"&userName="+userName+"&identityCode="+identityCode+"&email="+email+"&mobile="+mobile+"&userType="+userType);
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




