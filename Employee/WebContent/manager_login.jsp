<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<TITLE>管理员登陆</TITLE>
		<meta content="text/html; charset=gb2312" http-equiv=Content-Type>
		<script language="javascript" src="js/validate.js"></script>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
		</style>
	</head>
	<body bgcolor="#6CA6CD" onload="code_ajax()">
		<form action="ManagerLogin" method="get">
			<table border=0 cellSpacing=0 cellPadding=0 width="900" align="center">
				<tr><td height="76"> <%@ include file="head.jsp"%> </td> </tr>
				<tr>
					<td height="25" bgcolor="#6C7B8B">
						<a href="index.jsp"><span class="STYLE1">欢迎使用</span></a><span class="STYLE1">&gt;&gt;&gt;&gt;&gt;管理员登陆</span>
					</td>
				</tr>
				<tr>
					<td><br>
						<table border=0 cellSpacing=0 cellPadding=0 width=562 align=center>
							<tr>
								<td height=402 vAlign=top background=images/bg.jpg align=center>
									<table border=0 cellSpacing=0 cellPadding=0 width=500>
										<tr>
											<td height=170 vAlign=bottom align=center></td>
										</tr>
									</table>
									<table border=0 cellSpacing=0 cellPadding=0 width=260 align=center>
										<tr>
											<td height=30 width=64 align=right>
												用户名：
											</td>
											<td height=30 width=176>
												<input type="text" size=23 name="mname">
											</td>
										</tr>
										<tr>
											<td height=30 align=right>
												密&nbsp;&nbsp;码：
											</td>
											<td height=30>
												<input size=23 type="password" name="mpassword">
											</td>
										</tr>
										<tr>
											<td height=30 align=right>
												验证码：
											</td>
											<td height=30>
												<input type="text" size=6 name="code" >
												<img src="Code"><span id="i_c"></span>
											</td>
										</tr>
		
										<tr>
											<td height=30>
												&nbsp;
											</td>
											<td height=30>
												<input type="submit" value="登陆"/>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="76">
						<%@ include file="tail.jsp"%>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
