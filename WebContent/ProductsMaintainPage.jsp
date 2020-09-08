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
<title>商品資料維護</title>
</head>
<body>
<c:set var="funcName" value="BMT" scope="session" />
<div id='main'>
<center>${ BookDeleteMsg }<br>
<c:remove var="BookDeleteMsg" />
<div id="insert"><a href="<c:url value='ProductsInsert.jsp' />" >新增商品資料</a></div>
<table border='2' width="690">
	<TR>
		<TD colspan='3'>
		<TABLE width="680" BORDER='0'>
			<TR height='5'>
				<TD align='center'>&nbsp;</TD>
			</TR>
			<TR height='30'>
				<TD align='center'><FONT size='+2'
					style="font-weight: 900;"> 商品資料維護 </FONT></TD>
			</TR>
			<TR height='5'>
				<TD align='center'>&nbsp;</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
	<c:forEach varStatus="stVar" var="ProductBean" items="${products_DPP}">
		<tr height='50'>
			<td width='600' colspan='2' align='left'>
			<table border='1' width='600'>
				<tr>
					<td width='600' align="left">商品：<a
						href="BookPreUpdate.do?BOOKID=${ProductBean.productName}&pageNo=${pageNo}">${ProductBean.productName}</a>

					</td>
				</tr>
			</table>
			</td>
			<td rowspan='3' width='150'><!-- 
                 getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
              --> <img height='100' width='80'
				src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${aBookBean.bookId}&type=BOOK'>
			</td>
		</tr>
		
		<TR height='50'">
			<TD width='600' align='left'>
			<TABLE border='1' width='600'>
				<TR>
					<TD width='400' align="left">庫存：${ProductBean.productStock}</TD>
					<TD width='200' align="left">價錢：${ProductBean.productPrice}</TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</c:forEach>
</TABLE>
</CENTER>
</div>


</body>
</html>
