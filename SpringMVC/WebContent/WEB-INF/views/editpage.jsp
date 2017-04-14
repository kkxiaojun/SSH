<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head></head>
<body>

	<h3>员工编辑</h3>

	<br />
	<br />
	<!-- action对应一个action标签，id对应提交时的对应关系 -->
	<form id="saveForm" action="${pageContext.request.contextPath}/person/updateperson" method="post">
		<input type="hidden" name="id" value="${person.id }" />
		<table style="font-size: :16px">
			<tr>
				<td>姓名：</td>
				<td><input type="text" value="${person.name }" name="name" /></td>
			</tr>
			<tr>
				<td>身份证号码：</td>
				<td><input type="text" value="${person.idCard }" name="idCard" /></td>
			</tr>
			<tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" value="${person.phone }" name="phone" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" value="${person.address }" name="address" /></td>
			</tr>
			<tr>
			
				<td align="right">
				<input type="submit" value="更新" /> &nbsp;&nbsp;<a href="javascript:history.go(-1)">退回 </a>
			</tr>
		</table>
	</form>
			<!-- <tr>
			
				<td align="right"><a
					href="javascript:document.getElementById('saveForm').submit()">保存</a>
					&nbsp;&nbsp; <a href="javascript:history.go(-1)">退回 </a></td>
			</tr>
			 -->
</body>
</html>
