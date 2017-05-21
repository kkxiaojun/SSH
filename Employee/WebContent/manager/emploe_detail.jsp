<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>员工详细信息</title>
		<style type="text/css">		
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; }		
		</style>
		<script language="javascript" src="../js/ajax.js"></script>
	</head>
	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; 员工详细信息</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：<%=session.getAttribute("mname")%></span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" align="center" colspan="2">
						<table width="70%" height="100%" border="0" style="background-image: url(../images/formbj2.jpg)">
							<tr height="10%">
								<td width="20%" align="right">
										员工编号：
								</td>
								<td width="25%" align="center">
									<c:out value="${sessionScope.emploe.eid}"></c:out>
								</td>
								<td width="55%" rowspan="8" align="center" >
									<img src="${sessionScope.emploe.ephoto}"/>
								</td>
							</tr>
							<tr height="10%">
								<td width="20%" align="right">
										姓名：
								</td>
								<td width="25%" align="center">
									<c:out value="${sessionScope.emploe.ename}"></c:out>
								</td>
							</tr>
							<tr height="10%">
								<td width="20%" align="right">
										薪资待遇：
								</td>
								<td width="25%" align="center">
									<c:out value="${sessionScope.emploe.esalary}"></c:out>
								</td>
							</tr>
							<tr height="10%">
								<td align="right">
									性别：				
								</td>
								<td align="center">
									<c:out value="${sessionScope.emploe.esex}"></c:out>
								</td>
							</tr>
							<tr height="10%">
								<td align="right">
									生日：
								</td>
								<td align="center">
									<c:out value="${sessionScope.emploe.ebir}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td align="right">	
									婚否：												
								</td>
								<td align="center">
									<c:out value="${sessionScope.emploe.emarry}"></c:out>
								</td>
							</tr>
							<tr height="10%">
								<td  align="right">										
										学历：											
								</td>
								<td align="center">
									<c:out value="${sessionScope.emploe.eedu}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td align="right">												
										部门名称：
								</td>
								<td align="center">
									<c:out value="${sessionScope.dname}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td align="right">
										职位名称：											
								</td>
								<td align="center">
									<c:out value="${sessionScope.pname}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td align="right">
									电话号码：
								</td>
								<td align="center">
									<c:out value="${sessionScope.emploe.ephone}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td align="right">
									家庭地址：								
								</td>
								<td align="center" colspan="2">
									<c:out value="${sessionScope.emploe.eaddr}"></c:out>
								</td>
							</tr>
							<tr height="10%" >
								<td></td><td></td>
								<td align="center">
									<input type="button" value="更新资料" onclick="window.location.replace('../ManagerShowSelf?eid=${sessionScope.emploe.eid}')" style="color:red;font-size: 20px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="初始密码" onclick="window.location.replace('../InitPassword')" style="color:red;font-size: 20px"/><span id="i_s"></span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="76" colspan="2">
						<br><br><br>
						<%@ include file="../tail.jsp"%>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
