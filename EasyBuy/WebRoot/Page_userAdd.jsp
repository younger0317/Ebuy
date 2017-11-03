<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<p></p>
<div class="mem_tit">修改用户</div>
<table border="1" cellspacing="0" >
	<tr>
		<td align="right" width="200px">
			用户姓名		
		</td>
		<td width="300px">
			<input width="250px" type="text" name="loginName" id="loginName" value="">
			<h5 id="wrongText">${wrongText}</h5>
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
			真实姓名	
		</td>
		<td width="300px">
			<input type="text" name="userName" id="userName" value="">
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
			身份证号	
		</td>
		<td width="300px">
			<input type="text" name="identityCode" id="identityCode" value="">
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
			电子邮箱	
		</td>
		<td width="300px">
			<input type="text" name="email" id="email" value="">
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
			手机	
		</td>
		<td width="300px">
			<input type="text" name="mobile" id="mobile" value="">
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
			用户类型	
		</td>
		<td width="300px">
			<select id="type">
				<!--笨方法-->
				<c:choose>
					<c:when test="">
						<option value="0">用户</option>
						<option value="1" selected="selected">管理员</option>
					</c:when>
					<c:otherwise>
						<option value="0">用户</option>
						<option value="1">管理员</option>
					</c:otherwise>
				</c:choose>
			</select>
		</td>
	</tr>
	<tr>
		<td align="right" width="200px">
		</td>
		<td width="300px">
			<button id="doAdd" onclick="doAdd()">提交</button>
		</td>
	</tr>
</table>
<script type="text/javascript">
	jQuery(function() {
		jQuery("#loginName").change(
				function() {
					var loginName = jQuery("#loginName").val();
					//发送ajax异步请求
					jQuery.get("MemberServlet", "type=checkName&loginName="
							+ loginName, callBack);
					//回调函数
					function callBack(data) {
						if (data == "true") {
							//提示
							jQuery("#wrongText").html("用户名已存在");
							//禁用按钮
							jQuery("#doAdd").attr("disabled", "disabled");
						} else {
							//提示
							jQuery("#wrongText").html("");
							//取消按钮禁用
							jQuery("#doAdd").removeAttr("disabled");
						}
					}
				});
	});
</script>
