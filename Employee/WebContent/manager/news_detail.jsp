<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>消息留言详情</title>
		<style type="text/css">		
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; }		
		</style>
	</head>
	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; <a href="../NewsTable" class="STYLE1">留言消息管理</a>&gt;&gt; 留言详情</span>	
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
								<td width="40%" align="right">
										消息编号：
								</td>
								<td width="60%" align="center">
									${sessionScope.msg.mid }
								</td>
							</tr>
							<tr height="10%">
								<td width="20%" align="right">
										消息主题：
								</td>
								<td width="25%" align="center">
									${sessionScope.msg.mtitle }
								</td>
							</tr>
							<tr height="10%">
								<td width="20%" align="right">
										留言消息时间：
								</td>
								<td width="25%" align="center">
									${sessionScope.msg.mtime }
								</td>
							</tr>
							<tr height="10%">
								<td align="right">
									内容：				
								</td>
								<td align="center">
									${sessionScope.msg.mcontent }
								</td>
							</tr>
							<tr height="10%" >
								<td></td>
								<td align="center">
									<input type="button" value="删除消息" onclick="window.location.replace('../ManagerDeleteNews?mid=${sessionScope.msg.mid}')" style="color:red;font-size: 20px"/>
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
