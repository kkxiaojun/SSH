<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>发布消息</title>
		<script language="javascript" src="../js/validate.js"></script>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 20px}
		</style>		
	</head>
	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0"">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="show_self.jsp" class="STYLE1">基本信息</a> &gt;&gt; <a href="news_table.jsp" class="STYLE1">留言消息表</a>&gt;&gt; 发布消息</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：${sessionScope.emploe.ename }</span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" align="center" colspan="2">
						<form action="../EmploeNewsAdd" method="post" onSubmit="return emploe_validate()">
							<table width="60%" border="0" style="background-image: url(../images/formbj1.jpg)">
								<tr>
									<td class="STYLE2" colspan="2">
										发布信息：
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										消息主题：
									</td>
									<td width="65%" align="left">
										<input name="mtitle" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										发送人：
									</td>
									<td width="65%" align="left">
										<input name="muser" type="text"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										内容：
									</td>
									<td width="65%" align="left">
										<textarea rows="10" cols="19" name="mcontent"></textarea>
									</td>
								</tr>																														
								<tr>
									<td width="35%" align="right"> </td>
									<td width="65%" align="left">
									<input type="reset" value="清空"/>
										<input type="submit" value="发布" />
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
