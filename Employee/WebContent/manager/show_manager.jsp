<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>管理员详细信息</title>
		<style type="text/css">		
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; color:blue; font-size: 25px }		
			.STYLE3 { font-family: "宋体"; font-size: 16px;color: green}
		</style>
	</head>
	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; 管理员详细信息</span>
					</td>	
					<td height="28" bgcolor=#6C7B8B align="right"  width="30%">
						<span class="STYLE1">当前用户：<%=session.getAttribute("mname")%></span>
						<input type="button" value="退出登录" style="color:red" onclick="window.location.replace('../index.jsp')"/>
					</td>
				</tr>
				<tr>
					<td height="254" align="center" colspan="2"><br><br>
						<table width="70%"  border="1" style="background-image: url(../images/formbj2.jpg)">
							<tr>
								<td width="20%" align="right">
										管理员编号：
								</td>
								<td width="25%" align="left">
									${sessionScope.manager.mid }
								</td>
							</tr>
							<tr>
								<td width="20%" align="right">
										管理员登陆名：
								</td>
								<td width="25%" align="left">
									${sessionScope.manager.mname }
								</td>
							</tr>
							<tr height="10%">
								<td width="20%" align="right">
										权限级别：
								</td>
								<td width="25%" align="left">
									${sessionScope.manager.mpower }
								</td>
							</tr>
							<tr height="10%" >
								
								<td align="center" colspan="2">
									<input type="button" value="更改登陆密码" onclick="window.location.replace('mpassword_update.jsp')" />
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
