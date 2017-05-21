<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head>
		<title>更新信息</title>
		<style type="text/css">
			.STYLE1 { color: #FFFFFF; font-weight: bold; font-family: "楷体_GB2312"; }
			.STYLE2 { font-family: "楷体_GB2312"; font-weight: bold; font-size: 20px}
    	</style>
    	<script type="text/javascript">
	    	function check(){
	    		var v = document.getElementsByName("img");
	    		for(var i = 0; i < v.length; i++){
	    			if(v[i].checked){
	    				return true;
	    			}
	    		}
	    		alert("请选头像");
	    		return false;
	    	}
    	</script>
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
						<span class="STYLE1">当前用户：<%=session.getAttribute("username")%></span>
						<input type="button" name="back" value="退出登陆" onclick="window.location.replace('../index.jsp')">
					</td>	
				</tr>
				<tr>
					<td height="254" colspan="2" align="center">
  						<p class="STYLE2">请选择图像：</p> 
						<form name="form1" action="../EmploeUpdatePhoto" onsubmit="return check();" method="post">
						   <table border=1>
						   	<tr>
						   		<td><img src="../images/photo/photo1.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo2.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo3.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo4.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo5.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo6.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo7.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo8.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo9.png" width="50" height="50"/></td>
						   		<td><img src="../images/photo/photo10.png" width="50" height="50"/></td>
						       </tr>
						      	<tr>
						      		<td><input type="radio" name="img" value="../images/photo/photo1.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo2.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo3.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo4.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo5.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo6.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo7.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo8.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo9.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo10.png"/></td>
						      	</tr>
						       <tr>
						       		<td><img src="../images/photo/photo11.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo12.png" width="50" height="50"/></td>
						       		<td><img src="../images/photo/photo13.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo14.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo15.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo16.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo17.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo18.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo19.png" width="50" height="50"/></td>
						   			<td><img src="../images/photo/photo20.png" width="50" height="50"/></td>
						   		</tr>
						   		<tr>
						      		<td><input type="radio" name="img" value="../images/photo/photo11.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo12.png"/></td>						   		
						      		<td><input type="radio" name="img" value="../images/photo/photo13.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo14.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo15.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo16.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo17.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo18.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo19.png"/></td>
						      		<td><input type="radio" name="img" value="../images/photo/photo20.png"/></td>
						      	</tr>
						   </table>
						   <input type="hidden" name="eid" value="${param.eid}"/>
						  <input type="submit">
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
