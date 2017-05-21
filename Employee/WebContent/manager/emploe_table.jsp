  <%@ page language="java" import="java.util.*,com.entity.*,com.daoImpl.*"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>管理员主页</title>
		<script language="javascript" src="../js/validate.js"></script>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; font-size: 12pt; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 12pt; height: 28pt; }			
			.STYLE3 { font-family: "宋体"; font-size: 12pt; height: 23pt; }
			.STYLE4 { font-family: "宋体"; font-size: 13pt; }
			.STYLE5 { font-family: "宋体"; font-size: 18px;color: green}
		</style>
	</head>

	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="28" bgcolor=#6C7B8B align="left" class="STYLE1"  width="30%">
						当前用户：<%=session.getAttribute("mname")%>
					</td>	
					<td height="28" bgcolor=#6C7B8B align="right"  width="70%">
						<input type="button" value="消息管理" class="STYLE5" onclick="window.location.replace('../NewsTable')"/>
						<input type="button" value="部门管理" class="STYLE5" onclick="window.location.replace('../ManagerDeptTable')"/>
						<input type="button" value="添加员工" class="STYLE5" onclick="window.location.replace('../ManagerEmploeTable_add')"/>
						<input type="button" value="账号管理" style="color:red" onclick="window.location.replace('show_manager.jsp')"/>
						<input type="button" value="退出登录" style="color:red"/>
					</td>
				</tr>
				<tr>
					<td height="254" colspan="2" valign="top">
						<table width="100%" border="0">
							<tr>
								<td height="30" colspan="5" class="STYLE4" align="center">
									<br>
									<form action="../SearchEmploe" method="post">
										信息快速检索：
										姓名： <input type="text" name="ename" style="width: 80px; height: 20px;">&nbsp;&nbsp; 
										员工编号: <input type="text" name="eid" style="width: 60px; height: 20px;">&nbsp;&nbsp; 
										部门： <select name="dname" style="width: 110px;">
												<option value="" selected="selected"> -- 请选择 -- </option>
													<c:forEach var="dept" items="${sessionScope.deptList }">
														<option value="${dept.dname }"> -- ${dept.dname } -- </option>
													</c:forEach>
										    </select>
										<input type="submit" value="查询">
									</form>
									<br>
								</td>
							</tr>
							<tr align="center">
								<td width="58%" height="36" class="STYLE4" align="left">
<!-- 显示一共多少页，一共多少员工 ------------->		           第${sessionScope.pageNow }页 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 共${sessionScope.lineCount}名员工
								</td>
								<td width="5%">
									<input type="button" value="首页" onclick="location.replace('../EmploeTable?n=1')">
								</td>
								<td width="5%">
									<input type="button" value="上一页" onclick="location.replace('../EmploeTable?n=${sessionScope.pageNow - 1 }')">
								</td>
								<td width="5%">
									<input type="button" value="下一页" onclick="location.replace('../EmploeTable?n=${sessionScope.pageNow + 1 }')">
								</td>
								<td width="5%">
									<input type="button" value="尾页" onclick="location.replace('../EmploeTable?n=${sessionScope.pageCount}')">
								</td>
							</tr>
							<tr valign="middle" align="center">
								<td colspan="5">
									<table width="100%" border="3" bordercolor="#6C7B8B" style="border-collapse: collapse; border-spacing: 0;">
										<tr>
											<th width="10%" class="STYLE2">
												图像
											</th>
											<th width="10%" class="STYLE2">
												姓名
											</th>
											<th width="10%" class="STYLE2">
												员工编号
											</th>
											<th width="14%" class="STYLE2">
												部门
											</th>
											<th width="14%" class="STYLE2">
												联系电话
											</th>	
											<th colspan="3" class="STYLE2">
												业务操作
											</th>
										</tr>
<!-- 循环输出数据库中数据 ------------------------------------------------------->	
										<%
											ArrayList<Emploe> listByPage = (ArrayList<Emploe>)session.getAttribute("listByPage");
											DeptDaoImpl pdi = new DeptDaoImpl();
											for(Emploe emploe : listByPage){
										%>
										<tr align="center">
											<td class="STYLE3">
												<img src="<%=emploe.getEphoto() %>" width="50" height="50"/>
											</td>
											<td class="STYLE3">
											<%=emploe.getEname() %>	
											</td>
											<td class="STYLE3">
											<%=emploe.getEid() %>	
											</td>
											<td class="STYLE3">
											<%
												Dept dept = pdi.getDeptById(emploe.getDid());
												out.print(dept.getDname());
											
											 %>
											</td>
											<td class="STYLE3">
											<%=emploe.getEphone() %>
											</td>
											<td width="7%" class="STYLE3">
												<a href="../EmploeDetail?eid=<%=emploe.getEid() %>"><img src="../images/detail.gif"/></a>
											</td>
											<td width="7%" class="STYLE3">
												<a href="../ManagerShowSelf?eid=<%=emploe.getEid() %>"><img src="../images/modify.gif" width="25"/></a>
											</td>
											<td width="7%" class="STYLE3">	
												<a href="../EmploeRemove?eid=<%=emploe.getEid() %>"><img src="../images/del.gif" width="25" onclick="return f_delete();"/></a>			
											</td>
										</tr>
										<% 
											}
										%>
										
<!-- ---------------------------------------------------------------------------------------------- -->													
									</table>		
								</td>
							</tr>
						</table>
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
