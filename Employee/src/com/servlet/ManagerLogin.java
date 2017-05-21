package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.ManagerDaoImpl;
import com.entity.Manager;

public class ManagerLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String mname = request.getParameter("mname");
		String mpassword = request.getParameter("mpassword");
		String code = request.getParameter("code");
		String trueCode = (String)request.getSession().getAttribute("code");
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		if(code.equalsIgnoreCase(trueCode)){
			out.print("<font color='green'>¡Ì</font>");
			int n = mdi.managerLogin(mname, mpassword);
			System.out.println(n);
			if(n==1){
				Manager manager = mdi.getMangerByName(mname);
				request.getSession().setAttribute("mname", mname);
				request.getSession().setAttribute("manager", manager);
				response.sendRedirect("EmploeTable");
			}else if(n==2){
				response.sendRedirect("manager_login.jsp");
			}else{
				response.sendRedirect("manager_login.jsp");
			}
		}else{
			out.print("<font color='red'>¡Á</font>");
			response.sendRedirect("manager_login.jsp");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
