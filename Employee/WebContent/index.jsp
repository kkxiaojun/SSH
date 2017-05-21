<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<html>
	<head>
		<title>入口</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
		</style>
	</head>
	<body bgcolor="#5CC9F5">
		<center>
			<form name="loginForm" onSubmit="return login_validate()"
				action="operator" method="post">
				<table width="900" border="0" style="border: solid gray 1pt solid;"
					cellpadding="0" cellspacing="0">
					<tr>
						<td height="76">
							<%@ include file="head.jsp"%>
						</td>
					</tr>
					<tr valign="top">
						<td height="254">
							<table width="100%" height="247" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="25"  bgcolor="#6C7B8B" colspan="5">
										<span class="STYLE1">欢迎登陆&gt;&gt;&gt;&gt;&gt;请选择登陆的方式：</span>
									</td>
								</tr>
								<tr>
									<td height="" bgcolor="#6C7B8B" >
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
									<td height="" bgcolor="#6C7B8B" align="center">
										<a href="manager_login.jsp"><img src="images/icon1.png"/></a>
										<br/>
										管理员登陆
									</td>
									<td bgcolor="#6C7B8B" width="">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
									<td bgcolor="#6C7B8B" align="center">
										<a href="login.jsp"><img src="images/icon2.png"/></a>
										<br/>
										员工登陆
									</td>
									<td height="" bgcolor="#6C7B8B" width="">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
				<input type="hidden" name="index" value="0" />
				<input type="hidden" name="pagenow" value="0" />
			</form>
		</center>
	</body>
</html>
