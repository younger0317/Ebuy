<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div><a href="javascript:addcaregory();">增加分类</a></div>
<table id="categoryList" border="1" cellspacing="0" align="center">\
	<tr align="center" height="30">
		<td width="20px">选择</td>
		<td width="200px">分类名称</td>
		<td width="200px">分类级别</td>
		<td width="200px">父级分类</td>
		<td colspan="2" width="200px">操作</td>
		
	</tr>
	<c:forEach items="${requestScope.userList}" var="category" varStatus="status">
		<tr>
			<td>选择</td>
			<td>${category.name}</td>
			<c:choose>
				<c:when test="${category.type ==1}">
					<td width="150px">一级分类</td>
				</c:when>
				<c:when test="${category.type ==2}">
					<td width="150px">二级分类</td>
				</c:when>
				<c:when test="${category.type ==3}">
					<td width="150px">三级分类</td>
				</c:when>
			</c:choose>
						<c:choose>
							<c:when test="${category.parentId ==0}">
								<td width="150px">无</td>
							</c:when>
							
							<c:when test="${category.parentId!=0}">
								<td width="150px"><c:forEach items="${requestScope.CategoryList}" var="category1">
									<c:if test="${category1.id eq category.parentId}">
										${category1.name}
									</c:if>			
								</c:forEach></td>	
							</c:when>
								
										
						</c:choose>		
					
								
					
						
			<td><a href="javascript:categoryid=${category.id};shanccat(categoryid)" id="shanc">删除</a></td>	
		</tr>
	</c:forEach>
</table>
<div align="center" style="font-size: 18px;margin-top: 10px;">
	<a href="javascript:currentNo=1;redirect(currentNo)">首页</a> 
	<c:if test="${requestScope.currentNo >1}">
		<a href="javascript:currentNo=${requestScope.currentNo-1};redirect(currentNo)">上一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.currentNo};redirect(currentNo)">${requestScope.currentNo}</a> 
	<c:if test="${requestScope.currentNo != requestScope.totalPageCount}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">${requestScope.currentNo+1}</a>
	</c:if>
	<c:if test="${requestScope.currentNo<requestScope.totalPageCount}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">下一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.totalPageCount};redirect(currentNo)">尾页</a>
</div>