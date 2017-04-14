<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- 使用strut2标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<frameset rows="90,*" framespacing="0px" frameborder="no">
	<frame name="top"
		src="${pageContext.request.contextPath }/frame/top.jsp">
	<frameset cols="40,170" id="main" framespacing="0px" frameborder="no">

		<frame name="left"
			src="${pageContext.request.contextPath }/frame/left.jsp">
		<frame name="right"
			src="${pageContext.request.contextPath }/frame/right.jsp">
	</frameset>
</frameset>



<!-- 

<frameset rows="90,*" framespacing="0px" frameborder="no">
    <frame name="top" src="${pageContext.request.contextPath }/frame/top.jsp" scrolling="no">
    <frameset cols="170,90" id="main" framespacing="0px" frameborder="no">
   	<frame name="left" src="${pageContext.request.contextPath }/frame/left.jsp" scrolling="no"> 
  	<frame name="right" src="${pageContext.request.contextPath }/frame/right.jsp" scrolling="no">
   </frameset>
</frameset>
 -->