<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>添加部门</title>
		<script language="javascript" src="js/validate.js"></script>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 20px}
		</style>		
	</head>
	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0"">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; <a href="../ManagerDeptTable" class="STYLE1">部门管理</a>&gt;&gt;添加部门</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：<%=session.getAttribute("mname")%></span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" align="center" colspan="2">
						<form action="../ManagerDeptAdd" method="post" onSubmit="return emploe_validate()">
							<table width="60%" border="0" style="background-image: url(../images/formbj1.jpg)">
								<tr>
									<td class="STYLE2" colspan="2">
										添加部门：
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门编号：
									</td>
									<td width="65%" align="left">
										<input name="did" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门名称：
									</td>
									<td width="65%" align="left">
										<input name="dname" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门人数：
									</td>
									<td width="65%" align="left">
										<input name="dnumber" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门地址：
									</td>
									<td width="65%" align="left">
										<input name="daddr" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门经理：
									</td>
									<td width="65%" align="left">
										<select name="eid">
											<option value="" selected="selected">--选择人-- </option>
											<c:forEach var="emploe" items="${sessionScope.pnameList}">
												<option value="${emploe.eid }">${emploe.ename }</option>
											</c:forEach>
										</select>
									</td>
								</tr>																														
								<tr>
									<td width="35%" align="right"> </td>
									<td width="65%" align="left">
									<input type="reset" value="清空"/>
										<input type="submit" value="添加" />
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td height="76" colspan="2">
						<%@ include file="../tail.jsp"%>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
