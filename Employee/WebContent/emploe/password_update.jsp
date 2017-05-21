<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>更改密码</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
		</style>
		<script language="javascript" src="../js/validate.js"></script>
	</head>

	<body bgcolor="#6CA6CD">
			<table width="900" border="0" align="center">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="25"  bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="show_self.jsp" class="STYLE1">基本信息</a> &gt;&gt; 更改密码</span>					
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：${sessionScope.emploe.ename }</span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>
				</tr>
				<tr valign="top" height="500" >
					<td height="254" colspan="2" align="center">
						<br><br>
						<form  action="../EmploePasswordUpdate" method="post">
							<table width="500" height="240" border="0" align="center" background="../images/login_3.jpg" >								
								<tr><td colspan="3" height="25"></td></tr>																	
								<tr>								
									<td height="25" width="37%">
										<div align="right">
											员工编号：
										</div>
									</td>
									<td width="65%">
										<input type="text" name="eid" size="20" value="${sessionScope.emploe.eid }" readonly="readonly"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
										原始密码：
									</td>
									<td>
										<input type="password" name="epassword" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
										改名密码：
									</td>
									<td>
										<input type="password" name="newpsw" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
										确认密码：
									</td>
									<td>
										<input type="password" name="newpsw2" size="20"/>
									</td>
								</tr>
								<tr>
									<td height="25" align="right">
											验证码：
									</td>
									<td width="20%">
										<input name="randcode" type="text" size=6>
										<img src="../Code" />
									</td>
								</tr>				
								<tr>
									<td height="25">
										<div align="right"></div>
									</td>
									<td >
										<input type="submit" name="submit" value="更改"/>
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
	</body>
</html>
