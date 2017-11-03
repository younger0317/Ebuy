<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div>
<form action="CategoryServlet" method="get" onsubmit="tijiao()">
	<p>分类名字<input type="text" name="name" id="name1"></p>	
	<input type="hidden" name="type" value="add">
	<p>选择级别<select id="type" name="t">
		<option value="1">一级分类</option>
		<option value="2">二级分类</option>
		<option value="3">三级分类</option>
	</select></p>	
	<div id="feng"></div>
	<input type="submit" value="提交" id="tij">
</form>
</div>
<script type="text/javascript">
	jQuery(function() {
		
		jQuery("#type").change(
				function() {
					var value1 = jQuery("#type").val();
						if(value1!=1){
							jQuery.get("CategoryServlet", "type=parentId&id="
								+ value1, callBack);
						
						}
						});
						function callBack(data){
							jQuery("#feng").html(data);
						
						}
						function tijiao(){
							var name = jQuery("#name1").val();	
							var find = true;
							if(name==""){
								find=false;
							}
							return find;
						}
						
					/* if (loginName != jQuery("#").val()) {
						//更改的登陆名与原来的登陆名不一样
						//发送ajax异步请求
						jQuery.get("MemberServlet", "type=checkName&loginName="
								+ loginName, callBack);
						//回调函数
						}*/
	}); 
</script>
