<%@ page language="java" import="java.util.*,com.entity.*,com.daoImpl.*"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>部门管理</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; font-size: 12pt; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 12pt; height: 28pt; }			
		</style>
		<script type="text/javascript">
			function f_confirm(){
				confirm("确定删除");
			}
		</script>
	</head>

	<body bgcolor="#6CA6CD">
		<center>
			<table width="900" style="border: solid gray 1pt solid;">
				<tr> <td height="76" colspan="2"> <%@ include file="../head.jsp"%> </td> </tr>
				<tr>
					<td height="29" bgcolor="#6C7B8B">
						<span class="STYLE1">当前位置：<a href="../EmploeTable" class="STYLE1">基本信息</a> &gt;&gt; 部门管理</span>	
					</td>
					<td height="29" bgcolor="#6C7B8B" align="right">
						<span class="STYLE1">当前用户：<%=session.getAttribute("mname")%></span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" colspan="2">
						<table width="100%" border="0">
							<tr align="center">
								<td width="58%" height="36" class="STYLE4" align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		                                                                 第${sessionScope.pageNow}页 ; 共${sessionScope.lineCount}个部门
      		                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		                        <input type="button"  value="添加部门" onclick="window.location.replace('../ManagerDeptTable_add')" style="color:green;font-size: 15px">
								</td>
								<td width="5%">
									<input type="button" value="首页" onclick="window.location.replace('../ManagerDeptTable?n=1')">
								</td>
								<td width="5%">
									<input type="button" value="上一页" onclick="window.location.replace('../ManagerDeptTable?n=${sessionScope.pageNow-1}')">
								</td>
								<td width="5%">
									<input type="button" value="下一页" onclick="window.location.replace('../ManagerDeptTable?n=${sessionScope.pageNow+1}')">
								</td>
								<td width="5%">
									<input type="button" value="尾页" onclick="window.location.replace('../ManagerDeptTable?n=${sessionScope.pageCount}')">
								</td>
							</tr>
							<tr valign="middle" align="center">
								<td colspan="5">
									<table width="80%" border="3" bordercolor="#6C7B8B" style="border-collapse: collapse; border-spacing: 0;">
										<tr>
											<th width="15%" class="STYLE2">
												部门编号
											</th>
											<th width="15%" class="STYLE2">
												部门名称
											</th>
											<th width="15%" class="STYLE2">
												部门人数
											</th>
											<th width="15%" class="STYLE2">
												部门地址
											</th>
											<th width="15%" class="STYLE2">
												部门经理
											</th>
											<th  class="STYLE2" colspan="2">
												操作
											</th>	
										</tr>
<!-- 循环输出数据库中数据 ------------------------------------------------------->	
										<%
											ArrayList<Dept> deptlist = (ArrayList<Dept>)session.getAttribute("deptlist");
											EmploeDaoImpl edi = new EmploeDaoImpl();
											for(Dept dept : deptlist){
										%>
										
										<tr align="center">
											<td>
												<%=dept.getDid() %>
											</td>
											<td>
												<%=dept.getDname() %>
											</td>
											<td >
												<%=dept.getDnumber() %>
											</td>
											<td >
												<%=dept.getDaddr() %>
											</td>
											<td >
												<%
													Emploe emploe = edi.getEmploeById(dept.getEid());
													out.print(emploe.getEname());
												 %>
											</td>
											
											<td width="7%" class="STYLE3">
												<a href="../ManagerDeptUpdate?did=<%=dept.getDid() %></a>"><img src="../images/modify.gif"  width="15" /></a>
											</td>
											<td width="7%" class="STYLE3">	
												<a href="#" onclick="return f_confirm();"><img src="../images/del.gif" width="20"/></a>			
											</td>
										</tr>
										<% 	
											}
										 %>
<!-------------------------------------------------->	
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
