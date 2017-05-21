<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>员工注册</title>
		<style type="text/css">
			.c_a { font-size:25px; font-weight: bold; font-family: "楷体_GB2312"; }
			.c_b{ color:red; font-size: 20px; }
		</style>
		<script language="javascript" src="js/validate.js"></script>
		<script language="javascript" src="js/ajax.js"></script>
	</head>

	<body bgcolor="#5CC9F5" onload="f_create();">
		<center>
			<form name="loginForm" onSubmit="return login_validate();"
				action="Register" method="post">
				<table width="900" border="0" style="border: solid gray 1pt solid;"
					cellpadding="0" cellspacing="0">
					<tr> <td height="76"> <%@ include file="head.jsp"%> </td> </tr>
					<tr valign="top" height="300" >
						<td align="center">
							<table width="100%" height="42" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="bottom" align="center">										
										<img src="images/1.jpg" width="791" height="35">
									</td>
								</tr>
							</table>
							<table width="791" border="0" cellpadding="0" cellspacing="0" background="images/2.jpg">
								<tr>
									<td height="63" align="center">
											<p> <b class="c_a">员工注册</b> </p>
									</td>
								</tr>
							</table>
							<table width="791" height="205" border="0" cellpadding="0" cellspacing="0" background="images/3.jpg">
								<tr>
									<td width="46%" height="27" align="right">
										员工编号：<span class="c_b">*</span>
									</td>
									<td width="54%">
										<input name="eid" type="text" size="20" maxlength="16">
									</td>
								</tr>
								<tr>
									<td width="46%" height="27" align="right">
										登陆密码：<span class="c_b">*</span>
									</td>
									<td width="54%">
										<input type="password" name="password" size="20" >
									</td>
								</tr>
								<tr>
									<td width="46%" height="27" align="right">
										确认密码：<span class="c_b">*</span>
									</td>
									<td width="54%">
										<input name="repassword" type="password" size="20" maxlength="16" >
									</td>
								</tr>
								
								<tr>
									<td width="46%" height="27" align="right">
										员工姓名：<span class="c_b">*</span>
									</td>
									<td width="54%">
										<input name="trueName" type="text" size="20" maxlength="16">
									</td>
								</tr>
								<tr>
									<td width="46%" height="27" align="right">
										找回密码问题：
									</td>
									<td width="54%">
										<input type="text" name="question" size="20">
									</td>
								</tr>
								<tr>
									<td width="46%" height="27" align="right">
										问题答案：
									</td>
									<td width="54%">
										<input type="text" name="result" size="20">
									</td>
								</tr>
								<tr>
									<td width="46%" height="27" align="right">
										验证码：
									</td>
									<td width="54%">
										<input type="text" name="randcode" size="6" onkeyup="f_change(this.value)"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         >
										<img src="Code" alt="验证码"/><span id="i_code"></span>
									</td>
								</tr>
								<tr>
									<td height="16" colspan="2" align="center">
		                                <input type="button" value="返回登陆" onclick="window.location.replace('login.jsp')"/>
										<input type="reset" value="重置">
										<input type="submit" value="注册" >
									</td>
								</tr>
							</table>
							<table width="100%" height="42" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td valign="top" align="center">
										<img src="images/1.jpg" width="791" height="35">
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
		</center>
	</body>
</html>
