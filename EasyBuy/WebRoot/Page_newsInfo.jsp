<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h2>${requestScope.news.title }</h2>
<p></p>
<p>${requestScope.news.title }</p>
<a href="Member_NewsList.jsp">返回资讯列表</a>
<a href="index.jsp">返回首页</a>

