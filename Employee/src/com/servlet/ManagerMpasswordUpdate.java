package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoImpl.ManagerDaoImpl;
import com.entity.Manager;

public class ManagerMpasswordUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager manager = (Manager)request.getSession().getAttribute("manager");
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String newPsw = request.getParameter("newPsw");
		String reNewPsw = request.getParameter("reNewPsw");
		String code = request.getParameter("code");
		String trueCode = (String)request.getSession().getAttribute("code");
		if(code.equalsIgnoreCase(trueCode)){
			if(newPsw.equals(reNewPsw)){
				if(mid.equals(manager.getMid()+"")){
					ManagerDaoImpl mdi = new ManagerDaoImpl();
					int n = mdi.managerLogin(manager.getMname(), mpassword);
					if(n==1){
						boolean flag = mdi.mupdatePassword(Integer.parseInt(mid), newPsw);
						if(flag){
							response.sendRedirect("manager_login.jsp");
						}
					}else if(n==2){
						response.sendRedirect("manager/mpassword_update.jsp");
					}
				}else{
					response.sendRedirect("manager/mpassword_update.jsp");
				}
			}else{
				response.sendRedirect("manager/mpassword_update.jsp");
			}
		}else{
			response.sendRedirect("manager/mpassword_update.jsp");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
