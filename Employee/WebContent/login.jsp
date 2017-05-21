<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String name = "";
	String psw = "";
	Cookie[] cc = request.getCookies();
	if(cc.length<1){
	}else{
		for(Cookie c : cc ){
				if(c.getName().equals("username")){
					name = c.getValue();
				}
				if(c.getName().equals("password")){
					psw = c.getValue();
				}
		}
	}
 %>
<html>
	<head>
		<title>员工登录</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
		</style>
		<script language="javascript" src="js/validate.js"></script>
		<script language="javascript" src="js/ajax.js"></script>
	</head>

	<body bgcolor="#5CC9F5" onload="f_create();">
		<center>
			<form name="loginForm" onSubmit="return login_validate()" action="Login" method="post">
				<table width="900" border="0" style="border: solid gray 1pt solid;" cellpadding="0" cellspacing="0">
					<tr><td height="76"> <%@ include file="head.jsp"%> </td> </tr>
					<tr>
						<td height="25" colspan="3" bgcolor="#6C7B8B">
							<a href="index.jsp"><span class="STYLE1">欢迎使用</span></a><span class="STYLE1">&gt;&gt;&gt;&gt;&gt;员工登陆</span>
						</td>
					</tr>
					<tr valign="top" height="500" >
						<td height="254">
							<br><br>
							<table width="437" height="247" border="0" align="center" background="images/login_1.jpg" >								
								<tr><td colspan="3" height="25"></td></tr>																	
								<tr>								
									<td height="25" width="37%">
										<div align="right">
											用户名：
										</div>
									</td>
									<td width="65%">
										<input type="text" name="username" size="20" value="<%=name %>"/>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right">
											密&nbsp;&nbsp;码：
										</div>
									</td>
									<td>
										<input type="password" name="password" size="20" value="<%=psw %>"/>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right">
											验证码：
										</div>
									</td>
									<td width="20%">
										<input name="randcode" type="text" size=6 onkeyup="f_change(this.value)">
										<img src="Code" /><span id="i_code"></span>
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right"></div>
									</td>
									<td >
										<input type="radio" name="autologin" value="auto" >
										保存密码
									</td>
								</tr>
								<tr>
									<td height="25">
										<div align="right"></div>
									</td>
									<td >
										<input name="register" type="button" value="注册" 
											onclick="window.location.replace('register.jsp')"/>
										&nbsp;&nbsp;
										<input type="submit" name="submit" value="登录"
											onclick="return login_validate();" />
										&nbsp;&nbsp;
										<a href="findpassword.jsp"><span style="color: red">忘记密码</span></a>
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
