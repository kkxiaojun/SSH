<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>更新信息</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 20px}
    	</style>
    	<script type="text/javascript" src = "../js/showdate.js"></script>
		<script language="javascript" src="../js/validate.js"></script>
	</head>

	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" border="0" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="show_self.jsp" class="STYLE1">基本信息</a> &gt;&gt; 更新信息</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：${sessionScope.emploe.ename }</span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" colspan="2" align="center">
						<form action="../EmploeUpdateSelf" onSubmit="return emploe_validate()">
							<table width="60%" border="0" style="background-image: url(../images/formbj3.jpg)">
								<tr>
									<td class="STYLE2" colspan="2">
										自己基本信息：
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										员工编号：
									</td>
									<td width="65%" align="left">
										<input name="eid" type="text" readonly="readonly" value="${sessionScope.emploe.eid }" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										姓名：
									</td>
									<td width="65%" align="left">
										<input name="ename" type="text" value="${sessionScope.emploe.ename}" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										薪水：
									</td>
									<td width="65%" align="left">
										<input name="esalary" type="text" value="0.0"  readonly="readonly"/>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										性别：
									</td>
									<td width="65%" align="left">
										<img src="../images/nan.png" height=20 width=20/>男
										<input type="radio" name="esex" value="男" >
										<img src="../images/nv.png" height=20 width=20/>女
										<input type="radio" name="esex" value="女">
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										生日：
									</td>
									<td width="65%" align="left">
										<input name="ebir" type="text" value="" id="time" onclick="return Calendar('time')" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										婚否：
									</td>
									<td width="65%" align="left">
										<img src="../images/yes.png" height=20 width=20/>已婚
										<input type="radio" name="emarry" value="已婚" >
										<img src="../images/no.png" height=20 width=20/>未婚
										<input type="radio" name="emarry" value="未婚">
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										学历：
									</td>
									<td width="65%" align="left">
										<select name="eedu"  style="width: 156px" >
											<option value="" selected="selected"> -- 请选择 -- </option>
											<option value="无" > -- 无 -- </option>
											<option value="小学" > -- 小学 -- </option>
											<option value="初中" > -- 初中 -- </option>
											<option value="高中" > -- 高中 -- </option>
											<option value="专科" > -- 专科 -- </option>
											<option value="本科" > -- 本科 -- </option>
											<option value="研究生" > -- 研究生 -- </option>
											<option value="博士生" > -- 博士生 -- </option>
											<option value="博士后" > -- 博士后 -- </option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										部门：
									</td>
									<td width="65%" align="left">
										<select name="did" style="width: 156px" >
											<option value="" selected="selected"> -- 请选择 -- </option>
											<c:forEach var="dept" items="${sessionScope.deptList}">
											<option value="<c:out value='${dept.did}'/>" ><c:out value="${dept.dname}"/></option>		
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										职位：
									</td>
									<td width="65%" align="left">
										<select name="pid"  style="width: 156px" >
											<option value="" selected="selected"> -- 请选择 -- </option>
											<c:forEach var="post" items="${sessionScope.postList}">
											<option value="<c:out value='${post.pid}'/>" ><c:out value="${post.pname}"/></option>		
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										电话：
									</td>
									<td width="65%" align="left">
										<input name="ephone" type="text" value="" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										地址：
									</td>
									<td width="65%" align="left">
										<input name="eaddr" type="text" value="" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										找回密码问题：
									</td>
									<td width="65%" align="left">
										<input name="equestion" type="text" value="${sessionScope.emploe.equestion}" />
									</td>
								</tr>
								<tr>
									<td width="35%" align="right">
										问题答案：
									</td>
									<td width="65%" align="left">
										<input name="eanswer" type="text" value="${sessionScope.emploe.eanswer }" />
									</td>
								</tr>							
								<tr>	
									<td width="35%" align="right"> </td>
									<td width="65%" align="left">
										<input type="submit" value="更新自己信息" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" value="注销账户" style="color: red;font-size: 10px" onclick="windows.location.replace('../EmploeLog_off?eid=${sessionScope.emploe.eid }')"/>
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
