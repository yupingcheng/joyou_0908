<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<title>修改或刪除</title>
<style>
#bpaging{
margin:0px auto;
}
</style>
</head>
<body>
<c:set var="funcName" value="BMT" scope="session" />
<div>
<center>${ BookDeleteMsg }<br>
<c:remove var="BookDeleteMsg" />
<div><a href="<c:url value='ProductsInsert.jsp' />" >修改或刪除商品資料</a></div>

<c:forEach varStatus="stVar" var="ProductBean" items="${products_DPP}">
<table border='2' width="690" >
		<tr height='60'>
			<td rowspan="2" height='120' width='80'>
			<img src="${pageContext.servletContext.contextPath}/showImgServlet.do?id=${ProductBean.productId}&type=Product">
			</td>
			<td colspan="3"width='500' align="left">商品名稱：<a href="BookPreUpdate.do?BOOKID=${ProductBean.productName}&pageNo=${pageNo}">${ProductBean.productName}</a>
		</tr>
		<tr height='60'>
					<TD width='200' align="left">商品庫存：${ProductBean.productStock}</TD>
					<TD width='200' align="left">商品定價：${ProductBean.productPrice}</TD>
					<TD width='200' align="left">遊戲適齡：${ProductBean.productLang}</TD>
		</tr>
</table>
</c:forEach>
</center>
</div>
<center>
<div id="bpaging">
<br/><br/><br/><br/>
<table border="1">
	<tr align="center">
		<td width='80' height='20'>
			<div id="blfirst"><a
				href="<c:url value='ProductsGetServlet.do?pageNo=1'/>">第一頁</a></div>
		</td>
		<td width='80'>
			<div id="blprev">
			<a href="<c:url value='ProductsGetServlet.do?pageNo=${pageNo-1}'/>">上一頁</a>
			</div>
		</td>
		<td width='76'>${pageNo} / ${totalPages}</td>
		<td width='80'>
			<div id="blnext"><a
				href="<c:url value='ProductsGetServlet.do?pageNo=${pageNo+1}' />">下一頁</a></div>
		</td>
		<td width='80'>
			<div id="bllast"><a
				href="<c:url value='ProductsGetServlet.do?pageNo=${totalPages}' />">最後</a></div>
		</td>
	</tr>
</table>
</div>
</center>
</body>
</html>
