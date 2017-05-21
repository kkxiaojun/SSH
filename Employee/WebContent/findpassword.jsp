<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>找回密码</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
		</style>
		<script language="javascript" src="js/validate.js"></script>
		<script language="javascript" src="js/ajax.js"></script>
	</head>

	<body bgcolor="#6CA6CD" onload="f_create();">
		<center>
			<form name="loginForm" action="FindPassword" method="post">
				<table width="900" border="0" >
					<tr> <td height="76"> <%@ include file="head.jsp"%> </td> </tr>
					<tr>
						<td height="25" colspan="3" bgcolor="#6C7B8B">
							<a href="index.jsp"><span class="STYLE1">欢迎使用</span></a><span class="STYLE1">&gt;&gt;&gt;&gt;&gt;找回密码</span>
						</td>
					</tr>
					<tr valign="top" height="500" >
						<td height="254">
							<br><br>
							<table width="500" height="240" border="0" align="center" background="images/login_2.jpg" >								
								<tr><td colspan="3" height="25"></td></tr>																	
								<tr>								
									<td height="25" width="37%" align="right">
										员工编号：
									</td>
									<td width="65%">
										<input type="text" name="eid" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
										预留问题：
									</td>
									<td>
										<input type="text" name="equestion" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
										答&nbsp;&nbsp;案：
									</td>
									<td>
										<input type="text" name="eanswer" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
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
										<td height="25"></td>
									<td >
										<input  type="reset" value="清空"/>
										&nbsp;&nbsp;
										<input type="submit" name="submit" value="找回密码"/>
										&nbsp;&nbsp;
										<a href="login.jsp">返回登陆</a>
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
