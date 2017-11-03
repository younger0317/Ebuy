<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品上架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="mem_tit">商品上架</div>
  <div align="center">
  <form action="addProduct_servlet" method="post" >
		<table font-size:18px>
			<tr>
				<td>一级分类:</td>
				<td>
				<select name="first">
						<option value="1" select="slected">化妆品</option>
						<option value="2">家用商品</option>
						<option value="3">进口食品,生鲜</option>
						<option value="4">电子商品</option>
						<option value="5">保健食品</option>
						<option value="6">箱包</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>一级分类:</td>
				<td>
				<select name="second">
						<option value="1" select="slected">面部护理</option>
						<option value="2">餐具</option>
						<option value="3">卫具</option>
						<option value="4">零食/糖果/巧克力</option>
						<option value="5">手机</option>
						<option value="6">手环</option>
						<option value="7">老年保健品</option>
						<option value="8">中年营养品</option>
						<option value="9">儿童保健品</option>
						<option value="10">旅行箱</option>
						<option value="11">手提箱</option>
						<option value="12">电脑</option>
						<option value="13">客厅专用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>一级分类:</td>
				<td>
				<select name="third">
						<option value="1" select="slected">少女派</option>
						<option value="2">叉子</option>
						<option value="3">锅</option>
						<option value="4">坚果</option>
						<option value="5">蜜饯</option>
						<option value="6">华为手机</option>
						<option value="7">孕期教育</option>
						<option value="8">联想手机</option>
						<option value="9">小米手环</option>
						<option value="10">脑白金</option>
						<option value="11">大型</option>
						<option value="12">小型</option>
						<option value="13">中型</option>
						<option value="14">大型</option>
						<option value="15">中型</option>
						<option value="16">小型</option>
						<option value="17">联想电脑</option>
						<option value="18">刀叉</option>
						<option value="19">碗筷</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="product">(必填)</td>
			</tr>
			<tr>
				<td>商品单价：</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>商品库存：</td>
				<td><input type="number" name="number"></td>
			</tr>
			<tr>
				<td>商品图片：</td>
				<td><input type="file" name="img"></td>
			</tr>
			<tr>
				<td>商品描述：</td>
				<td><input type="text" name="dic"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" ></td>
			</tr>


		</table>


	</form>
    </div>
  </body>
</html>
