<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<div align="center">
		<table border="0" width="60%" cellspacing="0" cellpadding="0" id="table1">
			<tr>
				<td height="93"></td>
			</tr>
			<tr>
				<td>
				   <img src="${pageContext.request.contextPath }/images/bg.jpg" style="background-repeat: no-repeat" width="1500px" height="600px">
			    </td>
			</tr>
		</table>
	</div>
</body>
</html>