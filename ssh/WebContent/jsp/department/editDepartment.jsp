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
	<table border="0" width="600px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">编辑部门</td>
		</tr>
		<tr>
			<td align="right">
			    <a href="javascript:document.getElementById('saveForm').submit()">保存</a>
				&nbsp;&nbsp; 
				<a href="javascript:history.go(-1)">退回 </a>
		    </td>
		</tr>
	</table>
	<br/>
	<br/>
	<!-- action对应一个action标签，id对应提交时的对应关系 -->
	<s:form id="saveForm" action="department_update" method="post" namespace="/" theme="simple">
		<!-- 隐藏域，指明修改的是哪个部门 -->
		<s:hidden name="did" value="%{model.did}"></s:hidden>
		<table style="font-size:16px" width="600px">
			<tr>
				<td width="30%" align="right">部门名称：</td>
				<td><s:textfield name="dname" value="%{model.dname}" /></td>
			</tr>
			<tr>
				<td width="30%" align="right">部门介绍：</td>
				<td></td>
			</tr>
			<tr>
				<td width="30%" align="right"></td>
				<td><s:textarea rows="5" cols="50" name="ddesc" value="%{model.ddesc}"></s:textarea></td>
			</tr>
		</table>
	</s:form>
</body>
</html> 