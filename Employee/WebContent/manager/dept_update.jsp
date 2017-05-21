<%@ page language="java" import="java.util.*,com.entity.*,com.daoImpl.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>更新部门信息</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 20px}
    	</style>
		<script language="javascript" src="../js/validate.js"></script>
	</head>

	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; <a href="../ManagerDeptTable" class="STYLE1">部门管理</a>&gt;&gt;更新部门信息</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：<%=session.getAttribute("mname")%></span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" colspan="2" align="center">
						<form action="../ManagerDeptUpdate_table" onSubmit="return emploe_validate()">
							<table width="60%" border="0" style="background-image: url(../images/formbj3.jpg)">
								<tr>
									<td class="STYLE2" colspan="2">
										部门基本信息：
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门编号：
									</td>
									<td width="65%" align="left">
										<input name="name" type="text" readonly="readonly" value="${sessionScope.dept.did }" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门名称：
									</td>
									<td width="65%" align="left">
										<input name="name" type="text" value="${sessionScope.dept.dname }" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门人数：
									</td>
									<td width="65%" align="left">
										<input name="" type="text" value="${sessionScope.dept.dnumber }" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门地址：
									</td>
									<td width="65%" align="left">
										<input name="" type="text" value="${sessionScope.dept.daddr }" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门经理：
									</td>
									<td width="65%" align="left">
										<select name="eid">
											<option value="">--选择人-- </option>
											<%
												ArrayList<Dept> deptList = (ArrayList<Dept>)session.getAttribute("deptList");
												EmploeDaoImpl edi = new EmploeDaoImpl();
												for(Dept dept : deptList){
											%>
											<option value="<%=dept.getEid() %>"><%
											Emploe emploe = edi.getEmploeById(dept.getEid());
											out.print(emploe.getEname());
											 %></option>
											<% 	
												}
											 %>
										</select>
									</td>
								</tr>				
								<tr>
									<td width="35%" align="right">
										<input type="reset" value="重置"/>
									</td>
									<td width="65%" align="left">
										<input type="submit" value="更新" />
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
